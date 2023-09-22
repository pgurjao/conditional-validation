# conditional-validation debug

How to reproduce error on `@NullWhen` annotation:

1. Run project (using your IDE or using command `./gradlew quarkusDev`)
2. Make request A (it will work)
3. Make request B (it will throw exception, but it should have worked)
4. Make request C (it will inform that 'someNullString' must be null, proving that `@Null` is working)
5. Press `r` then `ENTER` on console to execute test. The test will fail with the same exception on request **B**. When the bug is resolved the test will pass.

**Request A**
```
curl --location --request GET 'localhost:8080/hello' \
--header 'Content-Type: application/json' \
--data '{
    "nameOfFruit": "banana",
    "flavor": "sweet",
    "someNullString": null
}'
```

**Request B**
```
curl --location --request GET 'localhost:8080/hello' \
--header 'Content-Type: application/json' \
--data '{
    "nameOfFruit": "tomato",
    "flavor": "salty",
    "someNullString": null
}'
```

**Request C**
```
curl --location --request GET 'localhost:8080/hello' \
--header 'Content-Type: application/json' \
--data '{
    "nameOfFruit": "banana",
    "flavor": "sweet",
    "someNullString": "thisIsNotNullString"
}'
```
<br>
<br>
<br>
  
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/conditional-validation-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, Jakarta Persistence)
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
