//package com.google;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

//For Zaw Htut
public class MovieStation {
    public static void main(String[] args) {

        // Creating ArrayList for Customer Name
        ArrayList<String> name1 = new ArrayList<>();
        // Creating ArrayList for Phone Number
        ArrayList<Integer> phone1 = new ArrayList<>();
        // Creating ArrayList for Movie Name
        ArrayList<String> movie1 = new ArrayList<>();
        // Creating ArrayList for Movie Time
        ArrayList<String> movie_time1 = new ArrayList<>();
        // Creating ArrayList for Seat Class
        ArrayList<String> seat_class1 = new ArrayList<>();
        // Creating ArrayList for Amount of Ticket
        ArrayList<Integer> ticket_amount1 = new ArrayList<>();
        // Creating ArrayList for Total Revenue
        ArrayList<Integer> total_revenue1 = new ArrayList<>();

        // Taking User Input
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        Date date = new Date();

        System.out.println("\nEnter the number of people to buy movie ticket.");
        int count = insertNum();
        int h = 0;
        while (h < count) {
            // Creating Fixed Array to store Movie List.
            System.out.println("\nWelcome to our New Movie Theater.\nThese are the available movies for today's date "
                    + date.toString() + "\n");
            String movie_list[] = { "The Godfather", "Raging Bull", "Gone with the Wind", "Titanic" };

            // Iterating the listed movie
            for (int i = 0; i < movie_list.length; i++) {
                System.out.println(i + "." + movie_list[i]);
            }
            System.out.println("\nEnter the corresponding integer number attach to each movie name.");
            int movie_ID = getOption1();

            boolean found1 = false;
            for (int i = 0; i < movie_list.length; i++) {
                if (movie_ID == i) {
                    System.out.println("You chose the movie " + "'" + movie_list[i] + "'" + ".");
                    // Adding data to movie1 arraylist
                    movie1.add(movie_list[i]);
                    found1 = true;
                    break;
                }
            }

            // Creating Fixed Array to store movie showing time.
            String movie_time[] = { "(9am to 12pm)", "(12pm to 2pm)", "(2pm to 5pm)" };
            System.out.println("\nThese are the available time to watch the movie you chose.");
            for (int i = 0; i < movie_time.length; i++) {
                System.out.println(i + "." + movie_time[i]);
            }
            System.out.println("\nEnter the corresponding integer number attach to each movie time.");
            int time_ID = getOption2();

            boolean found2 = false;
            for (int i = 0; i < movie_time.length; i++) {
                if (time_ID == i) {
                    System.out.println("You choose this duration " + "'" + movie_time[i] + "'" + ".");
                    // Adding data to movie_time1 arraylist
                    movie_time1.add(movie_time[i]);
                    found2 = true;
                    break;
                }
            }

            // Creating Fixed Array to store seat class.
            String seat_class[] = { "Front Seat- 10$", "Middle Seat-20$", "Back Seat-30$", "Couple Seat-40$" };
            System.out.println("\nThese are the available seat option to watch the movie you chose.");
            for (int i = 0; i < seat_class.length; i++) {
                System.out.println(i + "." + seat_class[i]);
            }
            System.out.println("\nEnter the corresponding integer number attach to each seat option.");
            int seat_type = getOption1();

            boolean found3 = false;
            for (int i = 0; i < seat_class.length; i++) {
                if (seat_type == i) {
                    System.out.println("You choose this " + "'" + seat_class[i] + "'" + ".");
                    // Adding data to seat_class1 arrayList
                    seat_class1.add(seat_class[i]);
                    found3 = true;
                    break;
                }
            }
            System.out.println("Enter your Name.");
            String name = s2.nextLine();
            // Adding data to name1 arraylist
            name1.add(name);
            System.out.println("Enter your Phone Number.");
            Integer ph_no = insertNum();
            // Adding data to phone1 arraylist
            phone1.add(ph_no);
            System.out.println("Enter the number of ticket you want to buy.");
            int ticket_no = insertNum();
            // Adding ticketamount to ticket_amount1 ArrayList
            ticket_amount1.add(ticket_no);

            // Calculating total revenue of ticket amount
            if (seat_type == 0) {
                int total = 10 * ticket_no;
                System.out.println("You will cost this amount " + total + ".");
                // Adding total to total_revenue1 arrayList
                total_revenue1.add(total);
            } else if (seat_type == 1) {
                int total = 20 * ticket_no;
                System.out.println("You will cost this amount " + total + ".");
                // Adding total to total_revenue1 arrayList
                total_revenue1.add(total);
            } else if (seat_type == 2) {
                int total = 30 * ticket_no;
                System.out.println("You will cost this amount " + total + ".");
                // Adding total to total_revenue1 arrayList
                total_revenue1.add(total);
            } else if (seat_type == 3) {
                int total = 40 * ticket_no;
                System.out.println("You will cost this amount " + total + ".");
                // Adding total to total_revenue1 arrayList
                total_revenue1.add(total);
            }
            h++;
        }

        bubbleSort(name1, phone1, movie1, movie_time1, seat_class1, ticket_amount1, total_revenue1);
        // amount of ticket, total price, seat type, time option, movie name.
        // Condition checking to match movie ID with movie List when a customer input
        // data.
        // Iterating data from ArrayList
        System.out.println("ID" + "\t\t" + "Name" + "\t\t\t" + "phone" + "\t\t\t\t" + "Movie" + "\t\t\t\t" + "Time"
                + "\t\t\t" + "Seat Type" + "\t\t\t" + "Count" + "\t\t" + "total price");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------");
        for (int p = 0; p < name1.size(); p++) {
            System.out.println("00" + (p + 1) + "\t\t" + name1.get(p) + "\t\t" + phone1.get(p) + "\t\t" + movie1.get(p)
                    + "\t\t" + movie_time1.get(p) + "\t\t" + seat_class1.get(p) + "\t\t" + ticket_amount1.get(p)
                    + "\t\t\t" + total_revenue1.get(p));
        }

        // calling linearsearch
        linearSearch(name1, phone1, movie1, movie_time1, seat_class1, ticket_amount1, total_revenue1);
    }

    // linear search

    static String linearSearch(ArrayList<String> name1, ArrayList<Integer> phone1, ArrayList<String> movie1,
                               ArrayList<String> movie_time1, ArrayList<String> seat_class1, ArrayList<Integer> ticket_amount1,
                               ArrayList<Integer> total_revenue1) {
        Scanner searchNameScanner = new Scanner(System.in);
        System.out.println("Enter name you want to search .....");
        String searchName = searchNameScanner.nextLine();
        for (int i = 0; i < name1.size(); i++) {
            if (name1.get(i).equalsIgnoreCase(searchName)) {
                System.out.println("ID" + "\t\t" + "Name" + "\t\t\t" + "phone" + "\t\t\t\t" + "Movie" + "\t\t\t\t"
                        + "Time" + "\t\t\t" + "Seat Type" + "\t\t\t" + "Count" + "\t\t" + "total price");
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("00" + (i + 1) + "\t\t" + name1.get(i) + "\t\t" + phone1.get(i) + "\t\t"
                        + movie1.get(i) + "\t\t" + movie_time1.get(i) + "\t\t" + seat_class1.get(i) + "\t\t"
                        + ticket_amount1.get(i) + "\t\t\t" + total_revenue1.get(i));

                return name1.get(i);
            } else {
                System.out.println("You searched Name " + "'" + searchName + "'" + " do not have in the table...");
            }
        }
        return null;
    }

    static int insertNum() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        try {
            num = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("Invalid type of input. Please enter the number of people again");
            return insertNum();
        }
        if (num <= 0) {
            System.out.println("The minimum number of people should be at least 1. Please enter again");
            return insertNum();
        } else {
            return num;
        }
    }

    static int getOption1() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid type of input. Please select the option again");
            return getOption1();
        }
        if (option < 0 || option > 3) {
            System.out.println("The option you have selected is not included. Please enter again");
            return getOption1();
        } else {
            return option;
        }
    }


    static int getOption2() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid type of input. Please select the option again");
            return getOption1();
        }
        if (option < 0 || option > 2) {
            System.out.println("The option you have selected is not included. Please enter again");
            return getOption1();
        } else {
            return option;
        }

    }

    static void bubbleSort(ArrayList<String> name, ArrayList<Integer> phone, ArrayList<String> movie,
                           ArrayList<String> movieTime, ArrayList<String> seatClass, ArrayList<Integer> ticket,
                           ArrayList<Integer> total) {
        int n = name.size();
        String temp = name.get(0);
        int temp2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (name.get(j - 1).compareTo(name.get(j)) > 0) {

                    temp = name.get(j - 1);
                    name.set(j - 1, name.get(j));
                    name.set(j, temp);

                    temp2 = phone.get(j - 1);
                    phone.set(j - 1, phone.get(j));
                    phone.set(j, temp2);

                    temp = movie.get(j - 1);
                    movie.set(j - 1, movie.get(j));
                    movie.set(j, temp);

                    temp = movieTime.get(j - 1);
                    movieTime.set(j - 1, movieTime.get(j));
                    movieTime.set(j, temp);

                    temp = seatClass.get(j - 1);
                    seatClass.set(j - 1, seatClass.get(j));
                    seatClass.set(j, temp);

                    temp2 = total.get(j - 1);
                    total.set(j - 1, total.get(j));
                    total.set(j, temp2);

                    temp2 = ticket.get(j - 1);
                    ticket.set(j - 1, ticket.get(j));
                    ticket.set(j, temp2);
                }
            }
        }
    }
}
