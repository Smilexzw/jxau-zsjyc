package cn.jxau.zsjyc.service.impl;

import cn.jxau.zsjyc.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxau.zsjyc.mapper.AdminMapper;
import cn.jxau.zsjyc.pojo.Admin;
import cn.jxau.zsjyc.service.AdminService;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public boolean login(Admin admin) {
		Admin reall=this.adminMapper.selectAdminByUser(PasswordEncoder.encodeStr(admin.getUsername()));
		if (reall==null){
			return false;
		}
		return PasswordEncoder.encodeStr(admin.getPassword()).equals(reall.getPassword());
	}

	@Override
	public boolean modify(Admin old, Admin admin) {
		Admin reall=this.adminMapper.selectAdminByUser(PasswordEncoder.encodeStr(old.getUsername()));
		if (reall==null){
			return false;
		}
		if(PasswordEncoder.encodeStr(old.getPassword()).equals(reall.getPassword())){
			Admin temp=new Admin();
			temp.setId(reall.getId());
			temp.setUsername(PasswordEncoder.encodeStr(admin.getUsername()));
			temp.setPassword(PasswordEncoder.encodeStr(admin.getPassword()));
			this.adminMapper.updateUser(temp);
			return true;
		}
		return false;
	}

	@Override
	public void add(Admin admin) {
		admin.setUsername(PasswordEncoder.encodeStr(admin.getUsername()));
		admin.setPassword(PasswordEncoder.encodeStr(admin.getPassword()));
		this.adminMapper.insertAdmin(admin);
	}
}
