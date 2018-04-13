package com.jxau.kknq.service.impl;

import com.jxau.kknq.bean.UsersDetails;
import com.jxau.kknq.entity.Result;
import com.jxau.kknq.entity.Users;
import com.jxau.kknq.repository.CenterRepository;
import com.jxau.kknq.service.CenterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/13 8:50
 */
@Service("CenterService")
public class CenterServiceImpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;

    @Override
    public Result modify(String username, Users users) {
        Users user = new Users();
        user.setRealName(users.getRealName());
        user.setBirthday(users.getBirthday());
        user.setTelPhone(users.getTelPhone());
        user.setAddress(users.getAddress());
        user.setEmail(users.getEmail());
        user.setQQNumber(users.getQQNumber());
        user.setWeiChat(users.getWeiChat());
        user.setWeiBo(users.getWeiBo());
        return null;
    }

    @Override
    @Transactional
    public int setNewPassword(UsersDetails usersDetails, String username) {
        String oldPassword = usersDetails.getOldPassword();
        String newPassword = usersDetails.getNewPassword();
        String surePassWord = usersDetails.getSurePassword();
        String realPwd = centerRepository.checkPassword(username);
        if(oldPassword.equals(realPwd)){
            try {
                centerRepository.setNewPassword(newPassword,username);
                return 100;
            }catch (Exception e){
                System.out.println(e.getMessage());
                return 200;
            }
        }else {
            return 200;
        }
    }
}
