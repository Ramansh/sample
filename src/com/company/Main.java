package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //arraylist to store info of 5 employees
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

        
    }
}
