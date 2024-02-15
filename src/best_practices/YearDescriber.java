package best_practices;
import java.util.Scanner;
import static java.lang.Math.floor;

/*
This class has a super bloated method that does too many things at once. Refactor the describeYear method and
separate out the responsibilities into other methods to improve readability and maintainability.
 */

/*
public class YearDescriber {

    static Scanner fromUser = new Scanner(System.in);

    private YearDescriber(){}; //static class

    public static void describeYear() {
        System.out.println("What year would you like to learn about?");
        int year;

        while(true) {
            try {
                year = fromUser.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please just input a year in the format YYYY!");
            }
        }

        String printMessage = year + " was ";

        if((year%4 == 0) || ((year%100 == 0) && !(year%400 == 0))) {
            printMessage += "a leap year,";
        } else {
            printMessage += "not a leap year,";
        }

        printMessage += " and started on a ";

        int startDay = (1 + (int)floor((2.6*11) -0.2) - (2*(year/100)) + ((year%100)-1) + (int)floor((double)((year%100)-1) / 4) + (int)floor((double)(year/100) / 4));
        /*
        int/int uses integer division e.g 11/5 = 2 (discard the remainder)
        double/int uses true division e.g. (double)(11)/5 = 2.2
        */

/*
        startDay = (startDay % 7 + 7) % 7;
        /*
        % is remainder function, NOT modulus division operator.
        Line 41 implements true modulus division.
        https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html for more info on the equation used.
        */

/*
        switch(startDay) {
            case 0:
                printMessage += "Sunday";
                break;
            case 1:
                printMessage += "Monday";
                break;
            case 2:
                printMessage += "Tuesday";
                break;
            case 3:
                printMessage += "Wednesday";
                break;
            case 4:
                printMessage += "Thursday";
                break;
            case 5:
                printMessage += "Friday";
                break;
            case 6:
                printMessage += "Saturday";
        } //psst...this can be much more concisely implemented using an array...

        printMessage += "!";

        System.out.println(printMessage);
    }
}

*/

public class YearDescriber {
    private static Scanner fromUser = new Scanner(System.in);
    private static String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private YearDescriber(){};
    public static void describeYear() {
        int year = getYearFromUser();
        String printMessage = year + " was " + (isLeapYear(year) ? "a leap year," : "not a leap year,") +
                " and started on a " + dayOfWeek(year) + "!";
        System.out.println(printMessage);
    }

    private static int getYearFromUser() {
        System.out.println("What year would you like to learn about?");
        while (true) {
            try {
                return fromUser.nextInt();
            } catch (Exception e) {
                System.out.println("Please just input a year in the format YYYY!");
                fromUser.next(); // clear the invalid input
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    private static String dayOfWeek(int year) {
        //1 represents the day of the month
        //(int)floor((2.6 * 11) - 0.2) -Fixed formula for month offset
        //(2 * (year / 100)) -Adjust calculation based on century
        //((year % 100) - 1) -Calculates the year within the century, minus 1 because the calculation starts from zero.
        //(int)floor((double)((year % 100) - 1) / 4) -Accounts leap years within century
        //(int)floor((double)(year / 100) / 4) -Leap year correction

        //OLD FORMULA
        //int startDay = (1 + (int)floor((2.6*11) -0.2) - (2*(year/100)) + ((year%100)-1) +
        //        (int)floor((double)((year%100)-1) / 4) + (int)floor((double)(year/100) / 4)) % 7;

        int dayOfMonth = 1; // January 1st
        int monthCode = calculateMonthCode(); // Code for January
        int century = year / 100;
        int yearOfCentury = (year % 100) - 1; // Adjusted year within century

        int leapYearCorrection = calculateLeapYearCorrection(yearOfCentury, century);
        int centuryAdjustment = calculateCenturyAdjustment(century);
        int monthAdjustment = calculateMonthAdjustment(monthCode);

        int startDay = (dayOfMonth + monthAdjustment - centuryAdjustment + yearOfCentury + leapYearCorrection) % 7;
        startDay = (startDay + 7) % 7;// Adjust to ensure it's within 0-6
        return daysOfWeek[startDay];
    }
    private static int calculateMonthCode() {
        return (int) Math.floor(2.6 * 11 - 0.2); // Month code for January
    }

    private static int calculateLeapYearCorrection(int yearOfCentury, int century) {
        return (int) Math.floor(yearOfCentury / 4.0) + (int) Math.floor(century / 4.0);
    }

    private static int calculateCenturyAdjustment(int century) {
        return 2 * century;
    }

    private static int calculateMonthAdjustment(int monthCode) {
        return monthCode;
    }
}
