package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super(new ArrayList<>());
    }

    public NumberSchema required() {
        this.addPredicate(o -> Objects.nonNull(o) && o instanceof Number);
        return this;
    }

    public NumberSchema positive() {
        this.addPredicate(o -> {
            if (Objects.isNull(o)) {
                return true;
            } else {
                return Double.parseDouble(o.toString()) > 0;
            }
        });
        return this;
    }

    public NumberSchema range(Number min, Number max) {
        this.addPredicate(o ->
                        ((Number) o).doubleValue() >= min.doubleValue()
                                && ((Number) o).doubleValue() <= max.doubleValue()
        );
        return this;
    }
}
