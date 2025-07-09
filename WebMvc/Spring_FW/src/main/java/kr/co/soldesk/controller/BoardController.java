package kr.co.soldesk.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.soldesk.beans.ContentBean;
import kr.co.soldesk.beans.PageBean;
import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		// String board_info_idx = request.getParameter("board_info_idx");
		model.addAttribute("board_info_idx", board_info_idx);

		// 메서드 호출 이름받기.
		String boardInfoName = boardService.getBoardInfoName(board_info_idx);
		// model에 저장후
		model.addAttribute("boardInfoName", boardInfoName);
		// 메서드 호출후 게시글 리스트 받기
		List<ContentBean> contentList = boardService.getContentList(board_info_idx, page);
		model.addAttribute("contentList", contentList);

		PageBean pageBean = boardService.getContentCnt(board_info_idx, page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);
		return "board/main"; // forward.
	}

	@GetMapping("/read")
	public String read(@RequestParam("board_info_idx") int board_info_idx, @RequestParam("content_idx") int content_idx,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		// 글 목록보기시 필요.
		model.addAttribute("board_info_idx", board_info_idx);
		// 수정 또는 삭제시 필요로하는 글번호
		model.addAttribute("content_idx", content_idx);
		model.addAttribute("loginUserBean", loginUserBean);
		// 상세정보.
		ContentBean readContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean", readContentBean);

		model.addAttribute("page", page);
		return "board/read";
	}

	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentBean") ContentBean writeContentBean,
			@RequestParam("board_info_idx") int board_info_idx) {
		writeContentBean.setContent_board_idx(board_info_idx);
		return "board/write";
	}

	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean,
			BindingResult result) {
		if (result.hasErrors()) {
			return "board/write";
		}
		// 제목, 내용, 이미지, 게시판종류(부서)
		boardService.addContentInfo(writeContentBean);
		return "board/write_success";
	}

	@GetMapping("/not_writer")
	public String not_writer() {

		return "board/not_writer";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("board_info_idx") int board_info_idx,
			@RequestParam("content_idx") int content_idx, Model model) {
		// 글 목록보기시 필요.
		model.addAttribute("board_info_idx", board_info_idx);
		// 수정 또는 삭제시 필요로하는 글번호
		boardService.deleteContentInfo(content_idx);

		return "board/delete";
	}

	@GetMapping("/modify")
	public String modify(@RequestParam("board_info_idx") int board_info_idx,
			@RequestParam("content_idx") int content_idx, @RequestParam("page") int page,
			@ModelAttribute("modifyContentBean") ContentBean modifyContentBean, Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		model.addAttribute("page", page);
		// 게시글 하나의 정보 가져오기
		ContentBean tempContentBean = boardService.getContentInfo(content_idx);
		modifyContentBean.setContent_writer_name(tempContentBean.getContent_writer_name());
		modifyContentBean.setContent_date(tempContentBean.getContent_date());
		modifyContentBean.setContent_subject(tempContentBean.getContent_subject());
		modifyContentBean.setContent_text(tempContentBean.getContent_text());
		modifyContentBean.setContent_file(tempContentBean.getContent_file());
		modifyContentBean.setContent_writer_idx(tempContentBean.getContent_writer_idx());
		modifyContentBean.setContent_board_idx(tempContentBean.getContent_board_idx());
		modifyContentBean.setContent_idx(content_idx);

		return "board/modify";
	}

	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
			BindingResult result, @RequestParam("page") int page, Model model) {

		if (result.hasErrors()) {
			return "board/modify";
		}
		model.addAttribute("page", page);
		boardService.modifyContentInfo(modifyContentBean);
		return "board/modify_success";
	}

	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {

		List<ContentBean> searchResults = boardService.searchContents(keyword); // Service에서 검색 실행

		model.addAttribute("searchResults", searchResults); // 검색 결과 추가
		model.addAttribute("keyword", keyword); // 검색 키워드 추가
		return "board/search"; // 검색 결과를 보여줄 JSP 파일
	}
}
