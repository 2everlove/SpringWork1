package jmp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jmp.spring.domain.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Log4j
public class MainController {
	
	private final jmp.spring.service.BoardService service;
	
	@GetMapping("/list2")
	public void getList(Model model) {
		//화면단에서는 매개변수로 model을 받는다
		log.info("list.........");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("Get register.....");
	}
	
	/*
	 * @PostMapping("/register") public String
	 * registerProccess(@RequestParam("title") String
	 * title, @RequestParam("content") String content, @RequestParam("writer")
	 * String writer) { log.info("post......"); BoardVO board = new BoardVO();
	 * board.setTitle(title); board.setContent(content); board.setWriter(writer);
	 * service.register(board); return "redirect:/board/list2"; }
	 */
	@PostMapping("/register")
	public String registerProccess(BoardVO board, RedirectAttributes rttr) {
									//객체를 선언하면 화면단에서 자동으로 넣어줌, 그러므로 name과 객체의 매개변수의 이름을 맞춰줘야함
		log.info("post......"+board);
		
		Long bno = service.register(board);
		
		log.info("bno : "+bno);
		
		rttr.addFlashAttribute("resMsg", bno+"번 글이 작성되었습니다.");
		//redirect된 화면에 단 한번 전송해줌
		
		return "redirect:/board/list2";
	}
	
	@GetMapping({"/get","/edit"})//query를 pk인 bno로 받아서 로직에 전달
	public void getProcess(Long bno, Model model) {
		log.info("get.........");
		//model에 servie로직에 담긴 값을 담아서 넘김
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/edit")
	public String editPostProcess(BoardVO board, RedirectAttributes rttr) {
		log.info("edit..........");
		log.info(board);
		boolean res = service.modify(board);
		String resMsg = "";
		if(res==true)
			resMsg = "수정 되었습니다.";
		else
			resMsg = "error! 관리자에게 문의 해주세요";
		log.info(board);
		rttr.addAttribute("bno", board.getBno());
		rttr.addFlashAttribute("resMsg", resMsg);
		return "redirect:/board/get";
	}
	
	@GetMapping("delete")
	public String editExe(BoardVO board, RedirectAttributes rttr) {
		log.info("delete...........");
		Long bno = board.getBno();
		String resMsg = "";
		boolean res = service.remove(bno);
		if(res) {
			resMsg = bno+"번 글이 삭제되었습니다.";
			rttr.addFlashAttribute("resMsg", resMsg);
//			redirect를 안쓰면 delete?bno=10이 지워졌어도 url상엔 계속 남아있음
			return "redirect:/board/list2";
		} else {
			resMsg = "error! 관리자에게 문의 해주세요.";
			rttr.addAttribute("bno", bno);
			return "redirect:/board/get";
		}

	}
}
