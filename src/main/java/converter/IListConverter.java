package converter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@FunctionalInterface
public interface IListConverter<T, R> extends IConverter<T, R> {

    default List<R> applyList(List<T> t) {
        return ofNullable(t)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(this)
                .filter(Objects::nonNull)
                .collect(toList());
    }
}
