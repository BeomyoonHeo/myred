package site.metacoding.red.web;

import java.util.ArrayList;
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
import site.metacoding.red.web.dto.users.InsertDto;
import site.metacoding.red.web.dto.users.RespDto;

@RequiredArgsConstructor
@RestController
public class BoardController {

	private final BoardsDao boardsDao;
	
	@GetMapping("/boards/{id}")
	public Boards getBoards(@PathVariable Integer id) {
		return boardsDao.findById(id);
	}
	
	@GetMapping("/boards")
	public List<?> getAllUser() {
		List<Boards> allBoard = new ArrayList<>();
		allBoard.addAll(boardsDao.findAll());
		return allBoard;
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
//			user.updateName(insertDto.getUsername());
//		}
//		if(!(insertDto.getPassword() == null))
//		{
//			user.updatePassword(insertDto.getPassword());
//		}
//		if(!(insertDto.getEmail() == null))
//		{
//			user.updateEmail(insertDto.getEmail());
//		}
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
