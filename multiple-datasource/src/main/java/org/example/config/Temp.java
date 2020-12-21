package org.example.config;

public class Temp {
    private String name;
    private static String dept;

    Temp(){}
    Temp(String name){this.name = name;}

    public static void main(String[] args) {
        Temp t = new Temp("MyTemp");
        Temp.dept = "dev";
        System.out.println(t);
        Temp.dept = "prod";
        System.out.println(t);
    }

    @Override
    public String toString() {
        return "Temp{" +
                "name='" + name + '\'' +
                "dept=" + dept +
                '}';
    }
}
