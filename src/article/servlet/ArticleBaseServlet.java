package article.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleService;


public abstract class ArticleBaseServlet extends HttpServlet {

    private static final long serialVersionUID = 7511427794068897945L;

    private ArticleService articleService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        articleService = ArticleService.getInstance();
    }


    protected ArticleService getArticleService() {
        return articleService;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }


    protected abstract void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
