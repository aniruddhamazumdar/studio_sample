package com.example.aniruddha.examples;

/**
 * Created by aniruddha on 27/11/14.
 */
public class QueryBuilder {

    private String tableName;
    private String[] projection;
    private String[] selectionArgs;

    public QueryBuilder() {

    }

    public void tableName(String tableName) {
        this.tableName = tableName;
    }

    public String where(String selection, String... selectionArgs) {
        String where = "";

        return where;
    }

    public void selection(String[] projection) {
        this.projection = projection;
    }

    public String getQuery() {
        String query = "SELECT ";

        //select
        if (projection != null) {
            for (int i = 0; i < projection.length; i++) {
                if (i > 0) {
                    query += ", " + projection[i];
                } else {
                    query += projection[i];
                }
            }
        } else {
            query = "*";
        }

        //from
        query += " FROM " + tableName;

        //where
        query += " WHERE ";


        //order and limit

        return query;
    }

    //Todo: Support for multi-table joins
}
