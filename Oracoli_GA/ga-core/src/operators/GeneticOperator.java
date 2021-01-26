package operators;

import individuals.Individual;
import populations.Population;

import java.util.Random;

public abstract class GeneticOperator<T extends Individual> {

    public abstract Population<T> apply(Population<T> population, Random rand) throws CloneNotSupportedException;

}
