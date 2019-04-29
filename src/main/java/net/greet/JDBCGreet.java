package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCGreet implements Greeting {
    final String DATABASE_LINK = "jdbc:h2:./target/names_db";
    final String ADD_NAME = "insert into people (name, counter) values (?, ?)";
    final String FIND_NAME = "select * from people";
    final String UPDATE_NAME = "update people set counter = counter + 1 where name = ?";
    final String RETURN_TABLE = "select * from people";
    final String DELETE_NAME = "delete from people where name = ?";
    final String DELETE_EVERYTHING = "delete from people";
    final String TABLE_SIZE = "select count(*) as counter from people";

    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";

    Map<String, Integer> userNames = new HashMap<>();

    Connection connection;
    PreparedStatement addName;
    PreparedStatement findName;
    PreparedStatement updateName;
    PreparedStatement returnTable;
    PreparedStatement deleteName;
    PreparedStatement deleteEverything;
    PreparedStatement tableSize;

    public JDBCGreet() {
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
//                int userNameCount = resultSet.getInt("count");
//                updateName.setInt(1, ++userNameCount);
                updateName.setString(1, name);
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
//            findName.setString(1, name);
            ResultSet resultSet = findName.executeQuery();
            System.out.println(resultSet.next());
            while (resultSet.next()) {
                userNames.put(resultSet.getString("name"), resultSet.getInt("counter"));
            }


            if (!name.equals(null)) {
                System.out.println("if");
                return name + " has been greeted " + userNames.get(name) + " time(s)";
            }
            return userNames.toString();
        }
        catch (SQLException e) {
//            e.printStackTrace();
            return userNames.toString();
//            return "Exception caught";
        }


    }

    public String counter() {
        return "number of names greeted: " + userNames.size();
    }

    public String clear(String name) {
        try {
            if (!name.equals(null)) {
                deleteName.setString(1, name);
                deleteName.executeUpdate();
                return name + " deleted!";
            }
            else {
                deleteEverything.executeUpdate();
                return "All names deleted";
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return name + " deleted!";
        }
    }

    public String help() {
        return GREEN + "Valid commands are:\ngreet - with a name will greet the person in a specified language\ngreeted - shows how many times a person was greeted\ncount - shows how many people were greeted\nclear - deletes a name or all names that were greeted\nhelp - displays commands to use\nexit - exits the application" + RESET;
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
}
