import fitness.ConflictsFunction;
import individuals.ClassRoomIndividual;
import initializers.FixedSizeClassRoomInitializer;
import java.util.ArrayList;
import java.util.HashMap;
import metaheuristic.SimpleGeneticAlgorithm;
import operators.ClassRoomSinglePointCrossover;
import operators.ClassRoomSwapMutation;
import operators.RouletteWheelSelection;
import results.Results;

public class Jarvis {

  private static final int numberOfClass = 1;
  private static final int classSize = 20;
  private static final double mutationProbability = 1;
  private static final int maxIterations = 1000;
  private static final int maxIterationsNoImprovements = 0;

  public static void disponiPrenotazione(ArrayList<String> prenotazioniList) throws CloneNotSupportedException {

    ArrayList<Integer> placeholderList = new ArrayList<>();
    HashMap<String,String> map = new HashMap<>();

    for (String s : prenotazioniList){

      if (isSingolo(s))
        placeholderList.add(0);
      else
        placeholderList.add(1);

      map.put(s,"");

    }

    ConflictsFunction fitnessFunction = new ConflictsFunction();
    FixedSizeClassRoomInitializer
        initializer = new FixedSizeClassRoomInitializer(placeholderList,numberOfClass);
    RouletteWheelSelection<ClassRoomIndividual> selectionOperator = new RouletteWheelSelection<>();
    ClassRoomSinglePointCrossover crossoverOperator = new ClassRoomSinglePointCrossover();
    ClassRoomSwapMutation mutationOperator = new ClassRoomSwapMutation();

    SimpleGeneticAlgorithm<ClassRoomIndividual> geneticAlgorithm =
        new SimpleGeneticAlgorithm<>(fitnessFunction, initializer,
            selectionOperator, crossoverOperator, mutationOperator, mutationProbability,
            maxIterations, maxIterationsNoImprovements);
    Results<ClassRoomIndividual> results = geneticAlgorithm.run();
    ClassRoomIndividual bestIndividual = results.getBestIndividual();
    }

  private static boolean isSingolo(String s) {

    String[] array = s.split("-");
    String type = array[array.length-1];
    boolean singolo = true;

    if (type.equalsIgnoreCase("G"))
      singolo = false;

    return singolo;

  }


}
