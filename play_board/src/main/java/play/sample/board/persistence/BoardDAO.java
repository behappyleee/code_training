package play.sample.board.persistence;

import java.util.List;

import play.sample.board.vo.BoardVO;

public interface BoardDAO {

	public List<BoardVO> getAllBoardData();
	
	
}
