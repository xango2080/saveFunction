package converter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public interface IDualListConverter<T, R> extends IDualConverter<T, R>, IListConverter<T, R> {

    default List<T> reverseApplyList(List<R> r) {
        return ofNullable(r)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(this::reverseApply)
                .filter(Objects::nonNull)
                .collect(toList());
    }
}
