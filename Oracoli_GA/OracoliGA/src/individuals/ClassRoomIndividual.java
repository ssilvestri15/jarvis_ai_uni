package individuals;

import java.util.Arrays;


public class ClassRoomIndividual extends IntArrayIndividual {

  private static final int maxIndividuals = 20;

  /**
   *
   * Viene settata la popolazione
   *
   */

  public ClassRoomIndividual(int[] coding) {

    super(coding);
    setCoding(coding);

  }


  public int getMax() {
    return maxIndividuals;
  }

  @Override
  public String toString() {
    return "ClassRoomIndividual{" +
        super.toString() +
        " individuals=" + maxIndividuals +
        '}';
  }
}

