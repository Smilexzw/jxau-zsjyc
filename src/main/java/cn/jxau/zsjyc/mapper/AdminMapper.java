package cn.jxau.zsjyc.mapper;

import cn.jxau.zsjyc.pojo.Admin;

public interface AdminMapper {
	Admin selectAdminByUser(String user) ;
	void updateUser(Admin admin);
	void insertAdmin(Admin admin);
}
