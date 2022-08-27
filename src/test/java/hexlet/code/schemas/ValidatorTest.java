package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    private Validator v;

    @BeforeEach
    public void init() {
        this.v = new Validator();
    }

    //CHECKSTYLE.OFF: MagicNumber
    @Test
    public void numberSchemaTest() {
        assertTrue(v.number().positive().isValid(null));
        assertTrue(v.number().positive().isValid(25.6));
        assertFalse(v.number().positive().isValid(-6));
        assertFalse(v.number().required().positive().isValid(null));
        assertFalse(v.number().required().isValid("asd"));
        assertTrue(v.number().range(-5, 5).isValid(1));
        assertFalse(v.number().range(-5, 5).isValid(7));
    }

    @Test
    public void stringSchemaTest() {
        assertTrue(v.string().isValid(null));
        assertFalse(v.string().required().isValid(""));
        assertTrue(v.string().contains(null).isValid(""));
        assertTrue(v.string().contains(null).isValid(null));
        assertFalse(v.string().required().contains(null).isValid(null));
        assertTrue(v.string().required().contains("asd").isValid("ggasdgg"));
        assertFalse(v.string().minLength(5).isValid("xxx"));
    }

    @Test
    public void mapSchemaTest() {

        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2)); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4));

        MapSchema m = v.map().sizeof(2);
        assertTrue(m.isValid(human4));
    }
    //CHECKSTYLE.ON: MagicNumber
}
