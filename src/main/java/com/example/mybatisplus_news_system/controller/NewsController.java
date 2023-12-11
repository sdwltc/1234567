package com.example.mybatisplus_news_system.controller;
import com.example.mybatisplus_news_system.entity.News;
import com.example.mybatisplus_news_system.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/news")
public class NewsController
{
    private final NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService)
    {
        this.newsService = newsService;
    }

    //新闻列表的获取
    @GetMapping
    public ResponseEntity<List<News>> getNewsList()
    {
        //调用newsService中的getNewsList方法，即新闻列表的获取
        List<News> newsList = newsService.getNewsList();
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok(newsList);
    }

    //单条新闻的获取
    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable int id)
    {
        //调用newsService中的getNewsById方法，即单条新闻的获取
        News news = newsService.getNewsById(id);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok(news);
    }

    //新闻上传，即添加
    @PostMapping
    public ResponseEntity<?> insertNews(@RequestBody News news)
    {
        //调用newsService中的insertNews方法，即新闻上传，即添加
        newsService.insertNews(news);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("News uploaded successfully");
    }

    //新闻更改
    @PutMapping("/{id}")
    public ResponseEntity<?> updateNews(@PathVariable Long id, @RequestBody News news)
    {
        //调用newsService中的updateNewsById方法，即新闻更改
        newsService.updateNewsById(id,news);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("News updated successfully");
    }
}
