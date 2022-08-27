package hexlet.code.schemas;

import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final List<Predicate<Object>> predicateList;

    public BaseSchema(List<Predicate<Object>> predicates) {
        this.predicateList = predicates;
    }

    protected final void addPredicate(Predicate<Object> predicate) {
        this.predicateList.add(predicate);
    }
    public final boolean isValid(Object obj) {
        return predicateList.stream().allMatch(o -> o.test(obj));
    }
}
