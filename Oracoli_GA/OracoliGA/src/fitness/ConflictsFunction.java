package fitness;


import individuals.ClassRoomIndividual;

public class ConflictsFunction extends FitnessFunction<ClassRoomIndividual> {

  public ConflictsFunction() {
    super(true);
  }

  @Override
  public void evaluate(ClassRoomIndividual individual) {
    int conflicts = getConflicts(individual.getCoding());
    individual.setFitness(conflicts);
  }


  private int getConflicts(int[] decode) {
    int conflict = 0;
    for (int i = 0; i < decode.length - 1; i++) {
      if (i == 0) {
        if (decode[i] == 1 && decode[i + 1] == 1) {
          conflict++;
        } else if (decode[i] == 1 && decode[i + 1] == 0) {
          conflict--;
        }
      } else if (i > 0) {
          if (decode[i] == 1 && decode[i + 1] == 1 || decode[i] == 1 && decode[i - 1] == 1) {
              conflict++;
          } else if (decode[i] == 1 && decode[i + 1] == 0 || decode[i] == 1 && decode[i - 1] == 0) {
              conflict--;
          }
      }

    }
    return conflict;
  }
}

