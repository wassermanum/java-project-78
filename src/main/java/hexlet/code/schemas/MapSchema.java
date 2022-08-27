package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        super(new ArrayList<>());
    }

    public MapSchema required() {
        this.addPredicate(o -> Objects.nonNull(o) && o instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        this.addPredicate(o -> ((Map<?, ?>) o).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.required().addPredicate(o -> {
            AtomicBoolean result = new AtomicBoolean(true);
            ((Map<?, ?>) o).forEach((key, value) -> {
                result.set(result.get() && schemas.get(key).isValid(value));
            });
            return result.get();
        });
        return this;
    }
}
