package cn.jxau.zsjyc.service;

import java.util.List;

import cn.jxau.zsjyc.pojo.ClassType;

public interface ClassTypeService {
	List<ClassType> findClassTypeAll();
	void deleteClassType(ClassType classType);
	void addClassType(ClassType classType);
	void modifyClassType(ClassType classType);
}
