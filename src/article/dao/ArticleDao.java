package article.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import article.domain.Article;


public class ArticleDao extends BaseDao {

    // @formatter:off
    private static String saveQuery = new StringBuilder()
            .append("CREATE Article ( \n")
            .append("    title, \n")
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
                pstmt.setString(1, user.getTitle());
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


    public List<Article> list() {
        return null;
    }
}
