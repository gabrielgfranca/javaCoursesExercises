package com.javacourseexercises.lists.exercise01.entities;

public class Employee {
    private String id;
    private String name;
    private Double salary;

    public Employee() {
	
    }

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {        
        this.salary += this.salary * percentage / 100;
    }

    @Override
    public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}
}
