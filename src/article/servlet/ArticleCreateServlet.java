package article.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/article/create")
public class ArticleCreateServlet extends ArticleBaseServlet {

    private static final long serialVersionUID = -970970490980882471L;


    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/article/create.jsp").forward(request, response);
    }

}
