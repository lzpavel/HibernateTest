package org.example.hibernatetest;

import org.example.hibernatetest.entity.*;

import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.io.Serializable;
import java.util.List;

public class QueryViaCriteria {

    public static void execute(Session session) {

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Fruit> cq = cb.createQuery(Fruit.class);
        Root<Fruit> root = cq.from(Fruit.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Fruit> results = query.getResultList();
        for (Fruit f : results) {
            System.out.println(f.getId() + " " + f.getName() + " " + f.getIdColor());
        }
    }

    public static void execute2(Session session) {

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Fruit> cqFruit = cb.createQuery(Fruit.class);
        CriteriaQuery<Colour> cqColour = cb.createQuery(Colour.class);


        cqFruit.select(cqFruit.from(Fruit.class));
        cqColour.select(cqColour.from(Colour.class));

        Query query = session.createQuery(cqFruit);
        List<Fruit> fruits = query.getResultList();

        query = session.createQuery(cqColour);
        List<Colour> colours = query.getResultList();


        for (Fruit f : fruits) {
            System.out.println(f.getId() + " " + f.getName() + " " + f.getIdColor());
        }
        for (Colour c : colours) {
            System.out.println(c.getId() + " " + c.getName());
        }
        for (Fruit f : fruits) {
            for (Colour c : colours) {
                if (f.getIdColor() == c.getId()) {
                    System.out.println(f.getName() + " " + c.getName());
                }
            }
        }

    }

    public class FruitAndColour implements Serializable {
        public String nameFruit;
        public String nameColour;
    }
}
