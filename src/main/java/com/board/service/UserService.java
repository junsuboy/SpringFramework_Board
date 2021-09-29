package com.board.service;

import com.board.domain.AuthInfo;
import com.board.domain.LoginCommand;
import com.board.domain.RegisterRequest;

public interface UserService {
    void register(RegisterRequest regReq) throws Exception;

    AuthInfo loginAuth(LoginCommand loginCommand) throws Exception;
}
