package experiments.lab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.microtweak.conditionalvalidator.ConditionalValidate;
import com.github.microtweak.conditionalvalidator.constraint.NullWhen;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConditionalValidate
public class ConditionalValidationDTO {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean flavorMustBeNull;
	
	private String nameOfFruit;
	
	@NullWhen(expression = "flavorMustBeNull",
			message = "flavor must be null when fruit is tomato")
	private String flavor;
	
	@Null
	private String someNullString;

	public void setNameOfFruit(String nameOfFruit) {
		if (nameOfFruit != null) {
			this.nameOfFruit = nameOfFruit;
			this.flavorMustBeNull = nameOfFruit.equalsIgnoreCase("tomato");
		}
	}
}
