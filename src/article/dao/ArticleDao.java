package article.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import article.domain.Article;


public class ArticleDao extends BaseDao {

    // @formatter:off
    private static String listByQuery = new StringBuilder()
            .append("SELECT \n")
            .append("    id, \n")
            .append("    subject, \n")
            .append("    content, \n")
            .append("    visitCount, \n")
            .append("    createDate \n")
            .append("FROM Article \n")
        .toString();
    // @formatter:on
    public List<Article> listBy() {
        try (Connection conn = getConnection()) {
            ResultSet rs = null;
            try (PreparedStatement pstmt = conn.prepareStatement(listByQuery)) {
                rs = pstmt.executeQuery();

                List<Article> articles = new ArrayList<Article>();
                while (rs.next()) {
                    Article obj = new Article();
                    obj.setId(rs.getLong("id"));
                    obj.setSubject(rs.getString("subject"));
                    obj.setContent(rs.getString("content"));
                    obj.setVisitCount(rs.getInt("visitCount"));
                    obj.setCreateDate(rs.getDate("createDate"));
                    articles.add(obj);
                }
                return articles;
            }
            finally {
                closeQuietly(rs, null, null);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // @formatter:off
    private static String saveQuery = new StringBuilder()
            .append("CREATE Article ( \n")
            .append("    subject, \n")
            .append("    content \n")
            .append(") \n")
            .append("VALUES ( \n")
            .append("    ?, \n")
            .append("    ? \n")
            .append(") \n")
        .toString();
    // @formatter:on
    public void save(Article user) {
        try (Connection conn = getConnection()) {
            //PreparedStatement pstmt = null;
            ResultSet rs = null;
            try (PreparedStatement pstmt = conn.prepareStatement(saveQuery)) {
                pstmt.setString(1, user.getSubject());
                pstmt.setString(2, user.getContent());
                pstmt.execute();
            }
            finally {
                closeQuietly(rs, null, null);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
