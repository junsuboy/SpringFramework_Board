package com.board.controller;

import com.board.domain.ReplyVO;
import com.board.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

    @Inject
    private ReplyService replyService;

    // 댓글 조회

    // 댓글 작성
    @PostMapping("write")
    public String postWrite(ReplyVO vo) throws Exception{
        replyService.write(vo);

        return "redirect:/board/view?bno=" + vo.getBno();
    }

    // 댓글 수정

    // 댓글 삭제제
}
