package ru.banana.DAO;

import org.springframework.stereotype.Component;
import ru.banana.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {


    public List<User> index() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from user";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User show(int id) {
        return null;
    }

    public void save(User user) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "insert into person values(" + 1 + ", " + "'" + user.getName()
                    + "', " + user.getAge() + ", '" + user.getEmail() + "')";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, User updatedUser) {
    }

    public void delete(int id) {
    }
}