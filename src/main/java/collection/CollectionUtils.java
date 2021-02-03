package collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <T> T findLastItemOrNull(final Collection<T> t) {
        return findOptionalLastItem(t).orElse(null);
    }

    public static <T> Optional<T> findOptionalLastItem(final Collection<T> t) {
        return ofNullable(t)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .reduce((first, second) -> second);
    }

}
