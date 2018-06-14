package com.company.testing;

import java.sql.Connection;

public class Main {

  public static void main(String args[]) {
    Connection connection = null;
    String url = "";
    String pass = "";
    MultipleFunctions.methodNumber1(connection, url, pass);
  }
}
