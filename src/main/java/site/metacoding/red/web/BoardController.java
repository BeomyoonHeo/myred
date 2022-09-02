package site.metacoding.red.web;



import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.boards.WriteDto;
import site.metacoding.red.web.dto.users.RespDto;

@RequiredArgsConstructor
@RestController
public class BoardController {

	//@Autowired <<사용시 IOC Container에 있는 클래스를 자동으로 주입해준다.
	private final BoardsDao boardsDao;
	private final UsersDao usersDao;
	
	
	@GetMapping("/boards/{id}")
	public RespDto<?> getBoards(@PathVariable Integer id) {
		return new RespDto<>(1, "", boardsDao.findByIdtoDetail(id));
	}
	
	@GetMapping("/boards")
	public RespDto<?> getAllUser() {
		
		List<Users> userList = usersDao.findAll();
		List<Boards> boardList = boardsDao.findAll();
		for (Boards boards : boardList) {
			for (Users users : userList) {
				if(boards.getUsersId() == users.getId()) {
					boards.setContent(boards.getContent() + " 작성자 : " + users.getUsername());
					break;
				}
			}
		}
		
		return new RespDto<>(1, "정보조회완료", boardList);
	}
	
	@PostMapping("/boards")
	public RespDto<?> insert(WriteDto writeDto) {
		boardsDao.insert(writeDto);
		return new RespDto<>(1, "정보입력완료", writeDto);
	}
	
	@PutMapping("boards/{id}")
	public RespDto<?> update(@PathVariable Integer id, WriteDto writeDto){
		Boards boards = boardsDao.findById(id);
		
//		if(!(writeDto.getTitle() == null))
//		{
//			boards.updateName(insertDto.getTitle());
//		}
//		if(!(insertDto.getPassword() == null))
//		{
//			boards.updatePassword(insertDto.getContentss());
//		}
		boards.updateBoards(writeDto);
		boardsDao.update(boards);
		return new RespDto<>(1, "정보수정완료", boards.getUsersId());
	}
	
	@DeleteMapping("/boards/{id}")
	public RespDto<?> delete(@PathVariable Integer id){
		Boards boards = boardsDao.findById(id);
		boardsDao.delete(id);
		return new RespDto<>(1, "게시글 삭제 완료", boards);
	}
}
