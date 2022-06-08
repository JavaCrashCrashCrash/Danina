package com.doma.danina.builder;

public class Test {
    public static void main(String[] args) {

        String id = "asdf";
        String pwd = "1234";
        String name = "Kim";
        Person p = new Person.Builder().pwd(pwd).name(name).build();

        p.introduceMyself();
    }
}
