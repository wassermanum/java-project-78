package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Objects;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        this.predicateList = new ArrayList<>();
    }

    public StringSchema required() {
        this.predicateList.add(o ->
                Objects.nonNull(o) &&
                o instanceof String &&
                !o.toString().isEmpty());
        return this;
    }

    public StringSchema contains(String value) {
        if (Objects.nonNull(value)) {
            this.predicateList.add(o -> Objects.nonNull(o) && o.toString().contains(value));
        }
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.predicateList.add(o ->
                Objects.nonNull(o) &&
                o instanceof String &&
                o.toString().length() >= minLength
        );
        return this;
    }
}
