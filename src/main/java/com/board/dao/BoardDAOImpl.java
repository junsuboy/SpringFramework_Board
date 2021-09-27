package com.board.dao;

import com.board.domain.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Inject
    private SqlSession sql;

    private static String namespace = "com.board.mappers.board";

    // 게시물 목록
    @Override
    public List<BoardVO> list() throws Exception {
        return sql.selectList(namespace + ".list");
    }

    // 게시물 작성
    @Override
    public void write(BoardVO vo) throws Exception {
        sql.insert(namespace + ".write", vo);
    }

    // 게시물 조회
    @Override
    public BoardVO view(int bno) throws Exception {
        return sql.selectOne(namespace + ".view", bno);
    }

    // 게시물 수정
    @Override
    public void modify(BoardVO vo) throws Exception {
        sql.update(namespace + ".modify", vo);
    }

    // 게시물 삭제
    @Override
    public void delete(int bno) throws Exception {
        sql.delete(namespace + ".delete", bno);
    }
}
