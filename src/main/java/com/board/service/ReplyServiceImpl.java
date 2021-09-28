package com.board.service;

import com.board.dao.ReplyDAO;
import com.board.domain.ReplyVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Inject
    private ReplyDAO dao;

    // 댓글 조회
    @Override
    public List<ReplyVO> list(int bno) throws Exception {
        return dao.list(bno);
    }

    @Override
    public void write(ReplyVO vo) throws Exception {
        dao.write(vo);
    }

    @Override
    public void modify(ReplyVO vo) throws Exception {
        dao.modify(vo);
    }

    @Override
    public void delete(ReplyVO vo) throws Exception {
        dao.delete(vo);
    }
}
