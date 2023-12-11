package com.example.mybatisplus_news_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News
{
    private Long id;
    private String title;
    private String content;
    private int authorId;

}
