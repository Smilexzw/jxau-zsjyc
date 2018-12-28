package cn.jxau.zsjyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxau.zsjyc.mapper.ClassTypeMapper;
import cn.jxau.zsjyc.pojo.ClassType;
import cn.jxau.zsjyc.service.ClassTypeService;

@Service
@Transactional
public class ClassTypeServiceImpl implements ClassTypeService {
	@Autowired
	private ClassTypeMapper classTypeMapper;
	@Override
	public List<ClassType> findClassTypeAll() {
		// TODO Auto-generated method stub
		return this.classTypeMapper.selectClassTypeAll();
	}

	@Override
	public void deleteClassType(ClassType classType) {
		// TODO Auto-generated method stub
		this.classTypeMapper.deleteClassType(classType);
	}

	@Override
	public void addClassType(ClassType classType) {
		// TODO Auto-generated method stub
		this.classTypeMapper.addClassType(classType);
	}

	@Override
	public void modifyClassType(ClassType classType) {
		// TODO Auto-generated method stub
		this.classTypeMapper.modifyClassType(classType);
	}

}
