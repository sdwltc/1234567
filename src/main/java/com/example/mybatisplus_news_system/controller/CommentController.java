package com.example.mybatisplus_news_system.controller;
import com.example.mybatisplus_news_system.entity.Comment;
import com.example.mybatisplus_news_system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
@RestController
@RequestMapping("api/news/{newsId}/comments")
public class CommentController
{
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService)
    {
        this.commentService = commentService;
    }

    //评论列表的获取,根据新闻id获取
    @GetMapping
    public ResponseEntity<List<Comment>> getCommentList()
    {
        //调用commentService中的getCommentList方法，即评论列表的获取
        List<Comment> commentList = commentService.getCommentList();
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok(commentList);
    }

    //发表评论，即评论添加
    @PostMapping
    public ResponseEntity<?> insertComment(@PathVariable Long newsId,@RequestBody Comment comment)
    {
        //调用commentService中的insertComment方法，即发表评论，即评论添加
        commentService.insertComment(newsId, comment);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("Comment uploaded successfully");
    }

    //删除评论
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id)
    {
        //调用commentService中的deleteCommentById方法，即删除评论
        commentService.deleteCommentById(id);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
