package article.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/article/list")
public class ArticleListServlet extends ArticleBaseServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("articles", getArticleService().listBy());

        request.getRequestDispatcher("/WEB-INF/views/article/list.jsp").forward(request, response);
    }
}
