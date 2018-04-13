package com.jxau.kknq.service;

import com.jxau.kknq.bean.UsersDetails;
import com.jxau.kknq.entity.Result;
import com.jxau.kknq.entity.Users;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/13 8:47
 */

public interface CenterService {
    Result modify(String username, Users users);

    int setNewPassword(UsersDetails usersDetails,String username);
}
