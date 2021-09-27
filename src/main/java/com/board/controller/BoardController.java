package com.board.controller;

import com.board.domain.BoardVO;
import com.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Inject
    BoardService service;

    // 게시물 목록
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void getList(Model model) throws Exception{

        List<BoardVO> list = null;
        list = service.list();

        model.addAttribute("list",list);
    }

    // 게시물 작성
    @GetMapping("/write")
    public void getWrite() throws Exception{
        
    }

    // 게시물 작성
    @PostMapping("/write")
    public String postWrite(BoardVO vo) throws Exception{
        service.write(vo);

        return "redirect:/board/list";
    }
}
