package first;

import lombok.Builder;
import lombok.Data;

/**
 * @author ZD
 * @date 2020-09-15 8:29
 */
@Builder
@Data
public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 出生年月
     */
    private String birthDate;
    /**
     * java实验成绩
     */
    private Float grade;
}
