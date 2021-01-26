package individuals;

public abstract class StringIndividual<T> extends EncodedIndividual<String> {

    public StringIndividual(String coding) {
        super(coding);
    }

    public abstract T decode();
}
