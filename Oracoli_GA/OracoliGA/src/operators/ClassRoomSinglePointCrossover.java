package operators;

import individuals.ClassRoomIndividual;
import populations.Population;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ClassRoomSinglePointCrossover extends CrossoverOperator<ClassRoomIndividual> {

  @Override
  public Population<ClassRoomIndividual> apply(Population<ClassRoomIndividual> population,
                                               Random rand) throws CloneNotSupportedException {
    Population<ClassRoomIndividual> offsprings = population.clone();
    offsprings.setId(population.getId() + 1);
    offsprings.clear();

    // Cross parents
    List<Pairing> pairings = makeRandomPairings(population);
    for (Pairing pairing : pairings) {
      int[] firstCoding = pairing.firstParent.getCoding();
      int[] secondCoding = pairing.secondParent.getCoding();
      int minLength = Math.min(firstCoding.length, secondCoding.length);
      // e.g. if cutPoint = 1, then the cut occurs between 0 and 1, if cutpoint = 2, it occurs between 1 and 2, and so on...
      int cutPoint = rand.nextInt(minLength - 1) + 1;
      int[] firstCodingLeft = Arrays.copyOfRange(firstCoding, 0, cutPoint);
      int[] firstCodingRight = Arrays.copyOfRange(firstCoding, cutPoint, minLength);
      int[] secondCodingLeft = Arrays.copyOfRange(secondCoding, 0, cutPoint);
      int[] secondCodingRight = Arrays.copyOfRange(secondCoding, cutPoint, minLength);

      ClassRoomIndividual offspring1 = (ClassRoomIndividual) pairing.firstParent.clone();
      offspring1.setCoding(Stream.of(firstCodingLeft, secondCodingRight)
          .flatMapToInt(Arrays::stream)
          .toArray()
      );
      ClassRoomIndividual offspring2 = (ClassRoomIndividual) pairing.secondParent.clone();
      offspring2.setCoding(Stream.of(secondCodingLeft, firstCodingRight)
          .flatMapToInt(Arrays::stream)
          .toArray()
      );
      offsprings.add(offspring1);
      offsprings.add(offspring2);
    }
    return offsprings;
  }
}
