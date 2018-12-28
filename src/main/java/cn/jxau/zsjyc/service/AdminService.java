package cn.jxau.zsjyc.service;

import cn.jxau.zsjyc.pojo.Admin;

public interface AdminService {
	boolean login(Admin admin);
	boolean modify(Admin old, Admin admin);
	void add(Admin admin);
}
