package com.inventaire.model;

import javax.persistence.*;

@Entity
@Table
public class Sequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sequence ;

    public Sequence() {
    }

    public int getId_sequence() {
        return id_sequence;
    }

    public void setId_sequence(int id_sequence) {
        this.id_sequence = id_sequence;
    }
}
