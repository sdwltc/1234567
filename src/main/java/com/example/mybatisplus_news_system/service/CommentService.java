package com.example.mybatisplus_news_system.service;
import com.example.mybatisplus_news_system.entity.Comment;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CommentService
{
    //评论列表获取
    List<Comment> getCommentList();

    //发表评论，即评论添加
    void insertComment(Long newsId,Comment comment);

    //评论更改
    void updateCommentById(Long id,Comment comment);

    //评论删除
    void deleteCommentById(Long id);
}
