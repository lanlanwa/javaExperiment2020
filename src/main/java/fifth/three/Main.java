package fifth.three;

/**
 * @author ZD
 * @date 2020-09-30 14:19
 */
public class Main {
    public static void main(String[] args) {
        BookingPeople zhao = new BookingPeople("zhao", 0, 0, 1);
        BookingPeople qian = new BookingPeople("qian", 0, 0, 1);
        BookingPeople sun = new BookingPeople("sun", 0, 1, 0);
        BookingPeople li = new BookingPeople("li", 0, 1, 0);
        BookingPeople zhou = new BookingPeople("zhou", 1, 0, 0);

        Conductor conductor = new Conductor("conductor",1,0,0);
        Thread conductorThread = new Thread(conductor);
    }
}
