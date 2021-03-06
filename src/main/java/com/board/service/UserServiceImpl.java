package com.board.service;

import com.board.dao.UserDAO;
import com.board.domain.AuthInfo;
import com.board.domain.LoginCommand;
import com.board.domain.RegisterRequest;
import com.board.domain.UserVO;
import com.board.exception.AlreadyExistingEmailException;
import com.board.exception.AlreadyExistingIDException;
import com.board.exception.IdPasswordNotMatchingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource(name="userDAO")
    private UserDAO userDAO;

    @Override
    public void register(RegisterRequest regReq) throws Exception {
        UserVO email = userDAO.selectByEmail(regReq.getEmail());
        if(email!=null) {
            throw new AlreadyExistingEmailException(regReq.getEmail()+" is duplicate email.");
        }
        UserVO id = userDAO.selectById(regReq.getId());
        if(id!=null) {
            throw new AlreadyExistingIDException(regReq.getId()+" is duplicate id.");
        }
        userDAO.insertUser(regReq);
    }

    @Override
    public AuthInfo loginAuth(LoginCommand loginCommand) throws Exception {
        UserVO user = userDAO.selectById(loginCommand.getId());
        if(user == null) {
            throw new IdPasswordNotMatchingException();
        }
        if(!user.matchPassword(loginCommand.getPw())) {
            throw new IdPasswordNotMatchingException();
        }
        return new AuthInfo(user.getID(), user.getNAME(), user.getGRADE());
    }
}
