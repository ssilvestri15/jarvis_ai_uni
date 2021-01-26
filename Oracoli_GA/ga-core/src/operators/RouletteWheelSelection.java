package operators;


import individuals.Individual;
import populations.Population;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteWheelSelection<T extends Individual> extends SelectionOperator<T> {

    class WheelElement {
        protected final T individual;
        protected final double startPosition;
        protected final double size;

        protected WheelElement(T individual, double startPosition, double size) {
            this.individual = individual;
            this.startPosition = startPosition;
            this.size = size;
        }
    }

    @Override
    public Population<T> apply(Population<T> population, Random rand) throws CloneNotSupportedException {
        double totalFitness = population.stream()
                .map(Individual::getFitness)
                .reduce(Double::sum)
                .orElse(0.0);
        // This should happen for empty populations only
        if (totalFitness == 0.0) {
            return population;
        }

        // Wheel creation
        List<WheelElement> rouletteWheel = new ArrayList<>();
        double currentPosition = 0.0;
        for (T individual : population) {
            double relativeFitness = individual.getFitness() / totalFitness;
            WheelElement wheelElement = new WheelElement(individual, currentPosition, relativeFitness);
            rouletteWheel.add(wheelElement);
            currentPosition += relativeFitness;
        }

        // Spinning time!
        Population<T> newPopulation = population.clone();
        newPopulation.setId(population.getId() + 1);
        newPopulation.clear();
        for (int i = 0; i < rouletteWheel.size(); i++) {
            double pointer = rand.nextDouble();
            for (WheelElement element : rouletteWheel) {
                if (element.startPosition <= pointer && pointer < element.startPosition + element.size) {
                    T winner = element.individual;
                    newPopulation.add((T) winner.clone());
                    break;
                }
            }
        }
        return newPopulation;
    }
}
