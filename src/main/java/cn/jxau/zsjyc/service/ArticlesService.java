package cn.jxau.zsjyc.service;

import java.util.List;

import cn.jxau.zsjyc.pojo.Articles;

public interface ArticlesService {
	List<Articles> findArticlesAll();
	List<Articles> findArticlesByClassId(Integer id);
	List<Articles> findArticlesAllByClassId(Integer id);
	Articles findArticlesById(Articles articles);
	void modifyArticles(Articles articles);
	void deleteArticles(Articles articles);
	void addArticles(Articles articles);
	void addViewTimes(Integer id);
}
