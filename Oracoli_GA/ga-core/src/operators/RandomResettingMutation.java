package operators;


import individuals.Individual;
import populations.Population;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class RandomResettingMutation<T extends Individual> extends MutationOperator<T> {

    @Override
    public Population<T> apply(Population<T> population, Random rand) throws CloneNotSupportedException {
        List<T> populationList = new ArrayList<>(population);
        T chosenIndividual = populationList.get(rand.nextInt(populationList.size()));
        T mutatedIndividual = mutate(chosenIndividual, rand);
        populationList.remove(chosenIndividual);
        populationList.add(mutatedIndividual);

        Population<T> newPopulation = population.clone();
        newPopulation.setId(population.getId() + 1);
        newPopulation.clear();
        newPopulation.addAll(populationList);
        return newPopulation;
    }

    protected abstract T mutate(T individual, Random rand) throws CloneNotSupportedException;
}
