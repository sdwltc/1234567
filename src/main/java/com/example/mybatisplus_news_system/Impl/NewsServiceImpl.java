package com.example.mybatisplus_news_system.Impl;

import com.example.mybatisplus_news_system.entity.News;
import com.example.mybatisplus_news_system.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mybatisplus_news_system.service.NewsService;
import java.util.List;
/*MyBatis-Plus 方法：基础 CRUD 操作：

insert(): 插入一条记录。
deleteById(): 根据主键 ID 删除记录。
deleteByMap(): 根据 columnMap 条件删除记录。
delete(): 根据 Wrapper 条件构造器删除记录。
updateById(): 根据主键 ID 更新记录。
update(): 根据 whereEntity 条件，更新记录。
selectById(): 根据主键 ID 查询记录。
selectBatchIds(): 根据主键 ID 列表查询记录。
selectByMap(): 根据 columnMap 条件查询记录。
selectOne(): 查询满足条件的一条记录。
selectList(): 查询满足条件的多条记录。
selectPage(): 分页查询。
selectMaps(): 查询满足条件的多条记录，返回 Map 列表。
selectMapsPage(): 分页查询，返回 Map 列表。
selectCount(): 查询满足条件的记录数。
selectObjs(): 查询满足条件的记录，只返回第一个字段的值 */
@Service
public class NewsServiceImpl implements NewsService
    //实现类,实现service层的接口,调用dao层的方法，必须加上@Service注解，且要实现service 定义的方法
{
    private final NewsMapper newsMapper;//不可变变量，用于数据库交互
    @Autowired//通过构造函数自动注入NewsMapper实例
    public NewsServiceImpl(NewsMapper newsMapper)
    {
        this.newsMapper = newsMapper;
    }

    //开始实现接口中的方法
    @Override
    //新闻列表获取
    public List<News> getNewsList()
    {
        // 使用 MyBatis-Plus 的 selectList 方法获取所有新闻
        // 传入 null 作为参数表示没有条件限制,返回一个List<News>类型的数据,即所有新闻
        return newsMapper.selectList(null);
    }

    @Override
    //单条新闻获取
    public News getNewsById(int id)
    {
        // 使用 MyBatis-Plus 的 selectById 方法获取单条新闻
        // 传入 id 作为参数表示根据 id 获取新闻,返回一个News类型的数据,即单条新闻
        return newsMapper.selectById(id);
    }

    @Override
    //新闻添加
    public void insertNews(News news)//创建新闻时不需要id，因为id是自增的
    {
        // 使用 MyBatis-Plus 的 insert 方法添加新闻
        // 传入 news 作为参数表示添加新闻,返回一个int类型的数据,即添加的新闻的id
        newsMapper.insert(news);
    }

    @Override
    //新闻更改
    public void updateNewsById(Long id,News news)
    {
        news.setId(id);//设置新闻id
        // 使用 MyBatis-Plus 的 updateById 方法更改新闻
        newsMapper.updateById(news);
    }


}
