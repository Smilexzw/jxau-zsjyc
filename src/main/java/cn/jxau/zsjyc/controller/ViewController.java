package cn.jxau.zsjyc.controller;

import cn.jxau.zsjyc.pojo.Articles;
import cn.jxau.zsjyc.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/view")
    public String view(Model model,Articles articles){
        articles=this.articlesService.findArticlesById(articles);
        if(articles==null){
            return "redirect:/";
        }
        this.articlesService.addViewTimes(articles.getId());
        if(!articles.getComefrom().equals("本站")) {
            return "redirect:" + articles.getComefrom();
        }
        List<Articles> articlesList=this.articlesService.findArticlesByClassId(7);
        Collections.reverse(articlesList);
        model.addAttribute("bk7",articlesList);
        model.addAttribute("articles",articles);
        return "view";
    }
}
