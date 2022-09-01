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
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.users.InsertDto;
import site.metacoding.red.web.dto.users.RespDto;

@RequiredArgsConstructor
@RestController
public class UsersController {

	private final UsersDao usersDao;
	
	@GetMapping("/users/{id}")
	public Users getUsers(@PathVariable Integer id) {
		return usersDao.findById(id);
	}
	
	@GetMapping("/users")
	public List<?> getAllUser() {
		List<Users> allUser = new ArrayList<>();
		allUser.addAll(usersDao.findAll());
		return allUser;
	}
	
	@PostMapping("/users")
	public RespDto<?> insert(InsertDto insertDto) {
		usersDao.insert(insertDto);
		return new RespDto<>(1, "정보입력완료", insertDto.getUsername());
	}
	
	@PutMapping("users/{id}")
	public RespDto<?> update(@PathVariable Integer id, InsertDto insertDto){
		Users user = usersDao.findById(id);
		
		if(!(insertDto.getUsername() == null))
		{
			user.updateName(insertDto.getUsername());
		}
		if(!(insertDto.getPassword() == null))
		{
			user.updatePassword(insertDto.getPassword());
		}
		if(!(insertDto.getEmail() == null))
		{
			user.updateEmail(insertDto.getEmail());
		}
		usersDao.update(user);
		return new RespDto<>(1, "정보수정완료", user.getUsername());
	}
	
	@DeleteMapping("/users/{id}")
	public RespDto<?> delete(@PathVariable Integer id){
		Users user = usersDao.findById(id);
		usersDao.delete(id);
		return new RespDto<>(1, "회원정보삭제완료", user);
	}
}
