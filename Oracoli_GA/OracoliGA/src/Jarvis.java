import fitness.ConflictsFunction;
import individuals.ClassRoomIndividual;
import initializers.FixedSizeClassRoomInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import metaheuristic.SimpleGeneticAlgorithm;
import operators.ClassRoomSinglePointCrossover;
import operators.ClassRoomSwapMutation;
import operators.RouletteWheelSelection;
import results.Results;

public class Jarvis {

  private static final int numberOfClass = 1;
  private static final double mutationProbability = 1;
  private static final int maxIterations = 1000;
  private static final int maxIterationsNoImprovements = 500;

  public static int[] disponiPrenotazione(int[] list) throws CloneNotSupportedException {

    // -----------> FITNESS
    ConflictsFunction fitnessFunction = new ConflictsFunction();

    // -----------> INIZIALIZZO POPOLAZIONE
    FixedSizeClassRoomInitializer
        initializer = new FixedSizeClassRoomInitializer(list, numberOfClass);

    // -----------> ROULETTE
    RouletteWheelSelection<ClassRoomIndividual> selectionOperator = new RouletteWheelSelection<>();

    // -----------> CROSSOVER
    ClassRoomSinglePointCrossover crossoverOperator = new ClassRoomSinglePointCrossover();

    // -----------> MUTATION
    ClassRoomSwapMutation mutationOperator = new ClassRoomSwapMutation();

    // -----------> ALGORITMO GENETICO
    SimpleGeneticAlgorithm<ClassRoomIndividual> geneticAlgorithm =
        new SimpleGeneticAlgorithm<>(fitnessFunction, initializer,
            selectionOperator, crossoverOperator, mutationOperator, mutationProbability,
            maxIterations, maxIterationsNoImprovements);

    // -----------> RISULTATO
    Results<ClassRoomIndividual> results = geneticAlgorithm.run();

    // -----------> MIGLIORE
    ClassRoomIndividual bestIndividual = results.getBestIndividual();

    System.out.println("\nPOPOLAZIONE INIZIALE: "+ Arrays.toString(list));
    System.out.println("\nMIGLIOR INDIVIDUO:    "+ Arrays.toString(bestIndividual.getCoding()) + " Fitness: "+bestIndividual.getFitness());

    return bestIndividual.getCoding();

  }


}
