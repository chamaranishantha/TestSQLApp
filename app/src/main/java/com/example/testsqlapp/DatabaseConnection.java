package com.example.testsqlapp;

import static android.content.ContentValues.TAG;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection extends AsyncTask<Void, Void, List<User>> {

    private static final String URL = "jdbc:sqlserver://192.168.1.3:1433;databaseName=TestAppDB";
    private static final String USER = "sa";
    private static final String PASSWORD = "admin@123";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: Starting database connection task");
    }

//    @Override
//    protected List<User> doInBackground(Void... voids) {
//        List<User> userList = new ArrayList<>();
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            Log.d(TAG, "doInBackground: Database connection established");
//
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT id, username, password FROM users");
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                userList.add(new User(id, username, password));
//            }
//            Log.d(TAG, "doInBackground: Query executed successfully");
//
//        } catch (Exception e) {
//            Log.e(TAG, "Error connecting to database", e);
//        } finally {
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//                Log.d(TAG, "doInBackground: Database resources closed");
//            } catch (Exception e) {
//                Log.e(TAG, "Error closing database resources", e);
//            }
//        }
//        return userList;
//    }

    @Override
    protected List<User> doInBackground(Void... voids) {
        List<User> userList = new ArrayList<>();
        // Dummy data for testing
        userList.add(new User(1, "dummyuser1", "password1"));
        userList.add(new User(2, "dummyuser2", "password2"));

        // Database connection code...

        return userList;
    }


    @Override
    protected void onPostExecute(List<User> users) {
        super.onPostExecute(users);
        Log.d(TAG, "onPostExecute: Task completed with " + users.size() + " users");
    }
}
