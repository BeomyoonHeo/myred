package site.metacoding.red.web.dto.users;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.domain.users.Users;


@Setter
@Getter
public class InsertDto extends Users {
	private String username;
	private String password;
	private String email;

}
