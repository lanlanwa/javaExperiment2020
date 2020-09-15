package second.mypackage;

import java.util.Calendar;

/**
 * @author ZD
 * @date 2020-09-15 13:20
 */
public class YMD {
    private int year, month, day;

    public YMD(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static void main(String[] args) {

    }

    public YMD() {
        this(0, 0, 0);
    }

    public static int thisYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
