package com.singleton_class_VVIMP;

public class Main {
    public static void main(String[] args) {
        SingletonNormal normal = SingletonNormal.getInstance();
        SingletonNormal normal1 = SingletonNormal.getInstance();


        normal.doSomething();


        System.out.println(normal == normal1);

    }
}
