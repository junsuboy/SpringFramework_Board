package com.board.service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Inject
    private BoardDAO dao;

    @Override
    public List<BoardVO> list() throws Exception{
        return dao.list();
    }
}
