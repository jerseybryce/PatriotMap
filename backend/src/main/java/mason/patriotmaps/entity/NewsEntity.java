package mason.patriotmaps.entity;

import javax.persistence.*;

@Entity
@Table(name = "news_table")
public class NewsEntity {
    private String publ;
    @Id
    private String title;
    private String summary;

    public NewsEntity() {}

    public NewsEntity(String publ, String title, String summary) {
        this.publ = publ;
        this.title = title;
        this.summary = summary;
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

    public void setPubl(String publ) {
        this.publ = publ;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
