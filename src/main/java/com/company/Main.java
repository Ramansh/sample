package com.company;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //arraylist to store info of 5 employees.
        ArrayList<Info> allData = new ArrayList<Info>();

        //addition by 1 to allData
        Address curr = new Address("162","Unka Jahan","London","UK");
        Info data = new Info(1,"Jason","MD",9999999,curr);
        allData.add(data);

        curr = new Address("144","Unka Jahan","London","UK");
        data = new Info(2,"Salman Kagzi","Engineering",9999999,curr);
        allData.add(data);

        curr = new Address("8","Apna Jahan","Gurugram","");
        data = new Info(3,"Chunky Garg","Engineering",9999999,curr);
        allData.add(data);

        curr = new Address("70","Apna Jahan","Banglore","Karnataka");
        data = new Info(4,"Uma Swarna","Human Resource",9999999,curr);
        allData.add(data);

        curr = new Address("01","Unka Jahan","London","UK");
        data = new Info(5,"David Gorton","Operations",9999999,curr);
        allData.add(data);


        String json = new Gson().toJson(allData);
        System.out.println(json+"\nwrite to json");

        writeJsonToFile(json);
        problem2();
    }

    public static void problem2() {
        Object jsonData = readJsonFromFile("jsonFile");
        //System.out.println(jsonData);

        Gson gsonObject = new Gson();
        List<Map> temp = gsonObject.fromJson((String) jsonData, List.class);
        System.out.println(temp+"\nread from json");

        for(Map str:temp) {
            System.out.println("id: "+str.get("id"));
            System.out.println("name: "+str.get("name"));
            System.out.println("department: "+str.get("department"));
            System.out.println("salary: "+str.get("salary"));
            System.out.println("address: "+str.get("current"));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }


    public static void writeJsonToFile(String json) {
        File file = new File("/Users/shuklara/Desktop/jsonFile.");


        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(json);
            s.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Object readJsonFromFile(String fileName) {
        Object data=null;
        try{
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream s = new ObjectInputStream(f);
            data=s.readObject();
            s.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return data;
    }
}


