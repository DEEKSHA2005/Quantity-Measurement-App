package com.bridgelabz;

public class TestDB {
    public static void main(String[] args) {
        System.out.println(ConnectionPool.getConnection());
    }
}