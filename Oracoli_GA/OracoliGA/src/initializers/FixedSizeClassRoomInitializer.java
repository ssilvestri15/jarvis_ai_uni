package initializers;


import individuals.ClassRoomIndividual;
import java.util.ArrayList;
import populations.FixedSizePopulation;
import populations.Population;

public class FixedSizeClassRoomInitializer extends Initializer<ClassRoomIndividual> {

  private final ArrayList<Integer> list;

  private final int numberOfIndividuals;

  public FixedSizeClassRoomInitializer(ArrayList<Integer> list, int numberOfIndividuals) {
    this.list = list;
    this.numberOfIndividuals = numberOfIndividuals;
  }

  @Override
  public Population<ClassRoomIndividual> initialize() {

    FixedSizePopulation<ClassRoomIndividual> population = new FixedSizePopulation<>(0, numberOfIndividuals);

    ClassRoomIndividual individual = new ClassRoomIndividual(toArray(list));
    population.add(individual);

    return population;
  }

  private int[] toArray (ArrayList<Integer> myList){

    int[] array = new int[myList.size()];

    for (int i = 0; i<myList.size(); i++) {
      array[i] = myList.get(i);
    }

    return array;

  }

}

