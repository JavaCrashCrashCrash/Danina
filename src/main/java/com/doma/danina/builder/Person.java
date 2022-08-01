package com.doma.danina.builder;

public class Person {
    private String id;
    private String pwd;
    private String name;

    public Person(Builder builder) {
        this.id = builder.id;
        this.pwd = builder.pwd;
        this.name = builder.name;
    }

    public void introduceMyself() {
        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);
        System.out.println("name : " + name);
    }
    public static class Builder {
        private String id;
        private String pwd;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder pwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }


}
