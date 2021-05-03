package mika.spring.controller;

import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import mika.spring.service.BoardService;
import mika.spring.vo.BoardVO;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	@Setter(onMethod_= @Autowired)
	BoardService boardService;
	
	@GetMapping("/list")
	public void getList(Model model) {
		log.info("list.........");
		List<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void getRegister() {
		log.info("register(get)......");
	}
	
	@PostMapping("/register")
	public String postResiger(BoardVO board, RedirectAttributes rttr) {
		log.info("register(post)........");
		int bno = boardService.register(board);
		String res ="";
		if (bno > 0) {
			res = "success";
		} else {
			res = "fail";
		}
		rttr.addFlashAttribute("resMsg", res);
		return "redirect:/board/list";
	}
	
	@GetMapping({"get", "edit"})
	public void getDetail(BoardVO board, Model model) {
		Long bno = board.getBno();
		BoardVO oneBoard = boardService.detail(bno);
		model.addAttribute("board", oneBoard);
	}
	
	@PostMapping("/edit")
	public void edit(BoardVO board, RedirectAttributes rttr) {
		log.info("edit(post)..........");
		
	}
	
}
