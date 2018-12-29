package cn.jxau.zsjyc.service;

import cn.jxau.zsjyc.pojo.Topbar;

import java.util.List;

public interface TopbarService {

    public List<Topbar> getFirstLevels();

    public List<Topbar> getSecondlevels();

}
