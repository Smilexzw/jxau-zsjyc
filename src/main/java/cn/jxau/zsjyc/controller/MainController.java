package cn.jxau.zsjyc.controller;

import cn.jxau.zsjyc.mapper.ArticlesMapper;
import cn.jxau.zsjyc.mapper.ClassTypeMapper;
import cn.jxau.zsjyc.pojo.Articles;
import cn.jxau.zsjyc.pojo.ClassType;
import cn.jxau.zsjyc.service.ClassTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.jxau.zsjyc.service.ArticlesService;

import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	private ArticlesService articlesService;
	@Autowired
	private ClassTypeService classTypeService;


	@GetMapping("/{page}")
	public String showPage(@PathVariable String page) {
		if(page.contains("denglu")||page.contains("后台")||page.contains("登录"))
			return "redirect:/login";
		return "redirect:/";
	} 
	
	
	@GetMapping("/")
    public String index(Model model) {
		for (ClassType classtype:this.classTypeService.findClassTypeAll()) {
			model.addAttribute("bk" + classtype.getId() + "name", classtype.getClassname());
			List<Articles> articlesList=this.articlesService.findArticlesByClassId(classtype.getId());
			if (classtype.getId()==7){
				Collections.reverse(articlesList);
			}
			model.addAttribute("bk" + classtype.getId(),articlesList );
		}
        return "index";
    }

}
