package com.example.mybatisplus_news_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment
{
    private Long id;
    private Long newsId;
    private Long userId;
    private String content;
}
