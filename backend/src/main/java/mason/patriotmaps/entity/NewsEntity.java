package mason.patriotmaps.entity;

import javax.persistence.*;

@Entity
@Table(name = "news_table")
public class NewsEntity {
    private String publ;
    @Id
    private String title;
    private String summary;
    private String link;

    public NewsEntity() {}

    public NewsEntity(String publ, String title, String summary, String link) {
        this.publ = publ;
        this.title = title;
        this.summary = summary;
        this.link = link;
    }

    public String getPubl() {
        return publ;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getLink() {
        return link;
    }

    public void setPubl(String publ) {
        this.publ = publ;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
