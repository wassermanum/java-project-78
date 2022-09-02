### Hexlet tests and linter status:
[![Actions Status](https://github.com/wassermanum/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/wassermanum/java-project-78/actions)

[![Maintainability](https://api.codeclimate.com/v1/badges/62b03e43006150e1b9fd/maintainability)](https://codeclimate.com/github/wassermanum/java-project-78/maintainability)

[![Test Coverage](https://api.codeclimate.com/v1/badges/62b03e43006150e1b9fd/test_coverage)](https://codeclimate.com/github/wassermanum/java-project-78/test_coverage)

[![Java CI](https://github.com/wassermanum/java-project-78/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/wassermanum/java-project-78/actions/workflows/gradle-build.yml)

# Валидатор данных

    Данная библиотека используется для валидации данных различных форматов.
    На данный момент поддерживаются типы данных String, Number и Map

С данными работает экземпляр класса Validator:

````
Validator v = new Validator();
````

## Примеры использования:

### String

````
v.string().required().isValid(""); //false
v.string().required().minLength(5).isValid("aaaaaa"); //true
v.string().required().contains("abc").isValid("zzzabczz"); //true
````

### Number

````
v.number().isValid(null); //true
v.number().required().isValid(null); //false
v.number().required().positive().range(-10, 10).isValid(-3); //false
v.number().required().positive().range(-10, 10).isValid(3); //true
````

### Map

````
Map human = Map.of(
    "name", "Kolya",
    "age", 100
);

v.map().sizeof(2).isValid(human); //true

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

v.map().shape(schemas).isValis(human); //true 
````

