package cn.jxau.zsjyc.service.impl;

import cn.jxau.zsjyc.mapper.TopbarMapper;
import cn.jxau.zsjyc.pojo.Topbar;
import cn.jxau.zsjyc.service.TopbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
@Service
public class TopbarServiceImpl implements TopbarService {

    @Autowired
    TopbarMapper topbarMapper;


    @Override
    public List<Topbar> getFirstLevels() {
        return topbarMapper.getFirstLevel();
    }

    @Override
    public List<Topbar> getSecondlevels() {
        return topbarMapper.getSecoedlevel();
    }
}
