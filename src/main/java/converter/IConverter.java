package converter;

import java.util.function.Function;

@FunctionalInterface
public interface IConverter<T, R> extends Function<T, R> {

}
