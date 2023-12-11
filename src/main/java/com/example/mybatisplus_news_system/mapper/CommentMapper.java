package com.example.mybatisplus_news_system.mapper;
import com.example.mybatisplus_news_system.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface CommentMapper extends BaseMapper<Comment>
{
    void setNewsId(Long newsId);
}
