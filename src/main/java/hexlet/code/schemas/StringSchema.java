package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Objects;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super(new ArrayList<>());
    }

    public StringSchema required() {
        this.addPredicate(o ->
                Objects.nonNull(o)
                        && o instanceof String
                        && !o.toString().isEmpty());
        return this;
    }

    public StringSchema contains(String value) {
        this.addPredicate(o -> {
            if (Objects.isNull(value)) {
                return true;
            }
            return Objects.nonNull(o) && o.toString().contains(value);
        });
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.addPredicate(o -> {
            if (Objects.isNull(o)) {
                return true;
            }
            return o.toString().length() >= minLength;
        });
        return this;
    }
}
