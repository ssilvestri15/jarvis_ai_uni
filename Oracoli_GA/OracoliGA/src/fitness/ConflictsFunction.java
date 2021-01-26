package fitness;


import individuals.ClassRoomIndividual;

/**
 *
 * In questa classe viene calcolata la fitness della popolazione
 *
 * */

public class ConflictsFunction extends FitnessFunction<ClassRoomIndividual> {

  public ConflictsFunction() {
    super(true);
  }

  /**
   *
   * Setta la fittness in base al numero dei conflitti
   *
   */

  @Override
  public void evaluate(ClassRoomIndividual individual) {
    int conflicts = getConflicts(individual.getCoding());
    individual.setFitness(conflicts);
  }


  /**
   *
   * getConflicts(int[] decode):
   *
   * è un metodo che restituisce un contatore (numero dei conflitti) che viene incrementato ogni volta che trova degli 1 adiacenti nell'array
   * e decrementato quando uno 0 si frappone tra due 1
   *
   * */

  private int getConflicts(int[] decode) {
    int conflict = 0;
    for (int i = 0; i < decode.length - 1; i++) {
      if (i == 0) {
        if (decode[i] == 1 && decode[i + 1] == 1) {
          conflict++;
        } else if (decode[i] == 1 && decode[i + 1] == 0) {
          conflict--;
        }
      } else {
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

