package operators;


import individuals.ClassRoomIndividual;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ClassRoomSwapMutation extends RandomResettingMutation<ClassRoomIndividual> {

  @Override
  protected ClassRoomIndividual mutate(ClassRoomIndividual individual, Random rand)
      throws CloneNotSupportedException {

    int[] coding = individual.getCoding();
    int lenght = coding.length;

    Random r = new Random();
    int r0 = r.nextInt(lenght);
    Random rr = new Random();
    int r1 = rr.nextInt(lenght);
    while (r0 == r1) r1 = rr.nextInt(lenght);
    int temp = coding[r0];
    coding[r0] = coding[r1];
    coding[r1] = temp;

    ClassRoomIndividual mutatedIndividual = (ClassRoomIndividual) individual.clone();
    mutatedIndividual.setCoding(coding);

    return mutatedIndividual;
  }

}
