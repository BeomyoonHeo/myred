package site.metacoding.red.domain.boards;

import java.util.List;

import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.web.dto.boards.WriteDto;

public interface BoardsDao {
	public void insert(WriteDto writDto);
	public Boards findById(Integer id);
	public List<Boards> findAll();
	public void update(Boards boards);
	public void delete(Integer id);

}
