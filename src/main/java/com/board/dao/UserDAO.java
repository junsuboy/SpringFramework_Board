package com.board.dao;

import com.board.domain.RegisterRequest;
import com.board.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{
    public UserVO selectByEmail(String email) {
        return (UserVO)selectOne("com.board.mappers.user.selectByEmail", email);
    }

    public UserVO selectById(String id) {
        return (UserVO)selectOne("com.board.mappers.user.selectById", id);
    }

    public void insertUser(RegisterRequest regReq) {
        insert("com.board.mappers.user.register", regReq);
    }
}
