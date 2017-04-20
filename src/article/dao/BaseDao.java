package article.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public abstract class BaseDao {

    protected Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");

            return DriverManager.getConnection("jdbc:h2:~/apps/h2db/article;DATABASE_TO_UPPER=false", "sa", "");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    protected void closeQuietly(Connection conn) {
        try {
            if (Objects.nonNull(conn)) {
                conn.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected void closeQuietly(PreparedStatement stmt, Connection conn) {
        try {
            if (Objects.nonNull(stmt)) {
                stmt.close();
            }
            if (Objects.nonNull(conn)) {
                conn.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected void closeQuietly(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (Objects.nonNull(stmt)) {
                stmt.close();
            }
            if (Objects.nonNull(rs)) {
                rs.close();
            }
            if (Objects.nonNull(conn)) {
                conn.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
