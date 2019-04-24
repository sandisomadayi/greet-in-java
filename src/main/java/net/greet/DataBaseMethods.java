package net.greet;

import java.sql.*;

public class DataBaseMethods implements Greeting {
    final String DATABASE_LINK = "jdbc:h2:./target/names_db";
    final String ADD_NAME = "insert into people (name, count) values (?, ?)";
    final String FIND_NAME = "select count from people where name = ?";
    final String UPDATE_NAME = "update people set count = ? where name = ?";
    final String RETURN_TABLE = "select * from people";
    final String DELETE_NAME = "delete from people where name = ?";
    final String DELETE_EVERYTHING = "delete from people";
    final String TABLE_SIZE = "select count(*) from people";

    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";

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
            connection = DriverManager.getConnection(DATABASE_LINK, "sa", "");

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

    public String greet(String name, String language) {
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
            return Language.valueOf(language).getGreeting() + name;
        }
        catch (Exception e) {
            return Language.valueOf("english").getGreeting() + name;
        }
    }


    public String greeted(String name) {
        try {
            findName.setString(1, name);
            ResultSet resultSet = findName.executeQuery();
            if (!name.equals(null)) {
                return name + "has been greeted " + (resultSet.getInt("count")) + " time(s)";
            }
            else {
                return "0";
            }
        }
        catch (SQLException e) {
//            e.printStackTrace();
            return "Exception caught";
        }
    }

    public String counter() {
        return null;
    }

    public String clear(String name) {
        try {
            if (!name.equals(null)) {
                deleteName.setString(1, name);
                deleteName.executeUpdate();
            }
            else {
                deleteEverything.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return name + " cleared!";
    }

    public String help() {
        return GREEN + "Valid commands are:\ngreet\ngreeted\ncount\nclear\nhelp\nexit\n" + RESET;
    }

    public int count(String name) {
        try {
            findName.setString(1, name);
            ResultSet resultSet = findName.executeQuery();
            return resultSet.getInt("count");
        }
        catch (SQLException e) {
            return 0;
        }
    }

    public String count() {
        try {
            return tableSize.executeQuery().toString();
        }
        catch (SQLException e) {
            return "Database is empty";
        }
    }

    public String table() {
        try {
            ResultSet resultSet = returnTable.executeQuery();
            return resultSet.toString();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return returnTable.toString();
        }
    }
}
