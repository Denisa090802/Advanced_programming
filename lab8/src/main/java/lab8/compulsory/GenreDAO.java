package lab8.compulsory;

import java.sql.*;

public class GenreDAO {

    public void create(String name) throws SQLException
    {
        Connection connection = Database.getConnection();
        try(PreparedStatement pstmt = connection.prepareStatement("insert into genres (name) values (?)"))
        {
            pstmt.setString(1,name);
            pstmt.executeUpdate();
        }
        connection.commit();

    }
    public Genre findById(Integer id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stat = connection.createStatement())
        {
            ResultSet rs = stat.executeQuery("select id, name from genres where id ='"+id+"'");
            rs.next();
            return new Genre(rs.getInt("id"),rs.getString("name"));
        }
    }

    public Genre findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement stat = connection.prepareStatement("select id, name from genres where name = ? "))
        {
            stat.setString(1,name);
            ResultSet rs = stat.executeQuery();
            rs.next();
            return new Genre(rs.getInt("id"),rs.getString("name"));
        }
        catch (SQLException ex) {return null;}
    }
}
