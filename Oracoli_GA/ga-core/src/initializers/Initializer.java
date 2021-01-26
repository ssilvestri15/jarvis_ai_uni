package initializers;


import individuals.Individual;
import populations.Population;

public abstract class Initializer<T extends Individual> {

    public abstract Population<T> initialize();

}

