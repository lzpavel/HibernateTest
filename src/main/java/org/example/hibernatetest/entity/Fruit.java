package org.example.hibernatetest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fruit")
public class Fruit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "id_colour")
    private long idColor;


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdColor(long id_color) {
        this.idColor = id_color;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getIdColor() {
        return idColor;
    }
}
