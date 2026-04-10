package com.bridgelabz;

import com.bridgelabz.util.ConnectionPool;

public class TestDB {
    public static void main(String[] args) {
        System.out.println(ConnectionPool.getConnection());
    }
}