package epita.quiz.web.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDto {
	@NotNull
	private String username;
	
	@NotNull
	private String password;
}
