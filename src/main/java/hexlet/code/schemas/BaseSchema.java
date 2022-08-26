package hexlet.code.schemas;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected List<Predicate<Object>> predicateList;


    public boolean isValid(Object obj) {

        AtomicBoolean result = new AtomicBoolean(true);

        predicateList.forEach(predicate -> {
            result.set(result.get() && predicate.test(obj));
        });
        return result.get();
    }
}
