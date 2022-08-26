package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        this.predicateList.add(o -> Objects.nonNull(o) && o instanceof Map<?,?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        this.predicateList.add(o -> ((Map<?,?>) o).size() == size);
        return this;
    }
}
