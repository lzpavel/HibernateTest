package org.example.hibernatetest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "letter")
public class Letter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String letter;

    public long getId() {
        return id;
    }

    public String getData() {
        return letter;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.letter = data;
    }
}
