package com.company;

public class Main {
    public static void main(String[] args) {
        Airport flightBoardMilan, flightBoardTelAviv, flightBoardTokyo;
         Flight flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8, flight9, flight10, flight11, flight12, flight13, flight14, flight15;
         Flight flight16, flight17, flight18, flight19, flight20, flight21, flight22, flight23, flight24, flight25, flight26, flight27, flight28, flight29, flight30;
        flight1 = new Flight("Amsterdam", "Tel-aviv", 1, 5, 205, 300, 300);// Tel-aviv1
        flight2 = new Flight("Madrid", "Milan", 8, 20, 105, 128, 60); // Milan1
        flight3 = new Flight("Warsaw", "Lyon", 22, 45, 90, 105, 78);
        flight4 = new Flight("Milan", "Paris", 11, 55, 120, 244, 52);// Milan2
        flight5 = new Flight("Milan", "Tokyo", 7, 80, 700, 250, 999); // Milan3 // Tokyo1 // 7:00
        flight6 = new Flight("New-York", "Tel-aviv", 2, 25, 900, 250, 1300); // Tel-aviv2
        flight7 = new Flight("Toronto", "Manchester", 18, 30, 660, 208, 1190);
        flight8 = new Flight("Madrid", "Milan", 9, 30, 138, 120, 26);// Milan4
        flight9 = new Flight("Tel-aviv", "Bucharest", 15, 15, 145, 260, 105); // Tel-aviv3
        flight10 = new Flight("Tel-aviv", "Barcelona", 6, 35, 265, 174, 240); // Tel-aviv4
        flight11 = new Flight("Seoul", "London", 21, 0, 780, 235, 970);
        flight12 = new Flight("Milan", "London", 5, 45, 350, 250, 285);// Milan5
        flight13 = new Flight("Amsterdam", "Tel-aviv", 14, 30, 420, 142, 420); // Tel-aviv5
        flight14 = new Flight("Tokyo", "Paris", 23, 20, 815, 248, 1124); // Tokyo2
        flight15 = new Flight("Tokyo", "Berlin", 16, 50, 820, 250, 1099); // Tokyo3
        flight16 = new Flight("Prague", "Tel-aviv", 20, 35, 260, 202, 270); // Tel-aviv6
        flight17 = new Flight("Tokyo", "Seoul", 4, 25, 150, 171, 155); // Tokyo4
        flight18 = new Flight("Tokyo", "Madrid", 19, 20, 735, 250, 1122); // Tokyo5
        flight19 = new Flight("Monaco", "Oslo", 11, 40, 210, 95, 540);
        flight20 = new Flight("Stockholm", "Milan", 2, 55, 232, 250, 241); // Milan6
        flight21 = new Flight("Stockholm", "Helsinki", 3, 15, 90, 141, 99);
        flight22 = new Flight("Tel-aviv", "New Delhi", 16, 10, 640, 400, 420); // Tel-aviv7
        flight23 = new Flight("Bangkok", "Tel-aviv", 13, 30, 780, 300, 490); // Tel-aviv8
        flight24 = new Flight("Cape Town", "Milan", 5, 40, 385, 248, 354); // Milan7
        flight25 = new Flight("Los Angeles", "Washington", 15, 25, 170, 167, 109);
        flight26 = new Flight("Milan", "Tel-aviv", 15, 45, 268, 250, 250); // Milan8 // Tel-aviv9
        flight27 = new Flight("Tokyo", "Berlin", 18, 5, 820, 214, 1024); // Tokyo6
        flight28 = new Flight("Moscow", "Tokyo", 14, 0, 690, 198, 864); // Tokyo7
        flight29 = new Flight("Istanbul", "Milan", 6, 50, 162, 250, 140); // Milan9
        flight30 = new Flight("Porto", "Madrid", 8, 25, 105, 300, 186);


        // initializing Airport objects & and filling arrays
        // Milan Airport
        flightBoardMilan = new Airport("Milan");

        flightBoardMilan.addFlight(flight1);
        flightBoardMilan.addFlight(flight2);
        flightBoardMilan.addFlight(flight3);
        flightBoardMilan.addFlight(flight4);
        flightBoardMilan.addFlight(flight5);
        flightBoardMilan.addFlight(flight6);
        flightBoardMilan.addFlight(flight7);
        flightBoardMilan.addFlight(flight8);
        flightBoardMilan.addFlight(flight9);
        flightBoardMilan.addFlight(flight10);
        flightBoardMilan.addFlight(flight11);
        flightBoardMilan.addFlight(flight12);
        flightBoardMilan.addFlight(flight13);
        flightBoardMilan.addFlight(flight14);
        flightBoardMilan.addFlight(flight15);
        flightBoardMilan.addFlight(flight16);
        flightBoardMilan.addFlight(flight17);
        flightBoardMilan.addFlight(flight18);
        flightBoardMilan.addFlight(flight19);
        flightBoardMilan.addFlight(flight20);
        flightBoardMilan.addFlight(flight21);
        flightBoardMilan.addFlight(flight22);
        flightBoardMilan.addFlight(flight23);
        flightBoardMilan.addFlight(flight24);
        flightBoardMilan.addFlight(flight25);
        flightBoardMilan.addFlight(flight26);
        flightBoardMilan.addFlight(flight27);
        flightBoardMilan.addFlight(flight28);
        flightBoardMilan.addFlight(flight29);
        flightBoardMilan.addFlight(flight30);

        // Tel-aviv Airport
        flightBoardTelAviv = new Airport("Tel-aviv");

        flightBoardTelAviv.addFlight(flight1);
        flightBoardTelAviv.addFlight(flight2);
        flightBoardTelAviv.addFlight(flight3);
        flightBoardTelAviv.addFlight(flight4);
        flightBoardTelAviv.addFlight(flight5);
        flightBoardTelAviv.addFlight(flight6);
        flightBoardTelAviv.addFlight(flight7);
        flightBoardTelAviv.addFlight(flight8);
        flightBoardTelAviv.addFlight(flight9);
        flightBoardTelAviv.addFlight(flight10);
        flightBoardTelAviv.addFlight(flight11);
        flightBoardTelAviv.addFlight(flight12);
        flightBoardTelAviv.addFlight(flight13);
        flightBoardTelAviv.addFlight(flight14);
        flightBoardTelAviv.addFlight(flight15);
        flightBoardTelAviv.addFlight(flight16);
        flightBoardTelAviv.addFlight(flight17);
        flightBoardTelAviv.addFlight(flight18);
        flightBoardTelAviv.addFlight(flight19);
        flightBoardTelAviv.addFlight(flight20);
        flightBoardTelAviv.addFlight(flight21);
        flightBoardTelAviv.addFlight(flight22);
        flightBoardTelAviv.addFlight(flight23);
        flightBoardTelAviv.addFlight(flight24);
        flightBoardTelAviv.addFlight(flight25);
        flightBoardTelAviv.addFlight(flight26);
        flightBoardTelAviv.addFlight(flight27);
        flightBoardTelAviv.addFlight(flight28);
        flightBoardTelAviv.addFlight(flight29);
        flightBoardTelAviv.addFlight(flight30);

        // Tokyo Airport
        flightBoardTokyo = new Airport("Tokyo");

        flightBoardTokyo.addFlight(flight1);
        flightBoardTokyo.addFlight(flight2);
        flightBoardTokyo.addFlight(flight3);
        flightBoardTokyo.addFlight(flight4);
        flightBoardTokyo.addFlight(flight5);
        flightBoardTokyo.addFlight(flight6);
        flightBoardTokyo.addFlight(flight7);
        flightBoardTokyo.addFlight(flight8);
        flightBoardTokyo.addFlight(flight9);
        flightBoardTokyo.addFlight(flight10);
        flightBoardTokyo.addFlight(flight11);
        flightBoardTokyo.addFlight(flight12);
        flightBoardTokyo.addFlight(flight13);
        flightBoardTokyo.addFlight(flight14);
        flightBoardTokyo.addFlight(flight15);
        flightBoardTokyo.addFlight(flight16);
        flightBoardTokyo.addFlight(flight17);
        flightBoardTokyo.addFlight(flight18);
        flightBoardTokyo.addFlight(flight19);
        flightBoardTokyo.addFlight(flight20);
        flightBoardTokyo.addFlight(flight21);
        flightBoardTokyo.addFlight(flight22);
        flightBoardTokyo.addFlight(flight23);
        flightBoardTokyo.addFlight(flight24);
        flightBoardTokyo.addFlight(flight25);
        flightBoardTokyo.addFlight(flight26);
        flightBoardTokyo.addFlight(flight27);
        flightBoardTokyo.addFlight(flight28);
        flightBoardTokyo.addFlight(flight29);
        flightBoardTokyo.addFlight(flight30);
        System.out.println(flightBoardMilan.mostPopularDestination());
        System.out.println(flightBoardTokyo.mostPopularDestination());
        System.out.println(flightBoardTelAviv.mostPopularDestination());
    }
}
