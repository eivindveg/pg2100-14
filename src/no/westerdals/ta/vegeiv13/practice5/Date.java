package no.westerdals.ta.vegeiv13.practice5;

import java.util.Arrays;

public class Date implements Comparable<Date> {
    private int dayNumber;
    private int monthNumber;
    private int year;

    public Date(int dayNumber, int monthNumber, int year) {
        this.dayNumber = dayNumber;
        this.monthNumber = monthNumber;
        this.year = year;
    }

    public static void main(String[] args) {
        Date d1 = new Date(31, 12, 1999);
        Date d2 = new Date(31, 12, 1999);

        System.out.println("Date 1 is equal to Date 2: " + d1.equals(d2));
        System.out.println("Transitioning Date 2 to next day");
        d2.nextDay();
        System.out.println("Date 1 is equal to Date 2: " + d1.equals(d2));

        Date[] dates = new Date[]{
                new Date(8, 12, 2499),      // Tassadar's fleet arrives at Chau Sara and burns it of all life.
                new Date(12, 5, 1984),      // Kyle Reese and a Series 800 Terminator arrive from the future
                new Date(1, 1, -1000000000),// Approximate date a Leviathan killed the Leviathan of Dis, a Reaper
                new Date(25, 7, 1989)       // The author of this class is born
        };

        System.out.println("Pre sort:");
        for (Date date : dates) {
            System.out.println(date);
        }

        Arrays.sort(dates);

        System.out.println("Post sort:");
        for (Date date : dates) {
            System.out.println(date);
        }

    }

    @Override
    public String toString() {
        return dayNumber + ". " + month() + " " + year;
    }

    public String toString(int dayNumber, int monthNumber, int year) {
        return dayNumber + ". " + monthNumber + " " + year;
    }

    private String month() {
        String retur;
        switch (monthNumber) {
            case (1):
                retur = "januar";
                break;
            case (2):
                retur = "februar";
                break;
            case (3):
                retur = "mars";
                break;
            case (4):
                retur = "april";
                break;
            case (5):
                retur = "mai";
                break;
            case (6):
                retur = "juni";
                break;
            case (7):
                retur = "juli";
                break;
            case (8):
                retur = "august";
                break;
            case (9):
                retur = "september";
                break;
            case (10):
                retur = "oktober";
                break;
            case (11):
                retur = "november";
                break;
            case (12):
                retur = "desember";
                break;
            default:
                retur = "ugyldig";
                break;
        }
        return retur;
    }

    @Override
    public boolean equals(Object other) {
        // If the other instance is this instance, we return true
        if (this == other) {
            return true;
        }
        // If the other is null or not the same class as this, return false
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        // We now know they're the same class, so we can cast other to a Date object.
        Date that = (Date) other;

        // If they're different days, return false
        if (this.dayNumber != that.dayNumber) {
            return false;
        }
        // If they're different months, return false
        if (this.monthNumber != that.monthNumber) {
            return false;
        }
        // If they're different years, return false
        return this.year == that.year;
    }

    @Override
    public int hashCode() {
        int result = dayNumber;
        result = 31 * result + monthNumber;
        result = 31 * result + year;
        return result;
    }

    public void nextDay() {
        dayNumber++;
        if (monthNumber == 1 || monthNumber == 3 || monthNumber == 5 ||
                monthNumber == 7 || monthNumber == 8 || monthNumber == 10 ||
                monthNumber == 12) {
            if (dayNumber == 32) {
                dayNumber = 1;
                monthNumber++;
                if (monthNumber == 13) {
                    monthNumber = 1;
                    year++;
                }
            }
        } else if (monthNumber == 2) {

            if (dayNumber == 29) {
                dayNumber = 1;
                monthNumber = 3;
            }
        } else if (monthNumber == 4 || monthNumber == 6 || monthNumber == 9 ||
                monthNumber == 11) {
            if (dayNumber == 31) {
                dayNumber = 1;
                monthNumber++;
            }
        }
    }

    @Override
    public int compareTo(Date that) {
        // If the other object is the same as this, we're the same size
        if(that.equals(this) || that == this) {
            return 0;
        }

        // If the other object's year is different, return that comparison
        if (year != that.year) {
            return year - that.year;
        }

        // If the other object's month is different, return that comparison
        if (monthNumber != that.monthNumber) {
            return monthNumber - that.monthNumber;
        }

        // Finally, we return the comparison between our days. If those are the same, we return 0!
        return dayNumber - that.dayNumber;
    }
}