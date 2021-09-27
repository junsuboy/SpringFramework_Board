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
        // TODO Auto-generated method stub
        return sql.selectList(namespace + ".list");
    }
}
