package com.inventaire.model;


import javax.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_employee;
    private String nom_employee;

    public Employee(int id_employee, String nom_employee) {
        this.id_employee = id_employee;
        this.nom_employee = nom_employee;
    }



    public Employee() {
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }


    public String getNom_employee() {
        return nom_employee;
    }

    public void setNom_employee(String nom_employee) {
        this.nom_employee = nom_employee;
    }
}
