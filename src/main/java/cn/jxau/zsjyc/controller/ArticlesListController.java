package cn.jxau.zsjyc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jxau.zsjyc.pojo.Articles;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxau.zsjyc.service.ArticlesService;

@Controller
public class ArticlesListController {
	
	@Autowired
	private ArticlesService articlesService;
	
	@GetMapping("/article-list")
	public String articleList(Model model) {
		List<Articles> articleslist=this.articlesService.findArticlesAll();
		model.addAttribute("articleslist",articleslist);
		model.addAttribute("articleslistsize",articleslist.size());
		return "article-list";
	}
	
	@PostMapping("/article_start")
	@ResponseBody
	public String articlestart(String id) {
		//TODO：文章上线
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", "已发布");
		return jsonObject.toString();
	}
	
	@PostMapping("/deleteArticles")
	@ResponseBody
	public String deleteArticles(int id) {
		Articles articles=new Articles();
		articles.setId(id);
		this.articlesService.deleteArticles(articles);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", "已删除");
		return jsonObject.toString();
	}
	
	
}
