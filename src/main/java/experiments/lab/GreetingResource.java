package experiments.lab;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

	@Inject
	ValidateRequest validateRequest;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(TestConditionalValidationDTO dto) throws JsonProcessingException {
    	String response = validateRequest.validateAndReturnRequestAsString(dto);
    	return response;
    }
}
