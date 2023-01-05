package org.example.Builder;

public class Test {

    public static void main(String[] args) {
        DirectorHouse directorHouse = new DirectorHouse();
        House popularModernHouse = directorHouse.createPopularModernHouse(new House.Builder());
        System.out.println(popularModernHouse);
    }
}
