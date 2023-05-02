package lab8.compulsory;

import java.sql.*;

public class ArtistDAO {

    public void create(String name) throws SQLException
    {
        Connection connection = Database.getConnection();
        try(PreparedStatement pstmt = connection.prepareStatement("insert into artists (name) values (?)"))
        {
            pstmt.setString(1,name);
            pstmt.executeUpdate();
        }
        connection.commit();

    }
    public Artist findById(Integer id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stat = connection.createStatement())
        {
            ResultSet rs = stat.executeQuery("select id, name from artists where id ='"+id+"'");
            rs.next();
            return new Artist(rs.getInt("id"),rs.getString("name"));
        }
    }

    public Artist findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement stat = connection.prepareStatement("select id, name from artists where name = ?"))
        {
            stat.setString(1, name);
            ResultSet rs = stat.executeQuery();
            rs.next();
            return new Artist(rs.getInt("id"),rs.getString("name"));
        }
        catch (SQLException ex) {return null;}
    }
}

