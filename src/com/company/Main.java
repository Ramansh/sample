package com.company;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //arraylist to store info of 5 employees.
        ArrayList<Info> allData = new ArrayList<Info>();

        //addition by 1 to allData
        Address curr = new Address("162","Unka Jahan","London","UK");
        Info data = new Info(1,"Jason","MD",9999,curr);
        allData.add(data);

        curr = new Address("144","Unka Jahan","London","UK");
        data = new Info(2,"Salman Kagzi","Engineering",9999,curr);
        allData.add(data);

        curr = new Address("8","Apna Jahan","Gurugram","");
        data = new Info(3,"Chunky Garg","Engineering",9999,curr);
        allData.add(data);

        curr = new Address("70","Apna Jahan","Banglore","Karnataka");
        data = new Info(4,"Uma Swarna","Human Resource",9999,curr);
        allData.add(data);

        curr = new Address("01","Unka Jahan","London","UK");
        data = new Info(5,"David Gorton","Operations",9999,curr);
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
        List<Info> temp = gsonObject.fromJson((String) jsonData, List.class);
        System.out.println(temp+"\nread from json");
    }


    public static void writeJsonToFile(String json) {
        File file = new File("jsonFile");

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


