package first;

import second.MyDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-09-15 8:29
 */
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            System.out.println("请您输入第" + i + "个学生的姓名、年龄、出生年月日(例:2020-10-10)、java课程成绩（每项请以空格分隔开）");
            // 读入学生数据
            String data = sc.nextLine();
            String[] message = data.split(" ");
            try {
                students.add(Student.builder()
                        .name(message[0])
                        .age(Integer.valueOf(message[1]))
                        .myDate(new MyDate(message[2]))
                        .grade(Float.valueOf(message[3]))
                        .build());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                i--;
            }
        }
        // 求年龄、java成绩平均值
        Integer sumAge = 0;
        Float sumGrade = (float) 0;
        for (Student i : students) {
            sumAge += i.getAge();
            sumGrade += i.getGrade();
        }
        System.out.println("学生年龄平均值为" + sumAge/students.size());
        System.out.println("学生java成绩平均值为" + sumGrade/students.size());
    }

}
