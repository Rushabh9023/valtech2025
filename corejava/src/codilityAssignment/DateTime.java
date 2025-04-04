package codilityAssignment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
	static class CustomDate {
        int year;
        int month;
        int day;
        int hour;
        int minute;
        int second;

        public CustomDate(int year, int month, int day, int hour, int minute, int second) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public static CustomDate parse(String dateTime) {
            String[] dateTimeParts = dateTime.split(" ");
            String[] dateParts = dateTimeParts[0].split("-");
            String[] timeParts = dateTimeParts[1].split(":");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            int second = Integer.parseInt(timeParts[2]);
            return new CustomDate(year, month, day, hour, minute, second);
        }
        public long toSeconds() {
            int daysInYear = 365; 
            int daysInMonth = 30;  
            long totalDays = (this.year * daysInYear) + (this.month * daysInMonth) + this.day;
            long totalSeconds = (totalDays * 86400) + (this.hour * 3600) + (this.minute * 60) + this.second;
            return totalSeconds;
        }
    }
    public static void calculateDifference(String dateTime1, String dateTime2) {
        CustomDate dt1 = CustomDate.parse(dateTime1);
        CustomDate dt2 = CustomDate.parse(dateTime2);
        long seconds1 = dt1.toSeconds();
        long seconds2 = dt2.toSeconds();
        long diffInSeconds = Math.abs(seconds2 - seconds1);
        long days = diffInSeconds / 86400;
        diffInSeconds %= 86400;
        long hours = diffInSeconds / 3600;
        diffInSeconds %= 3600;
        long minutes = diffInSeconds / 60;
        long seconds = diffInSeconds % 60;
        System.out.println("Difference between " + dateTime1 + " and " + dateTime2 + " is:");
        System.out.println(days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
    }
    public static void main(String[] args) {
        String dateTime1 = "2025-03-25 14:30:00";
        String dateTime2 = "2025-03-27 16:45:30";
        calculateDifference(dateTime1, dateTime2);
    }
}
