package com.example.mybatisplus_news_system.service;
import com.example.mybatisplus_news_system.entity.News;
import java.util.List;
//srvice层,用于处理业务逻辑,调用dao层,返回数据给controller层,controller层再返回给前端
//实现类在impl包中
public interface NewsService
{
    //新闻列表获取
    List<News> getNewsList();

    //单条新闻获取
    News getNewsById(int id);

    //新闻添加
    void insertNews(News news);

    //新闻更改
    void updateNewsById(Long id,News news);
}
