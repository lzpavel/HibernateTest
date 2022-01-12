package org.example.hibernatetest;

import org.example.hibernatetest.entity.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Start {

    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();

        //SQL Native query
        //QueryNativeSQL.execute(session);


        //Criteria query
        //QueryViaCriteria.execute2(session);

        //HQL query
        QueryViaHQL.execute(session);

        
        System.out.println("Data ready!");
        session.close();
    }
}
