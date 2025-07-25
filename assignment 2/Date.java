public class Date {
    private int day;
    private int month;
    private int year;

    // Constructor (i): default to 01.01.1970
    public Date() {
        this(1, 1, 1970);
    }

    // Constructor (ii): day specified, month & year default to 01.1970
    public Date(int day) {
        this(day, 1, 1970);
    }

    // Constructor (iii): day & month specified, year default to 1970
    public Date(int day, int month) {
        this(day, month, 1970);
    }

    // Constructor (iv): day, month & year all specified
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Check if current year is a leap year
    private boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Get number of days in current month
    private int daysInMonth() {
        switch (month) {
            case 2:
                return isLeapYear() ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    // Member function (i): get previous day
    public Date previousDay() {
        int d = day - 1;
        int m = month;
        int y = year;

        if (d < 1) {
            m--;
            if (m < 1) {
                m = 12;
                y--;
            }
            // set to last day of previous month
            day = daysInMonth(); 
            month = m;
            year = y;
            d = daysInMonth();
        }

        return new Date(d, m, y);
    }

    // Member function (iv): get next day
    public Date nextDay() {
        int d = day + 1;
        int m = month;
        int y = year;

        if (d > daysInMonth()) {
            d = 1;
            m++;
            if (m > 12) {
                m = 1;
                y++;
            }
        }

        return new Date(d, m, y);
    }

    // Member function (iii): print date in DD.MM.YYYY format
    public void printDate() {
        System.out.printf("%02d.%02d.%04d%n", day, month, year);
    }
}
