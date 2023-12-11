package com.example.mybatisplus_news_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Advertisement
{
    private Long id;
    private String type;
    private String content;
    private Long clickCount;
}
