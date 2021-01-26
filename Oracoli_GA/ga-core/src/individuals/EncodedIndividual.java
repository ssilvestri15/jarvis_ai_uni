package individuals;



public class EncodedIndividual<T> extends Individual {

    protected T coding;

    public EncodedIndividual(T coding) {
        this.coding = coding;
    }

    public T getCoding() {

        return coding;
    }

    public void setCoding(T coding) {
        this.coding = coding;
    }

    @Override
    public String toString() {
        return "EncodedIndividual{" +
                "coding=" + coding +
                ", fitness=" + fitness +
                '}';
    }
}
