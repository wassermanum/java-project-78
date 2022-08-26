package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Objects;

public class NumberSchema extends BaseSchema<Number> {

    public NumberSchema() {
//        super();
        this.predicateList = new ArrayList<>();
    }

    public NumberSchema required() {
        this.predicateList.add(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        this.predicateList.add(o ->
                Objects.nonNull(o)&&
                o.doubleValue() > 0
        );
        return this;
    }

    public NumberSchema range(Number min, Number max) {
        this.predicateList.add(o ->
                        o.doubleValue() > min.doubleValue() &&
                        o.doubleValue() < max.doubleValue()
                );
        return this;
    }


}