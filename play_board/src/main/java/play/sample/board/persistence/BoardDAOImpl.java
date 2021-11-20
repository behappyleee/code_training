package play.sample.board.persistence;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import play.sample.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardVO> getAllBoardData() {
		
		return sqlSession.selectList("play.sample.board.persistence.BoardDAO.getAllBoardData");
	}
	
}
