package cn.jxau.zsjyc.mapper;

import java.util.Date;
import java.util.List;

import cn.jxau.zsjyc.pojo.Articles;

public interface ArticlesMapper {
	Articles selectArticlesById(Integer id); //查找通过id
	List<Articles> selectArticlesAll();  //获得所有文章
	List<Articles> selectArticlesByClassid(Integer id);  //查找通过classid
	List<Articles> selectArticlesAllByClassid(Integer id);
	List<Articles> selectArticlesByDate(Date date1, Date date2); //查找通过日期
	List<Articles> selectArticlesByKeyTitle(String keywords); //通过标题查找
	List<Articles> selectArticlesByKeyWords(String keywords); //通过文章关键词查找
	void addArticles1(Articles articles);
	void addArticles(Articles articles);
	void modifyArticles(Articles articles);
	void modifyArticles1(Articles articles);
	void modifyArticles2(Articles articles);
	void deleteArticles(Articles articles);
	void deleteArticles1(Articles articles);
	void addViewTime(Integer id);
}
