package cn.jxau.zsjyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxau.zsjyc.mapper.ArticlesMapper;
import cn.jxau.zsjyc.pojo.Articles;
import cn.jxau.zsjyc.service.ArticlesService;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService {
	@Autowired
	private ArticlesMapper articlesMapper;
	@Override
	public List<Articles> findArticlesAll() {
		return this.articlesMapper.selectArticlesAll();
	}

	@Override
	public List<Articles> findArticlesByClassId(Integer id) {
		return this.articlesMapper.selectArticlesByClassid(id);
	}

	@Override
	public List<Articles> findArticlesAllByClassId(Integer id) {
		return this.articlesMapper.selectArticlesAllByClassid(id);
	}

	@Override
	public Articles findArticlesById(Articles articles) {
		return this.articlesMapper.selectArticlesById(articles.getId());
	}

	@Override
	public void addArticles(Articles articles) {
		//this.articlesMapper.addArticles1(articles);
		this.articlesMapper.addArticles(articles);
	}

	@Override
	public void addViewTimes(Integer id) {
		this.articlesMapper.addViewTime(id);
	}

	@Override
	public void modifyArticles(Articles articles) {
		//this.articlesMapper.modifyArticles1(articles);
		//this.articlesMapper.modifyArticles2(articles);
		this.articlesMapper.modifyArticles(articles);
	}
	@Override
	public void deleteArticles(Articles articles) {
		//articles=this.articlesMapper.selectArticlesById(articles.getId());
		//this.articlesMapper.deleteArticles1(articles);
		this.articlesMapper.deleteArticles(articles);
	}
}
