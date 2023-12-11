package com.example.mybatisplus_news_system.Impl;
import com.example.mybatisplus_news_system.entity.User;
import com.example.mybatisplus_news_system.mapper.UserMapper;
import com.example.mybatisplus_news_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper)
    {
        this.userMapper = userMapper;
    }

    @Override
    //用户注册，也就是添加用户，id自增
    public void register(User user)
    {
        userMapper.insert(user);
    }

    @Override
    //用户个人信息更改，根据id更改
    public void updateUserById(Long id,User user)
    {
        userMapper.updateById(user);
    }
}
