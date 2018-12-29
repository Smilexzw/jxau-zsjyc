package cn.jxau.zsjyc.pojo;

import java.util.List;

public class Topbar {

    private Integer id;
    private Integer partent_id;
    private String title;
    private Integer level;
    private Integer article_id;

    List<Topbar> level2;


    @Override
    public String toString() {
        return "Topbar{" +
                "id=" + id +
                ", partent_id=" + partent_id +
                ", title='" + title + '\'' +
                ", level=" + level +
                ", article_id=" + article_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartent_id() {
        return partent_id;
    }

    public void setPartent_id(Integer partent_id) {
        this.partent_id = partent_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
}
