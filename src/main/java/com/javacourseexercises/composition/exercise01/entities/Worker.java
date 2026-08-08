package com.javacourseexercises.composition.exercise01.entities;

import java.util.ArrayList;
import java.util.List;

import com.javacourseexercises.composition.exercise01.entities.enums.WorkerLevel;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() { return name; }
    public WorkerLevel getLevel() { return level; }
    public Double getBaseSalary() { return baseSalary; }
    public Department getDepartment() { return department; }
    public List<HourContract> getContracts() { return contracts; }

    public void setName(String name) { this.name = name; }
    public void setLevel(WorkerLevel level) { this.level = level; }
    public void setBaseSalary(Double baseSalary) { this.baseSalary = baseSalary; }
    public void setDepartment(Department department) { this.department = department; }


    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(int year, int month) {
        double sum = baseSalary;
        for (HourContract contract : contracts) {
            
            int yearContract = contract.getDate().getYear();
            int monthContract = contract.getDate().getMonthValue();

            if (yearContract == year && monthContract == month) {
                sum += contract.totalValue();
            }
        }

        return sum;
    }
}
