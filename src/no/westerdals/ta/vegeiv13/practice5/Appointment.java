package no.westerdals.ta.vegeiv13.practice5;

import java.util.Arrays;

public class Appointment implements Comparable<Appointment> {

    private String date;
    private String time;
    private String theme;

    public Appointment(String date, String time, String theme) {
        this.date = date;
        this.time = time;
        this.theme = theme;
    }

    public static void main(String[] args) {
        Appointment[] appointments = new Appointment[]{
                new Appointment("20150205", "1223", "Spise middag med familien"),
                new Appointment("20150205", "1123", "Forberede møte"),
                new Appointment("20150205", "1023", "Arrangere fest"),
                new Appointment("20150205", "1023", "Besøke venner")
        };

        System.out.println("Pre sort:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }

        Arrays.sort(appointments);

        System.out.println("\nPost sort:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        return date.equals(that.date)
                && theme.equals(that.theme)
                && time.equals(that.time);
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + theme.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return date + ", " + time + " " + theme;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public int compareTo(Appointment that) {
        int compare;
        if(that.equals(this) || that == this) {
            return 0;
        }
        compare = date.compareTo(that.date);
        if(compare != 0) {
            return compare;
        }
        compare = time.compareTo(that.time);
        if(compare != 0) {
            return compare;
        }
        return theme.compareTo(that.theme);
    }
}
