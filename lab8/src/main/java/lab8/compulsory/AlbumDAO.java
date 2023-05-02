package lab8.compulsory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    public void create(int release_year, String title, Artist artist, List<Genre> genres) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into albums (artist_id, release_year,title) values (?,?,?)")) {
            pstmt.setInt(1, artist.id);
            pstmt.setInt(2, release_year);
            pstmt.setString(3, title);
            pstmt.executeUpdate();
        }
        connection.commit();
        int album_id;
        try (Statement stat = connection.createStatement()) {
            ResultSet rs = stat.executeQuery("select max(id) as id from albums");
            rs.next();
            album_id = rs.getInt("id");
        }

        for (int i = 0; i < genres.size(); ++i) {
            try (PreparedStatement pstmt = connection.prepareStatement("insert into albums_genre_assoc (genre_id,album_id) values (?,?)")) {
                pstmt.setInt(1, genres.get(i).id);
                pstmt.setInt(2, album_id);
                pstmt.executeUpdate();
            }
            connection.commit();
        }

        connection.commit();
    }

    public Album findById(Integer id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stat = connection.createStatement()) {
            ResultSet rs = stat.executeQuery("select id,title,release_year,artist_id from albums where id ='" + id + "'");
            rs.next();
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setTitle(rs.getString("title"));
            a.setRelease_year(rs.getInt("release_year"));
            a.setArtist(new ArtistDAO().findById(rs.getInt("artist_id")));

            List<Genre> genres = new ArrayList<>();

            ResultSet assoc = stat.executeQuery("select genre_id from albums_genre_assoc where album_id='"+a.id+"'");
            while(assoc.next())
            {
                genres.add(new GenreDAO().findById(assoc.getInt("genre_id")));
            }
            a.setGenres(genres);
            return a;
        }

    }

    public Album findBy_Name_Artist(String name, Artist artist) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement stat = connection.prepareStatement("select id from albums where title = ? and artist_id = ?")) {
            stat.setString(1,name);
            stat.setInt(2,artist.id);
            ResultSet rs = stat.executeQuery();
            rs.next();
            return findById(rs.getInt("id"));
        } catch (SQLException ex) { return null; }
    }

    public List<Integer> getIds() throws SQLException {
        List<Integer> ids = new ArrayList<>();
        Connection connection = Database.getConnection();
        try (PreparedStatement stat = connection.prepareStatement("select id from albums")) {
            ResultSet rs = stat.executeQuery();
            while(rs.next())
            ids.add(rs.getInt("id"));
        }
        return ids;
    }
}
