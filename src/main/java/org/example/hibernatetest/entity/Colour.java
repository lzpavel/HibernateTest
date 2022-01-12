package org.example.hibernatetest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colour")
public class Colour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
