package site.metacoding.red.web.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RespDto<T> {
	private int confirm;
	private String message;
	private T body;
	
}
