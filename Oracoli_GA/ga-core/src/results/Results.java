package results;


import individuals.Individual;
import metaheuristic.GeneticAlgorithm;
import populations.Population;

import java.util.List;
import java.util.Stack;

public class Results<T extends Individual> {

    private final GeneticAlgorithm<T> geneticAlgorithm;
    private final Stack<Population<T>> generations;
    private final Population<T> bestGeneration;
    private final List<String> log;

    public Results(GeneticAlgorithm<T> geneticAlgorithm, Stack<Population<T>> generations, Population<T> bestGeneration, List<String> log) {
        this.geneticAlgorithm = geneticAlgorithm;
        this.generations = generations;
        this.bestGeneration = bestGeneration;
        this.log = log;
    }

    public GeneticAlgorithm<T> getGeneticAlgorithm() {
        return geneticAlgorithm;
    }

    public Stack<Population<T>> getGenerations() {
        return generations;
    }

    public Population<T> getBestGeneration() {
        return bestGeneration;
    }

    public List<String> getLog() {
        return log;
    }

    public int getNumberOfIterations() {
        return generations.size();
    }

    public T getBestIndividual() {
        return bestGeneration.getBestIndividual();
    }
}
