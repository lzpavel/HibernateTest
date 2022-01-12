package org.example.hibernatetest;

import org.example.hibernatetest.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryViaHQL {

    public static void execute(Session session) {
        Query queryFruit = session.createQuery("from Fruit");
        Query queryColour = session.createQuery("from Colour ");

        List<Fruit> fruits = queryFruit.list();
        List<Colour> colours = queryColour.list();
        for (Fruit f : fruits) {
            for (Colour c : colours) {
                if (f.getIdColor() == c.getId()) {
                    System.out.println(f.getName() + " " + c.getName());
                }
            }
        }
        //System.out.println("HQL Ok!");
    }

    public static void execute2(Session session) {

        Query query = session.createQuery("from Fruit where name = :paramName");
        query.setParameter("paramName", "banana");
        Fruit fruit = (Fruit) query.list().get(0);
        System.out.println(fruit.getId() + " " + fruit.getName() + " " + fruit.getIdColor());

    }

}
