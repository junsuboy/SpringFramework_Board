package com.board.controller;

import com.board.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

    @Inject
    private ReplyService service;

    // 댓글 조회

    // 댓글 작성

    // 댓글 수정

    // 댓글 삭제제
}
