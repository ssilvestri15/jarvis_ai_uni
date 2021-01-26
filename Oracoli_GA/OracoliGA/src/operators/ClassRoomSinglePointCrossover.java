package operators;

import individuals.ClassRoomIndividual;
import populations.Population;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * Algoritmo di crossover
 *
 */

public class ClassRoomSinglePointCrossover extends CrossoverOperator<ClassRoomIndividual> {

  @Override
  public Population<ClassRoomIndividual> apply(Population<ClassRoomIndividual> population,
                                               Random rand) throws CloneNotSupportedException {


    //Clona la polazione
    Population<ClassRoomIndividual> offsprings = population.clone();

    //Cambia id della poplazione clonata
    offsprings.setId(population.getId() + 1);

    //Rimuove popolazione clonata
    offsprings.clear();

    // Incrocio i genitori
    // Nel nostro caso, la popolazione = 1 perchè abbiamo una sola classe da sistemare.
    // Viene quindi incorciata con se stessa
    List<Pairing> pairings = makeRandomPairings(population);

    for (Pairing pairing : pairings) {

      //Prende classe 1
      int[] firstCoding = pairing.firstParent.getCoding();

      //Prende classe 1
      int[] secondCoding = pairing.secondParent.getCoding();

      //Sono uguali, firstCoding.length == secondCoding.length == 20
      int minLength = Math.min(firstCoding.length, secondCoding.length);

      // cutPoint = valore random compreso tra 0 e 20
      int cutPoint = rand.nextInt(minLength - 1) + 1;

      //prende X prenotazioni da 0 a cutPoint
      int[] firstCodingLeft = Arrays.copyOfRange(firstCoding, 0, cutPoint);

      //prende X prenotazioni da cutPoint+1 a 20
      int[] firstCodingRight = Arrays.copyOfRange(firstCoding, cutPoint, minLength);

      //prende X prenotazioni da 0 a cutPoint
      int[] secondCodingLeft = Arrays.copyOfRange(secondCoding, 0, cutPoint);

      //prende X prenotazioni da cutPoint+1 a 20
      int[] secondCodingRight = Arrays.copyOfRange(secondCoding, cutPoint, minLength);

      //Clona la prima popolazione
      ClassRoomIndividual offspring1 = (ClassRoomIndividual) pairing.firstParent.clone();


      offspring1.setCoding(Stream.of(firstCodingLeft, secondCodingRight)
          .flatMapToInt(Arrays::stream)
          .toArray()
      );

      //Clona la seconda popolazione
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
