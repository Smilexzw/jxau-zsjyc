package cn.jxau.zsjyc.mapper;

import cn.jxau.zsjyc.pojo.Topbar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TopbarMapper {

    @Select("select * from topbar where level = 1 ")
    public List<Topbar> getFirstLevel();

    @Select("select * from topbar where `level`=2")
    public List<Topbar> getSecoedlevel();

}
