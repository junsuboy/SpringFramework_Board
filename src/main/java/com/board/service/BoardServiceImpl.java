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

    // 게시물 목록
    @Override
    public List<BoardVO> list() throws Exception{
        return dao.list();
    }

    // 게시물 작성
    @Override
    public void write(BoardVO vo) throws Exception {
        dao.write(vo);
    }

    @Override
    public BoardVO view(int bno) throws Exception {
        return dao.view(bno);
    }

    @Override
    public void modify(BoardVO vo) throws Exception {
        dao.modify(vo);
    }
}
