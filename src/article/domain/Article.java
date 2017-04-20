package article.domain;


import java.util.Date;


public class Article {

    private Long id;
    private String subject;
    private String content;
    private Integer visitCount;
    private Date createDate;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Integer getVisitCount() {
        return visitCount;
    }


    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }


    public Date getCreateDate() {
        return createDate;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
