package metaheuristic;


import fitness.FitnessFunction;
import individuals.Individual;
import initializers.Initializer;
import operators.CrossoverOperator;
import operators.MutationOperator;
import operators.SelectionOperator;

import results.Results;

public abstract class GeneticAlgorithm<T extends Individual> {

    private final FitnessFunction<T> fitnessFunction;
    private final Initializer<T> initializer;
    private final SelectionOperator<T> selectionOperator;
    private final CrossoverOperator<T> crossoverOperator;
    private final MutationOperator<T> mutationOperator;

    public GeneticAlgorithm(FitnessFunction<T> fitnessFunction, Initializer<T> initializer,
                            SelectionOperator<T> selectionOperator, CrossoverOperator<T> crossoverOperator,
                            MutationOperator<T> mutationOperator) {
        this.fitnessFunction = fitnessFunction;
        this.initializer = initializer;
        this.selectionOperator = selectionOperator;
        this.crossoverOperator = crossoverOperator;
        this.mutationOperator = mutationOperator;
    }

    public abstract Results<T> run() throws CloneNotSupportedException;

    public FitnessFunction<T> getFitnessFunction() {
        return fitnessFunction;
    }

    public Initializer<T> getInitializer() {
        return initializer;
    }

    public SelectionOperator<T> getSelectionOperator() {
        return selectionOperator;
    }

    public CrossoverOperator<T> getCrossoverOperator() {
        return crossoverOperator;
    }

    public MutationOperator<T> getMutationOperator() {
        return mutationOperator;
    }
}

