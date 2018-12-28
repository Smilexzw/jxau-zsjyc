package cn.jxau.zsjyc.pojo;

import java.util.Date;

public class Articles {
	private Integer id; 
	private String title;
	private Integer classid;
	private String classname;
	private Date date;
	private Integer viewtimes;
	private String comefrom;
	private Integer index;
	private String article;
	private int status;
	private String img;
	public Articles(){

	}
	public Articles(Integer i){
		this.id=0;
		this.title="";
		this.classid=0;
		this.classname="";
		this.date=new Date();
		this.viewtimes=0;
		this.comefrom="";
		this.index=0;
		this.article="";
		this.status=0;
		this.img="";
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComefrom() {
		return comefrom;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getViewtimes() {
		return viewtimes;
	}
	public void setViewtimes(Integer viewtimes) {
		this.viewtimes = viewtimes;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
