package cn.jxau.zsjyc.controller;

import cn.jxau.zsjyc.pojo.Articles;
import cn.jxau.zsjyc.pojo.ClassType;
import cn.jxau.zsjyc.service.ArticlesService;
import cn.jxau.zsjyc.service.ClassTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class MoreController {
    @Autowired
    private ArticlesService articlesService;
    @Autowired
    private ClassTypeService classTypeService;

    @GetMapping("/more")
    public String more(Integer id, Model model){
        for (ClassType classType:this.classTypeService.findClassTypeAll()) {
            if(classType.getId()!=7){
                model.addAttribute("bk"+classType.getId(),this.articlesService.findArticlesAllByClassId(classType.getId()));
            }
        }
        List<Articles> articlesList=this.articlesService.findArticlesByClassId(7);
        Collections.reverse(articlesList);
        model.addAttribute("bk7",articlesList);
        model.addAttribute("");
        return "more";
    }
}
