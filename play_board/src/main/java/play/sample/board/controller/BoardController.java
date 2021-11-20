package play.sample.board.controller;

import javax.servlet.http.HttpServletRequest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import play.sample.board.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService svc;
	
	@RequestMapping("/board/main.do")
	public String moveBoard(HttpServletRequest req, Model model) {
		logger.info("url ==> /board/main.do");
		svc.getBoardData(req, model);
		return "board_main";
	}
	
	
	
	
	
}
