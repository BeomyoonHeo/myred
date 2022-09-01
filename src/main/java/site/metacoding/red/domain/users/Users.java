package site.metacoding.red.domain.users;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.web.dto.users.InsertDto;

@Getter
public class Users {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdAt;
	
	public void updateAll(InsertDto insertDto) {
		this.username = insertDto.getUsername();
		this.password = insertDto.getPassword();
		this.email = insertDto.getEmail();
	}
	
	public void updateName(String username) {
		this.username = username;
	}
	
	public void updatePassword(String password) {
		this.password = password;
	}
	
	public void updateEmail(String email) {
		this.email = email;
	}
}
