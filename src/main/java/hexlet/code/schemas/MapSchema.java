package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class MapSchema extends BaseSchema<Map<String, Object>> {

    public MapSchema required() {
        this.predicateList.add(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        this.predicateList.add(o -> o.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<Map<String, Object>>> schemas) {

        this.predicateList.add(o -> {
            AtomicBoolean result = new AtomicBoolean(true);
//            if (!o.keySet().containsAll(schemas.keySet())) {
//                return false;
//            }

            o.forEach((key, value) -> {
                result.set(result.get() && schemas.get(key).isValid(value));
            });
            return result.get();
        });
        return this;
    }
}
