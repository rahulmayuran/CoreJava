package modal;

import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private int age;
    private int yearOfBirth;

    public static List<Student> listOfStudents() {
        return Arrays.asList(
                new Student("Keerthi", 21, LocalDate.now().getYear()),
                new Student("Hari", 24, LocalDate.now().getYear()),
                new Student("Pooja", 25, LocalDate.now().getYear()),
                new Student("Arvind", 30, LocalDate.now().getYear()),
                new Student("Hubert Blaine Wolfeschlegelsteinhausenbergerdorff, Sr", 55, LocalDate.now().getYear())
        );
    }
}
