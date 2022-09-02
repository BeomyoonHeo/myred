package site.metacoding.red.domain.boards;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.web.dto.boards.WriteDto;

@Setter
@Getter
public class Boards {
	private Integer id;
	private String title;
	private String content;
	private Integer usersId;
	private Timestamp createdAt;
	
	public void updateBoards(WriteDto writedto) {
		this.title = writedto.getTitle();
		this.content = writedto.getContent();
		this.usersId = writedto.getUsersId();
		
	}


}


