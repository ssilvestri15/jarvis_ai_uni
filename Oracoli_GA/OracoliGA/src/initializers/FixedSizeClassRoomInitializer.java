package initializers;


import individuals.ClassRoomIndividual;
import java.util.ArrayList;
import populations.FixedSizePopulation;
import populations.Population;

/**
 *
 * Viene inizializzata la popolazione
 *
 */

public class FixedSizeClassRoomInitializer extends Initializer<ClassRoomIndividual> {

  private final int[] list;

  private final int numberOfIndividuals;

  public FixedSizeClassRoomInitializer(int[] list, int numberOfIndividuals) {
    this.list = list;
    this.numberOfIndividuals = numberOfIndividuals;
  }

  @Override
  public Population<ClassRoomIndividual> initialize() {

    FixedSizePopulation<ClassRoomIndividual> population = new FixedSizePopulation<>(0, numberOfIndividuals);

    ClassRoomIndividual individual = new ClassRoomIndividual(list);
    population.add(individual);

    return population;
  }

}

