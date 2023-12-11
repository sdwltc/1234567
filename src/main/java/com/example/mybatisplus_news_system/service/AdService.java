package com.example.mybatisplus_news_system.service;
import com.example.mybatisplus_news_system.entity.Advertisement;
import java.util.List;

public interface AdService
{
    //广告上传，也就是添加广告，id自增
    void uploadAd(Advertisement advertisement);

    //特定广告获取，根据类型获取
    List<Advertisement> getAdByType(String type);

    //广告点击反馈，根据id
    void recordClick(Long id);

}
