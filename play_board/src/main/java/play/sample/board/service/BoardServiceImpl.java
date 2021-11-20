package play.sample.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import play.sample.board.persistence.BoardDAO;
import play.sample.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public void getBoardData(HttpServletRequest req, Model model) {
		List<BoardVO> list = dao.getAllBoardData();
		model.addAttribute("boardData", list);
	}

	
	
	
	
}
