package com.tactfactory.ovg.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tactfactory.ovg.entities.User;

@Repository
public class UserRepository {

    @Autowired
    private EntityManager manager;

    private Connection connection() {
        return this.manager.getConnection();
    }

    public void insertOne(String username, String password) throws SQLException {
        final Statement stm = this.connection().createStatement();

        final String query = String.format("INSERT INTO sys_user (username, password) VALUES (\"%s\", \"%s\")",
                username, password);

        System.out.println("Query: " + query);
        stm.executeUpdate(query);
    }

    public List<User> findAll() throws SQLException {
        final List<User> result = new ArrayList<User>();
        final Statement stm = connection().createStatement();
        final String query = "SELECT * FROM sys_user";

        System.out.println("Query: " + query);
        final ResultSet usersRS = stm.executeQuery(query);

        while (usersRS.next()) {
            final int id = usersRS.getInt("id");
            final String username = usersRS.getString("username");
            final String password = usersRS.getString("password");

            result.add(new User(id, username, password));
        }

        return result;
    }
}
