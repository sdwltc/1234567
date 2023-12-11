package com.example.mybatisplus_news_system.service;
import com.example.mybatisplus_news_system.entity.User;

//service我只需要写接口，写名字，#具体实现交给impl去实现#
public interface UserService
{
    //用户注册，也就是添加用户，id自增
    void register(User user);

    //用户个人信息更改，根据id更改
    void updateUserById(Long id,User user);
}
