package article.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.domain.Article;


@WebServlet("/article/save")
public class ArticleSaveServlet extends ArticleBaseServlet {

    private static final long serialVersionUID = -7456016040731788727L;


    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Article article = new Article();
        article.setSubject(request.getParameter("subject"));
        article.setContent(request.getParameter("content"));

        getArticleService().save(article);

        response.sendRedirect(request.getContextPath() + "/article/list");
    }

}
