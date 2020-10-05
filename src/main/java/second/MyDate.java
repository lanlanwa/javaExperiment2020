package second;

import enums.RegexEnum;
import lombok.Data;

/**
 * @author ZD
 * @date 2020-09-15 10:00
 */
@Data
public class MyDate {
    private String birthDate;
    private String year;
    private String month;
    private String day;

    public MyDate(String birthDate) throws Exception {
        this.birthDate = birthDate;
        // 匹配年月日
        if (!birthDate.matches(RegexEnum.DATETIME.value)){
            throw new Exception("年月日格式错误");
        }
        String[] cells = birthDate.split("-");
        this.year = cells[0];
        this.month = cells[1];
        this.day = cells[2];
    }
}
