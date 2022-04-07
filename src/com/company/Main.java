package com.company;

public class Main {

    public static void main(String[] args) {
	Time2 t= new Time2(2,15);
    t.addMinutes(-4880);
    System.out.println(t.addMinutes(-48 * 60));

    }
}
