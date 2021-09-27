package com.board.service;

import com.board.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public List<BoardVO> list() throws Exception;
}
