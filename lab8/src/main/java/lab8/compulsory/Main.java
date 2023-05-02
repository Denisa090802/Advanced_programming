package lab8.compulsory;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        ArtistDAO artistDAO = new ArtistDAO();
        GenreDAO genreDao = new GenreDAO();
        AlbumDAO albumDAO = new AlbumDAO();

        File file = new File("C:\\Users\\maria\\Desktop\\Advanced_programming\\lab8\\src\\main\\java\\lab8\\compulsory\\albumlist.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] tempArr;
        br.readLine();
        while((line = br.readLine()) != null) {
            tempArr = line.split(",");

            int year = Integer.parseInt(tempArr[1]);
            String album_title = tempArr[2];
            String artist_name = tempArr[3];
            String genre_name = tempArr[4];

            Artist artist = artistDAO.findByName(artist_name);
            if(artist == null)
            {
                artistDAO.create(artist_name);
                artist = artistDAO.findByName(artist_name);
            }

            Genre genre = genreDao.findByName(genre_name);
            if(genre == null)
            {
                genreDao.create(genre_name);
                genre = genreDao.findByName(genre_name);
            }

            Album album = albumDAO.findBy_Name_Artist(album_title,artist);
            if(album == null)
            {
                albumDAO.create(year,album_title,artist,Arrays.asList(genre));
            }
        }
        br.close();
        System.out.println("done");
        for (Integer id : albumDAO.getIds()) {
            Album a = albumDAO.findById(id);
            System.out.println(a);
        }
    }
}
