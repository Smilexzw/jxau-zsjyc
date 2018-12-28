package cn.jxau.zsjyc.mapper;

import java.util.List;

import cn.jxau.zsjyc.pojo.ClassType;

public interface ClassTypeMapper {
	List<ClassType> selectClassTypeAll();
	void modifyClassType(ClassType classType);
	void deleteClassType(ClassType classType);
	void addClassType(ClassType classType);
}
