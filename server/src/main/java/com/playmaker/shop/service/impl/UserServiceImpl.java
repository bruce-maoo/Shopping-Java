package com.playmaker.shop.service.impl;

import com.playmaker.shop.dao.UserRepository;
import com.playmaker.shop.entity.User;
import com.playmaker.shop.exception.PasswordErrorException;
import com.playmaker.shop.exception.UserNotExistException;
import com.playmaker.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: Shopping-Java
 * @Package: com.playmaker.shop.service.impl
 * @ClassName: UserServiceImpl
 * @Author: shangqianzhushang
 * @Description:
 * @Date: 2020/2/6 20:18
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(User user) {
        User newuser = userRepository.findByUsername(user.getUsername());
        if(newuser==null){
            throw new UserNotExistException("用户不存在!");
        }else {
            if(newuser.getPassword().equals(user.getPassword())){
                return newuser;
            }else{
                throw new PasswordErrorException("用户密码错误!");
            }
        }
    }
}