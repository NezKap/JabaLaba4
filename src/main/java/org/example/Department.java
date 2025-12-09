package org.example;

public class Department {
    private int id;
    private String name;
    public Department(String _name) {
        name = _name;
        id = _name.charAt(0) - 'A';
    }
    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String _name) {
        name = _name;
    }
}
