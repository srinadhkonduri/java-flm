package com.singleton_class_VVIMP;

public class SingletonNormal {

    // make a private static final variable and initialize it
    private static final SingletonNormal instance = new SingletonNormal();

    // private empty constructor
    private SingletonNormal () {}

    // public constructor to give access
    public static SingletonNormal getInstance(){
        return instance;
    }

    public void doSomething(){
        System.out.println("do something");
    }

}
