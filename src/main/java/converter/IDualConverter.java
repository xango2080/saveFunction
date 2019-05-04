package converter;

public interface IDualConverter<T, R> extends IConverter<T, R> {

    T reverseApply(R r);

}
