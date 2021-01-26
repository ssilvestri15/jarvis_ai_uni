package populations;


import individuals.Individual;

public class FixedSizePopulation<T extends Individual> extends Population<T> {

    private final int maxSize;

    public FixedSizePopulation(long id, int maxSize) {
        super(id);
        this.maxSize = Math.max(maxSize, 0);
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public boolean add(T individual) {
        if (0 < maxSize && maxSize <= size()) {
            return false;
        }
        super.add(individual);
        return true;
    }

}
