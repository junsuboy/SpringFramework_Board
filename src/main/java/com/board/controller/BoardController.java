package com.board.controller;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Inject
    BoardService service;

    // 게시물 목록
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void getList(Model model) throws Exception {

        List<BoardVO> list = null;
        list = service.list();

        model.addAttribute("list", list);
    }

    // 게시물 작성
    @GetMapping("/write")
    public void getWrite() throws Exception {

    }

    // 게시물 작성
    @PostMapping("/write")
    public String postWrite(BoardVO vo) throws Exception {
        service.write(vo);

        return "redirect:/board/list";
    }

    // 게시물 조회
    @GetMapping("/view")
    public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
        BoardVO vo = service.view(bno);

        model.addAttribute("view", vo);
    }

    // 게시물 수정
    @GetMapping("/modify")
    public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
        BoardVO vo = service.view(bno);

        model.addAttribute("view", vo);
    }

    // 게시물 수정
    @PostMapping("/modify")
    public String postModify(BoardVO vo) throws Exception {
        service.modify(vo);

        return "redirect:/board/view?bno=" + vo.getBno();
    }

    // 게시물 삭제
    @GetMapping("/delete")
    public String getDelete(@RequestParam("bno") int bno) throws Exception {
        service.delete(bno);

        return "redirect:/board/list";
    }

    // 게시물 목록 + 페이징 추가
    @GetMapping("/listPage")
    public void getListPage(Model model, @RequestParam("num") int num) throws Exception {

        Page page = new Page();

        page.setNum(num);
        page.setCount(service.count());

        List<BoardVO> list = null;
        list = service.listPage(page.getDisplayPost(), page.getPostNum());

        model.addAttribute("list", list);

        /*
        model.addAttribute("pageNum", page.getPageNum());

        model.addAttribute("startPageNum", page.getStartPageNum());
        model.addAttribute("endPageNum", page.getEndPageNum());

        model.addAttribute("prev", page.getPrev());
        model.addAttribute("next", page.getNext());
        */

        model.addAttribute("page", page);

        model.addAttribute("select", num);

        /*
        // 게시물 총 갯수
        int count = service.count();

        // 한 페이지에 출력할 게시물 갯수
        int postNum = 10;

        // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
        int pageNum = (int) Math.ceil((double) count / postNum);

        // 출력할 게시물
        int displayPost = (num - 1) * postNum;

        // 한번에 표시할 페이징 번호의 갯수
        int pageNum_cnt = 10;

        // 마지막 페이지 번호 =
        // ((올림)(현재 페이지 번호 / 한번에 표시할 페이지 번호의 갯수)) * 한번에 표시할 페이지 번호의 갯수
        // 표시되는 페이지 번호 중 마지막 번호
        int endPageNum = (int) (Math.ceil((double) num / (double) pageNum_cnt) * pageNum_cnt);

        // 시작 페이지 = 마지막 페이지 번호 - 한번에 표시할 페이지 번호의 갯수 + 1
        // 표시되는 페이지 번호 중 첫번째 번호
        int startPageNum = endPageNum - (pageNum_cnt - 1);

        // 마지막 번호 재계산
        int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));

        if(endPageNum > endPageNum_tmp) {
            endPageNum = endPageNum_tmp;
        }

        boolean prev = startPageNum == 1 ? false : true;
        boolean next = endPageNum * pageNum_cnt >= count ? false : true;

        // 시작 및 끝 번호
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        // 이전 및 다음
        model.addAttribute("prev", prev);
        model.addAttribute("next", next);

        // 현재 페이지
        model.addAttribute("select", num);
        */
    }

}
