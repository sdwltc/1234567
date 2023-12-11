package com.example.mybatisplus_news_system.Impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus_news_system.entity.Advertisement;
import com.example.mybatisplus_news_system.mapper.AdMapper;
import com.example.mybatisplus_news_system.service.AdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdServiceImpl implements AdService
{
    private final AdMapper adMapper;
    @Autowired
    public AdServiceImpl(AdMapper adMapper)
    {
        this.adMapper = adMapper;
    }

    @Override
    //广告上传，即广告添加
    public void uploadAd(Advertisement advertisement)
    {
        adMapper.insert(advertisement);
    }

    @Override
    //特定广告获取,根据 type 获取
    public List<Advertisement> getAdByType(String type)
    {
        //用queryWrapper构造查询条件
        QueryWrapper<Advertisement> queryWrapper = new QueryWrapper<>();
        //eq表示等于，即type等于传入的type，“type” 是数据库中的名字，type是传入的参数
        queryWrapper.eq("TYPE",type);//这行代码的意思是：select * from advertisement where type = type
        //返回一个List<Advertisement>类型的数据，即特定广告
        return adMapper.selectList(queryWrapper);//adMapper是广告的mapper
    }

    @Override
    //广告点击反馈，逻辑：读取广告，加 1 次数，更新广告
    public void recordClick(Long id)
    {
        //读取广告
        Advertisement advertisement = adMapper.selectById(id);
        //加 1 次数
        if(advertisement != null)
        {
            advertisement.setClickCount(advertisement.getClickCount() + 1);
            //更新广告
            adMapper.updateById(advertisement);
        }

    }
}
