package com.java;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    final static String[]  DAYS = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };
    public static final String[] MONTH = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String again;
        do {
            System.out.println("I'm so amazing wow");

            System.out.println("Enter the date: [MM-DD-YYYY] ");
            String dates = scan.nextLine();

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                Date d = sdf.parse(dates);
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                int month = c.get(Calendar.MONTH) + 1;
                int day = c.get(Calendar.DATE);
                int year = c.get(Calendar.YEAR);

                LocalDate l = LocalDate.of(year, month, day);
                //Day of the week
                DayOfWeek dow = DayOfWeek.from(l);

                //Output for inputted date
                System.out.println(MONTH[l.getMonth().ordinal()] + " " + day + ", " + l.getYear());

                //Output for how many days in a month
                System.out.println(MONTH[l.getMonth().ordinal()] + " " + l.getYear() + " has " + l.lengthOfMonth() + " days");

                //Output for day of the week
                System.out.println("Day of the week: " + DAYS[dow.ordinal()]);

                //Calculate the leap year using the Calendar
                if (l.isLeapYear()){
                    System.out.println(l.getYear()  + " is a leap year");
                }else {
                    System.out.println(l.getYear() + " is not a leap year");
                }

            }catch (Exception e){
                System.out.println("Exception detected: " + e);
            }finally {
                System.out.println("\nWant to try again? [YES/NO] ");
                again = scan.nextLine();
            }

        }while (again.equalsIgnoreCase("Yes"));
        System.out.println("Bye!");
    }
}
