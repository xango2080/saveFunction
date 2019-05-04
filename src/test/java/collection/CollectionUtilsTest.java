package collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class CollectionUtilsTest {

    @Test
    public void findLastItemOrNull_should_return_null_when_empty_list() {
        String result = CollectionUtils.findLastItemOrNull(new ArrayList<String>());

        assertNull(result);
    }

    @Test
    public void findLastItemOrNull_should_return_null_when_null() {
        String result = CollectionUtils.findLastItemOrNull(null);

        assertNull(result);
    }

    @Test
    public void findLastItemOrNull_should_return_null_when_list_of_null() {
        String result = CollectionUtils.findLastItemOrNull(asList(null, null, null));

        assertNull(result);
    }

    @Test
    public void findLastItemOrNull_should_return_last_item_when_List() {
        String result = CollectionUtils.findLastItemOrNull(asList("item1", "item2", "item3"));

        assertEquals("item3", result);
    }

    @Test
    public void findLastItemOrNull_should_return_last_item_when_set() {
        Set<String> map = new HashSet<String>() {{
            add("item1");
            add("item2");
            add("item3");
        }};
        String result = CollectionUtils.findLastItemOrNull(map);

        assertEquals("item3", result);
    }

    @Test
    public void findLastItemOrNull_should_return_last_item_notnull_when_last_is_null() {
        String result = CollectionUtils.findLastItemOrNull(asList("item1", "item2", null));

        assertEquals("item2", result);
    }

    @Test
    public void findOptionalLastItem_should_return_notPresent_when_empty_list() {
        Optional<String> result = CollectionUtils.findOptionalLastItem(new ArrayList<String>());

        assertFalse(result.isPresent());
    }

    @Test
    public void findOptionalLastItem_should_return_optional() {
        Optional<String> result = CollectionUtils.findOptionalLastItem(asList("item1", "item2", "item3"));

        assertTrue(result.isPresent());
        assertEquals("item3", result.get());
    }
}