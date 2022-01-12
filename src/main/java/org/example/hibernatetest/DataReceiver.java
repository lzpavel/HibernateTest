package org.example.hibernatetest;

import org.example.hibernatetest.entity.Letter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class DataReceiver {

    private SessionFactory sessionFactory;

    public DataReceiver() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Letter> getDataList() {

        Session session = sessionFactory.openSession();
        //session.get(TableHibernate.class, 1L);

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery cq = (CriteriaQuery) cb.createQuery(TableHibernate.class);
//        Root<TableHibernate> root = cq.from(TableHibernate.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        List<TableHibernate> dataList = query.getResultList();

        Query query = session.createQuery("from Letter");
        List<Letter> dataList = query.getResultList();
        session.close();
        
        return dataList;
        

    }
}
