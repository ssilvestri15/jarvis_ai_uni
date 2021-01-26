package individuals;

import java.util.Arrays;


public class ClassRoomIndividual extends IntArrayIndividual {

  private static final int maxIndividuals = 20;

  public ClassRoomIndividual(int[] coding) {
    super(coding);


    int[] newCoding = Arrays.copyOf(coding, 20);

    setCoding(newCoding);
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

