public class Date {
    public int day;
    public int month;
    public int year;

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    Date() {
    }

    public static Date parseDate(String date) {
        Date d = new Date();
        String[] parts = date.split("/");
        d.day = Integer.parseInt(parts[0]);
        d.month = Integer.parseInt(parts[1]);
        d.year = Integer.parseInt(parts[2]);
        return d;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int value) {
        this.day = value;
    }

    public void setMonth(int value) {
        this.month = value;
    }

    public void setYear(int value) {
        this.year = value;
    }
}
