package cn.jxau.zsjyc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.jxau.zsjyc.util.IpUtil;
import cn.jxau.zsjyc.util.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import cn.jxau.zsjyc.config.WebSecurityConfig;
import cn.jxau.zsjyc.pojo.Admin;
import cn.jxau.zsjyc.service.AdminService;
import cn.jxau.zsjyc.service.ClassTypeService;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	@Autowired
	private ClassTypeService classTypeService;
	public static boolean timelock=false;
	public void timeLater(){
		timelock=true;
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				timelock=false;
			}
		},1000);
	}
	@PostMapping("/login")
	public String checklogin(HttpServletRequest request, Admin admin, HttpSession session, Model model){
		//TODO：延时限制验证
		try{
			logger.info("ip:"+ IpUtil.getIpAddr(request) +"\t"+admin.getUsername()+"\t"+PasswordEncoder.encodeStr(admin.getPassword()));
		}catch (Exception e){

		}finally {
			if(timelock==true){
				model.addAttribute("msg","尝试次数过多，请稍后尝试");
				return "login";
			}
			if(this.adminService.login(admin)){
				session.setAttribute(WebSecurityConfig.SESSION_KEY, admin);
				return "redirect:/adminindex";
			}
			model.addAttribute("msg","用户名或密码错误");
			timeLater();
			return "login";
		}
	}

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
    
    @GetMapping("/adminindex")
    public String adminindex(Model model) {
    	model.addAttribute("classtypeList", this.classTypeService.findClassTypeAll());
    	return "adminindex";
    }
    
    @GetMapping("/admin-password-edit")
    public String adminPasswordEdit() {
    	return "admin-password-edit";
    }

    @RequestMapping("/keepsession")
	@ResponseBody
	public String keepsession(){
		return "1";
	}
    
    @PostMapping("password_modify")
    @ResponseBody
    public String passwordModify(String olduser,String newuser,String newuser2,String oldpassword,String newpassword,String newpassword2) {
    	Admin admin=new Admin();
    	admin.setUsername(olduser);
    	admin.setPassword(oldpassword);
    	if(!this.adminService.login(admin)){
    	    return "原用户名或密码输入错误！";
        }
    	if(!newuser.equals(newuser2)){
    	    return "两次输入的用户名不一致！";
        }
    	if(!newpassword.equals(newpassword2)){
    	    return  "两次输入的密码不一致！";
        }
    	Admin admin1=new Admin();
    	admin1.setUsername(newuser);
    	admin1.setPassword(newpassword);
    	if(this.adminService.modify(admin,admin1)){
            return "修改成功！";
        }
    	return "修改失败！";
    }

    @RequestMapping("addAdmin")
	@ResponseBody
	public String addAdmin(Admin admin){
		this.adminService.add(admin);
		return "成功";
	}
}
