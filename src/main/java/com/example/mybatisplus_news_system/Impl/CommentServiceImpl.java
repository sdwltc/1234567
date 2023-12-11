package com.example.mybatisplus_news_system.Impl;
import com.example.mybatisplus_news_system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mybatisplus_news_system.entity.Comment;
import java.util.List;
import com.example.mybatisplus_news_system.mapper.CommentMapper;

@Service

public class CommentServiceImpl implements CommentService
{
    private final CommentMapper commentMapper;
    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper)
    {
        this.commentMapper = commentMapper;
    }

    @Override
    //评论列表获取
    public List<Comment> getCommentList()
    {
        return commentMapper.selectList(null);
    }

    @Override
    //发表评论，即评论添加
    public void insertComment(Long newsId,Comment comment)
    {
        commentMapper.setNewsId(newsId);//设置评论关联的新闻id
        commentMapper.insert(comment);//插入评论
    }

    @Override
    //评论更改
    public void updateCommentById(Long id,Comment comment)
    {
        commentMapper.updateById(comment);
    }

    @Override
    //评论删除
    public void deleteCommentById(Long id)
    {
        commentMapper.deleteById(id);
    }

}
