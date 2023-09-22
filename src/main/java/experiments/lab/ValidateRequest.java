package experiments.lab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

@ApplicationScoped
public class ValidateRequest {

	public String validateAndReturnRequestAsString(@Valid TestConditionalValidationDTO dto) throws JsonProcessingException {
    	String response = null;
    	try {
    		response = new ObjectMapper().writeValueAsString(dto);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return response;
    }
}
