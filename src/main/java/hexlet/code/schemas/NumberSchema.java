package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Objects;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
//        super();
        this.predicateList = new ArrayList<>();
    }

    public NumberSchema required() {
        this.predicateList.add(o -> Objects.nonNull(o) && o instanceof Number);
        return this;
    }

    public NumberSchema positive() {
        this.predicateList.add(o ->
                Objects.nonNull(o) &&
                o instanceof Number &&
                ((Number) o).doubleValue() > 0
        );
        return this;
    }

    public NumberSchema range(Number min, Number max) {
        this.predicateList.add(o ->
                        ((Number) o).doubleValue() > min.doubleValue() &&
                        ((Number) o).doubleValue() < max.doubleValue()
                );
        return this;
    }


}