package first;

import second.MyDate;
import third.AllAverage;
import third.Average;
import third.PartAverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-09-15 8:29
 */
public class One {
    public static void main(String[] args) {
        int amount = 2;
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            System.out.println("请您输入第" + (i + 1) + "个学生的姓名、年龄、出生年月日(例:2020-10-10)、java课程成绩（每项请以空格分隔开）");
            // 读入学生数据
            String data = sc.nextLine();
            String[] message = data.split(" ");
            try {
                if (message.length != 4) {
                    throw new Exception("数据个数或格式错误");
                }
                students.add(Student.builder()
                        .name(message[0])
                        .age(Integer.valueOf(message[1]))
                        .myDate(new MyDate(message[2]))
                        .grade(Float.valueOf(message[3]))
                        .build());
            } catch (NumberFormatException e) {
                System.out.println("成绩类型错误");
                i--;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
        // 求年龄、java成绩平均值
        AllAverage allAverage = new AllAverage();
        PartAverage partAverage = new PartAverage();

        float[] ages = new float[students.size()];
        float[] grades = new float[students.size()];
        for (int i = 0; i < students.size(); i++) {
            ages[i] = students.get(i).getAge();
            grades[i] = students.get(i).getGrade();
        }

        System.out.println("学生年龄平均值为" + allAverage.getAverage(ages));
        System.out.println("学生java成绩平均值为" + partAverage.getAverage(grades));
    }

}
