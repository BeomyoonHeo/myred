package site.metacoding.red.domain.users;

import java.util.List;

import site.metacoding.red.web.dto.users.InsertDto;

public interface UsersDao {
	public void insert(InsertDto insertDto);
	public Users findById(Integer id);
	public List<Users> findAll();
	public void update(Users user);
	public void delete(Integer id);
}
