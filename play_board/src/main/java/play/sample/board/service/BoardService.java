package play.sample.board.service;

import javax.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;

import play.sample.board.vo.BoardVO;

public interface BoardService {

	public void getBoardData(HttpServletRequest req, Model model);
	
	
	
}
