package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCGreet implements Greeting {
    final String DATABASE_LINK = "jdbc:h2:./target/names_db";
    final String ADD_NAME = "insert into people (name, counter) values (?, ?)";
    final String FIND_NAME = "select * from people where name = ?";
    final String UPDATE_NAME = "update people set counter = counter + 1 where name = ?";
    final String RETURN_TABLE = "select * from people";
    final String DELETE_NAME = "delete from people where name = ?";
    final String DELETE_EVERYTHING = "delete from people";
    final String TABLE_SIZE = "select count(*) as counter from people";

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
        Map<String, Integer> userNames = new HashMap<>();

        try {
            ResultSet resultSet = returnTable.executeQuery();
            while (resultSet.next()) {
                userNames.put(resultSet.getString("name"), resultSet.getInt("counter"));
            }

            for (Map.Entry<String, Integer> entry:userNames.entrySet()) {
                System.out.println(entry.getKey() + ":  " + entry.getValue());
            }


            if (!name.equals(null)) {
                if (userNames.containsKey(name)) {
                    return name + " has been greeted " + userNames.get(name) + " time(s)";
                }
                else {
                    return name + " has not been greeted, try greeting it first.";
                }
            }

            return userNames.toString();

        }
        catch (Exception e) {
            return userNames.toString();
        }


    }

    public String clear(String name) {
        Map<String, Integer> userNames = new HashMap<>();

        try {
            ResultSet resultSet = returnTable.executeQuery();

            while (resultSet.next()) {
                userNames.put(resultSet.getString("name"), resultSet.getInt("counter"));
            }
            deleteName.setString(1, name);
            deleteName.executeUpdate();

            if (name == null) {
                deleteEverything.executeUpdate();
                return "All names deleted!";
            }
            else {
                if (userNames.containsKey(name)) {
                    return name + " deleted!";
                }
                else {
                    return name + " has not been greeted, try greeting it first.";
                }
            }


        }
        catch (Exception e) {
            e.printStackTrace();
            return name + " deleted!";
        }
    }

    public String help() {
        return "Valid commands are:\ngreet - with a name will greet the person in a specified language\ngreeted - shows how many times a person was greeted\ncount - shows how many people were greeted\nclear - deletes a name or all names that were greeted\nhelp - displays commands to use\nexit - exits the application";
    }

    public String counter() {
        Map<String, Integer> userNames = new HashMap<>();
        try {

            ResultSet resultSet = returnTable.executeQuery();
            while (resultSet.next()) {
                userNames.put(resultSet.getString("name"), resultSet.getInt("counter"));
            }
            return "names greeted: " + userNames.size();
        }
        catch (Exception e) {
            return "names greeted: " + userNames.size();
        }
    }
}
