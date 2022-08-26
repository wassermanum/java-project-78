package hexlet.code.schemas;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NumberSchemaTest {

    @Test
    public void numberSchemaTest() {
        NumberSchema sch = new NumberSchema();
//        System.out.println(sch.isValid(null));
//        System.out.println(sch.isValid(2));
//        Object t = null;
//        StringSchema xxx = new StringSchema();
//        xxx.required().minLength(3);
//        System.out.println(xxx.isValid(32));
//        System.out.println(xxx.isValid(2222));
        sch.positive();
        System.out.println(sch.isValid(1));
    }

    @Test
    public void mapSchemaTest() {

        MapSchema schema = new MapSchema();
        NumberSchema num = new NumberSchema();
        StringSchema str = new StringSchema();

// shape - позволяет описывать валидацию для значений объекта Map по ключам.
        Map<String, BaseSchema<Object>> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        schema.isValid(human1); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        schema.isValid(human2); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        schema.isValid(human3); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        schema.isValid(human4)
    }

}