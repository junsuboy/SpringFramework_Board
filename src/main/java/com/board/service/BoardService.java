package com.board.service;

import com.board.domain.BoardVO;

import java.util.List;

public interface BoardService {
    // 게시물 목록
    public List<BoardVO> list() throws Exception;

    // 게시물 작성
    public void write(BoardVO vo) throws Exception;

    // 게시물 조회
    public BoardVO view(int bno) throws Exception;

    // 게시물 수정
    public void modify(BoardVO vo) throws Exception;
}
