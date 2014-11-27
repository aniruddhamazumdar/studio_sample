package com.example.aniruddha.examples;

import java.io.Serializable;

/**
 * Created by aniruddha on 26/11/14.
 */
public class Samples {

    public static final String TABLE_NAME = "sample";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_CREATED = "created";
    public static final String COL_MODIFIED = "modified";

    public static class Sample implements Serializable {
        public int id;
        public String name;
        public long created;
        public long modified;
    }

    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS sample(_id INTEGER PRIMARY KEY, name VARCHAR, created INTEGER, modified INTEGER)";

    public static final String SQL_DELETE = "DROP TABLE IF EXISTS sample";
}
