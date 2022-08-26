package hexlet.code.schemas;

import org.junit.jupiter.api.Test;

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
        System.out.println(sch.isValid("asd"));
    }

}