package experiments.lab;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

@QuarkusTest
public class GreetingResourceTest {

	private final String requestBody = """
			 {"nameOfFruit": "tomato",
			 "flavor": "salty",
			 "someNullString": null}
			""";
	
    @Test
    public void testHelloEndpoint() {
    	Response response = given()
    			.header("Content-type", "application/json")
    			.and()
    			.body(requestBody)
    			.when().get("/hello")
    			.then()
    			.extract().response();
    	
    	Map<String, String> parameterViolations = response.jsonPath().getMap("parameterViolations[0]");
    	
    	Assertions.assertEquals(400, response.statusCode());
    	Assertions.assertEquals("hello.dto.flavor", parameterViolations.get("path")); //Flavor must be null when nameOfFruit is tomato
    	Assertions.assertEquals("flavor must be null when fruit is tomato", parameterViolations.get("message")); //Flavor must be null when nameOfFruit is tomato
    }
}