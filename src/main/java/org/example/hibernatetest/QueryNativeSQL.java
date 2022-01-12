package org.example.hibernatetest;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class QueryNativeSQL {

    public static void execute(Session session) {

        //String sqlQuery = "SELECT fruit.name AS fruit_name, colour.name AS colour_name FROM fruit, colour WHERE fruit.id_colour = colour.id";
        String sqlQuery = "SELECT fruit.id AS fruit_id, fruit.name AS fruit_name, fruit.id_colour AS fruit_id_colour, " +
                "colour.id AS colour_id, colour.name AS colour_name " +
                "FROM fruit, colour WHERE fruit.id_colour = colour.id";

        NativeQuery nativeQuery = session.createSQLQuery(sqlQuery);
        List<Object[]> rows = nativeQuery.list();

        for (Object[] row : rows) {
            for (Object obj : row) {
                System.out.print(obj + " ");
            }
            System.out.print("\n");
        }
    }
}
