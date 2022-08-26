package hexlet.code.schemas;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected List<Predicate<T>> predicateList;


    public boolean isValid(T value) {

        AtomicBoolean result = new AtomicBoolean(true);

        predicateList.forEach(predicate -> result.set(result.get() && predicate.test(value)));
        return result.get();
    }
}
