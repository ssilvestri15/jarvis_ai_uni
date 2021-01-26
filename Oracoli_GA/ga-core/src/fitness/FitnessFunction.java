

package fitness;

import individuals.Individual;
import populations.Population;

import java.util.Collections;

// The genetic T is the type of Individuals on which it could be applied
public abstract class FitnessFunction<T extends Individual> {

    private final boolean isMaximum;

    public FitnessFunction(boolean isMaximum) {
        this.isMaximum = isMaximum;
    }

    public void evaluate(Population<T> population) {
        for (T individual : population) {
            evaluate(individual);
        }

        T bestIndividual;
        if (isMaximum) {
            bestIndividual = Collections.max(population);
        } else {
            bestIndividual = Collections.min(population);
        }
        population.setBestIndividual(bestIndividual);
    }

    public abstract void evaluate(T individual);

    public boolean isMaximum() {
        return isMaximum;
    }
}
