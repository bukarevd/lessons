package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ArticleDao implements Dao {
    private static final String CONN = "jdbc:sqlite:DAO.db";
    private Connection connection;

    ArticleDao() {
        try {
            this.connection = DriverManager.getConnection(CONN);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void add(DataClass article) {
        Article articleDao = (Article) article;
        String insert = "INSERT INTO Article (id, iduser, title) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setInt(1, articleDao.getId());
            preparedStatement.setInt(2, articleDao.getIdUser());
            preparedStatement.setString(3, articleDao.getTitle());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.getMessage();
        }
    }

    @Override
    public void delete(DataClass article) {
        Article articleDao = (Article) article;
        String delete = "DELETE FROM Article WHERE id=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, articleDao.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public void update(DataClass article) {
        Article articleDao = (Article) article;
        Scanner in = new Scanner(System.in);
        System.out.println("Новый Title");
        String newTitle = in.next();
        System.out.println("Новый UserId");
        int userId = in.nextInt();

        String update = "UPDATE User SET id=?, login=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setInt(1, articleDao.getId());
            preparedStatement.setString(2, newTitle);
            preparedStatement.setInt(3, userId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void getAll() {

    }

    @Override
    public void getById(DataClass article) {

    }
}
