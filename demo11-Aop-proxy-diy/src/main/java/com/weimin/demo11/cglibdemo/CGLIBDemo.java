package com.weimin.demo11.cglibdemo;

public class CGLIBDemo {
    static class Target {
        public void save() {
            System.out.println("save()");
        }

        public void save(int i) {
            System.out.println("save(int)");
        }

        public void save(long l) {
            System.out.println("save(long)");
        }
    }
}