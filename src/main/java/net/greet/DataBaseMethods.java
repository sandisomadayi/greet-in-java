package net.greet;

import org.junit.Test;

import java.sql.*;

public class DataBaseMethods {
    final String DATABASE_LINK = "jdbc:h2:./target/userNames_db";
    final String ADD_NAME = "insert into people (name, count) values (?, ?)";
    final String FIND_NAME = "select count from people where name = ?";
    final String UPDATE_NAME = "update people set count = ? where name = ?";
    final String RETURN_TABLE = "select * from people";
    final String DELETE_NAME = "delete from people where name = ?";
    final String DELETE_EVERYTHING = "delete from people";
    final String TABLE_SIZE = "select count(*) from people";

    Connection connection;
    PreparedStatement addName;
    PreparedStatement findName;
    PreparedStatement updateName;
    PreparedStatement returnTable;
    PreparedStatement deleteName;
    PreparedStatement deleteEverything;
    PreparedStatement tableSize;

    public void greetingsDB() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DATABASE_LINK);

            addName = connection.prepareStatement(ADD_NAME);
            findName = connection.prepareStatement(FIND_NAME);
            updateName = connection.prepareStatement(UPDATE_NAME);
            returnTable = connection.prepareStatement(RETURN_TABLE);
            deleteName = connection.prepareStatement(DELETE_NAME);
            deleteEverything = connection.prepareStatement(DELETE_EVERYTHING);
            tableSize = connection.prepareStatement(TABLE_SIZE);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String greet(String name, Language language) {
        try {
            findName.setString(1, name);
            ResultSet resultSet = findName.executeQuery();
            if (resultSet.next()) {
                int userNameCount = resultSet.getInt("count");
                updateName.setInt(1, ++userNameCount);
                updateName.setString(2, name);
                updateName.execute();
            }
            else {
                addName.setString(1, name);
                addName.setInt(2, 1);
                addName.execute();
            }
            return Language.valueOf(language.toString()).getGreeting() + " " + name;
        }
        catch (Exception e) {
            return Language.valueOf("english").getGreeting() + " " + name;
        }
    }

    public int greeted(String name) {
        try {
            findName.setString(1, name);
            ResultSet resultSet = findName.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
            return 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void clear(String name) {
        try {
            if (!name.equals(null)) {
                deleteName.setString(1, name);
                deleteName.execute();
            }
            else {
                deleteEverything.execute();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int count(String name) {
        try {
            findName.setString(1, name);
            ResultSet resultSet = findName.executeQuery();
            int nameCount = resultSet.getInt("count");
            return nameCount;
        }
        catch (SQLException e) {
            return 0;
        }
    }
}
