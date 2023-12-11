package com.example.mybatisplus_news_system.controller;
import com.example.mybatisplus_news_system.entity.Advertisement;
import com.example.mybatisplus_news_system.service.AdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/advertisements")
public class AdController
{
    private final AdService adService;
    @Autowired
    public AdController(AdService adService)
    {
        this.adService = adService;
    }

    //广告上传，即广告添加
    @PostMapping
    public ResponseEntity<?> uploadAd(@RequestBody Advertisement advertisement)
    {
        //调用adService中的uploadAd方法，即广告上传，即广告添加
        adService.uploadAd(advertisement);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("Advertisement uploaded successfully");
    }

    //根据类型获取广告
    @GetMapping("/type/{adType}")
    public ResponseEntity<?> getAdByType(@PathVariable String adType)
    {
        List<Advertisement> advertisementList = adService.getAdByType(adType);
        return ResponseEntity.ok(advertisementList);
    }

    //广告点击反馈，根据id
    @PostMapping("/{id}/click")
    public ResponseEntity<?> recordClick(@PathVariable Long id)
    {
        //调用adService中的recordClick方法，即广告点击反馈
        adService.recordClick(id);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("Advertisement clicked successfully");
    }
}
