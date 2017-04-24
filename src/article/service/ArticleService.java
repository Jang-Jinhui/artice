package article.service;


import java.util.List;

import article.dao.ArticleDao;
import article.domain.Article;


public class ArticleService {

    private static ArticleService instance = new ArticleService();
    private ArticleDao articleDao = new ArticleDao();


    private ArticleService() {
    }


    public static ArticleService getInstance() {
        return instance;
    }


    public List<Article> listBy() {
        return articleDao.listBy();
    }


    public void save(Article article) {
        articleDao.save(article);;
    }

}
