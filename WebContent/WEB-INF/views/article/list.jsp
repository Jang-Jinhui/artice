<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.List" %>
<%@ page import="article.domain.Article" %>

<!DOCTYPE html>

<body>
    <table>
        <thead>
            <tr>
                <th>No.</th>
                <th>Subject.</th>
                <th>Visited.</th>
                <th>Date.</th>
            </tr>
        </thead>
        <tbody>
            <% List<?> articles = (List<?>) request.getAttribute("articles"); %>
            <% for (int i = 0; i < articles.size(); ++i) {
                Article article = (Article) articles.get(i); %>
                <tr>
                    <td><%= i + 1 %>.</td>
                    <td><a href="#"><%= article.getSubject() %></a></td>
                    <td><%= article.getVisitCount() %></td>
                    <td><%= article.getCreateDate() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <pre>
    </pre>

    <div>
        <a href="create">Create</a>
    </div>
</body>