package cn.jxau.zsjyc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.jxau.zsjyc.pojo.ClassType;
import cn.jxau.zsjyc.service.ClassTypeService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.jxau.zsjyc.pojo.Articles;
import cn.jxau.zsjyc.service.ArticlesService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

@Controller
public class ArticlesAddController {
	final static String filepath="D:/zjcStaticFile/";
	@Autowired
	private ArticlesService articlesService;
	@Autowired
	private ClassTypeService classTypeService;

	@GetMapping("article-add")
	public String getArticles(Articles articles,Model model) {
		if(articles.getClassid()==null||articles.getClassid()==0){
			model.addAttribute("classid","");
		}else{
			model.addAttribute("classid",articles.getClassid());
		}
		model.addAttribute("articles", articles);
		model.addAttribute("classTypes",this.classTypeService.findClassTypeAll());
		return "article-add";
	}
	@PostMapping("getArticlebody")
	@ResponseBody
	public String getArticlebody(Articles id){
		Gson json=new Gson();
		Articles articles=this.articlesService.findArticlesById(id);
		if(articles==null){
			String str=json.toJson(new Articles(0));
			StringBuilder stringBuilder=new StringBuilder(str);
			stringBuilder.insert(str.length()-1,",\"mydate\":\""+new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()))+"\"");
			return stringBuilder.toString();
		}else{
			if(articles.getArticle()==null){
				articles.setArticle("");
			}
			String str=json.toJson(articles);
			StringBuilder stringBuilder=new StringBuilder(str);
			stringBuilder.insert(str.length()-1,",\"mydate\":\""+new SimpleDateFormat("yyyy-MM-dd").format(articles.getDate())+"\"");
			return stringBuilder.toString();
		}
	}

	@PostMapping("article-add")
	@ResponseBody
	public String postArticles(MultipartFile file, Articles articles, String editorValue,String mydate,int[] allowcomments, Model model) {
		JSONObject jsonObject=new JSONObject();
		boolean flag=true;
		if(articles.getClassid()==6&&file!=null&&!file.isEmpty()){
			String imgname=System.currentTimeMillis()+file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(filepath +"lunbotu/"+ imgname);
				Files.write(path, bytes);
			} catch (IOException e) {
			}
			articles.setImg("/lunbotu/" + imgname);
			flag=false;
		}
		if(allowcomments==null){
			articles.setComefrom("本站");
			articles.setArticle(editorValue);
		}
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try{
			date=simpleDateFormat.parse(mydate);
		}catch (Exception e){

		}
		articles.setDate(date);
		Articles articles1=this.articlesService.findArticlesById(articles);
		if(articles1==null) {
			this.articlesService.addArticles(articles);
		}else {
			if(flag){
				articles.setImg(articles1.getImg());
			}
			this.articlesService.modifyArticles(articles);
		}
		return "article-add";
	}

	@PostMapping("addDraft")
	@ResponseBody
	public String addDraft(Articles articles) {
		JSONObject jsonObject=new JSONObject();
		this.articlesService.addArticles(articles);
		jsonObject.put("status", "添加草稿成功");
		return jsonObject.toString();
	}
	
	
}
