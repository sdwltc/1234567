package com.example.mybatisplus_news_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private Long id;
    private String name;
    private String password;
    private String email;

}
