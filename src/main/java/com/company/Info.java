package com.company;

public class Info {
    int id;
    String name;
    String department;
    int salary;
    Address current;

    public Info(int id, String name, String department, int salary, Address current) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.department = department;
        this.current = current;
    }
}
