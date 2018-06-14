package com.company.testing;

import java.sql.*;

/**
 * code with multiple functions
 * the program should detect vulnerabilities in each function
 * There is also a case of executeQuery within an executeQuery, for this case we output line number for the fundamental executeQuery(i.e. the innermost executeQuery)
 */

// Implemented
// Injection occurs on line numbers [29, 31, 33, 35, 51, 67]

public class MultipleFunctions {


  public static void methodNumber1(Connection connection, String urlParameter, String pass) {

    int a = 7 + 8;
    String show = "Sample text 1", xy = "Sample text" + pass;
    String accountBalanceQuery = "SELECT account_number, balance FROM accounts WHERE account_owner_id = " + urlParameter;
    String moreConcatenation = "SELECT user_id, FROM data WHERE status = " + show + accountBalanceQuery ;
    accountBalanceQuery = "Sample text 2" + show;
    String moreMoreConcatenation = "Sample text 3" + accountBalanceQuery + show ;
    accountBalanceQuery = "Sample text 4" + accountBalanceQuery + moreConcatenation;

    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(accountBalanceQuery);
      ResultSet rs2 = null;
      rs2 = statement.executeQuery(moreConcatenation);
      ResultSet rs3 = statement.executeQuery(moreMoreConcatenation);
      ResultSet rs4 = statement.executeQuery(xy);
      statement.executeQuery("select * from table1 where isPresent = ("
          + statement.execute("select isPresent from table2 WHERE pass = " + pass) + ")"); // vulnerable
      while (rs.next()) {
        System.out.println("Account number : " + rs.getInt("account_number") + "\n" + "Balance : " + rs.getFloat("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public static void methodNumber2(Connection connection, String urlParameter) {

    String accountBalanceQuery = "SELECT account_number, balance FROM accounts WHERE account_owner_id = " + urlParameter;

    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(accountBalanceQuery);
      while (rs.next()) {
        System.out.println("Account number : " + rs.getInt("account_number") + "\n" + "Balance : " + rs.getFloat("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public static void methodNumber3(Connection connection, String urlParameter) {

    String generator = "Sample text " + urlParameter;

    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(generator);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}