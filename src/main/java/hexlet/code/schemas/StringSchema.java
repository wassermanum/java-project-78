package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Objects;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        this.predicateList = new ArrayList<>();
    }

    public StringSchema required() {
        this.predicateList.add(o ->
                Objects.nonNull(o) &&
                !o.isEmpty());
        return this;
    }

    public StringSchema contains(String value) {
        if (Objects.nonNull(value)) {
            this.predicateList.add(o -> Objects.nonNull(o) && o.contains(value));
        }
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.predicateList.add(o ->
                Objects.nonNull(o) &&
                o.length() >= minLength
        );
        return this;
    }
}
