package stream;

import error.CustomException;
import lombok.extern.slf4j.Slf4j;
import modal.PriceRange;
import modal.Product;
import modal.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

@Slf4j
public class PlayingWithReduce {

    /**
     * Reduce method for playing with parallel processing
     *
     * @param args
     * @throws CustomException
     */
    public static void main(String[] args) throws CustomException {

        PlayingWithReduce s = new PlayingWithReduce();

        s.streamsWithProduct(Product.listOfProducts());
        s.streamsWithStudents(Student.listOfStudents());
    }

    public void streamsWithProduct(List<Product> productList){

        log.info("ProductList contains => {}", productList);

        productList.sort(Comparator.comparing(Product::getName));
        Optional<Product> filteredProducts =
                    productList
                        .stream()
                        .filter(p->p.getPrice() > 45000)
                        .findAny();

        filteredProducts.ifPresent(s -> log.info("Product with price more than 45000 is : {}", s.getName()));

        //Need the average price of the product
        //whose PriceRange is MODERATE.
        OptionalDouble averageModeratePrice = productList.stream()
                .filter(p -> p.getRange().equals(PriceRange.MODERATE))
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .average();

        averageModeratePrice.ifPresent(p -> log.info("The average price of the MODERATE products is: {}", p));

    }

    public void streamsWithStudents(List<Student> studentList) throws CustomException {

        if(studentList.isEmpty()){
            throw new CustomException("Student list is empty");
        }

        log.info("studentList contains => {}", studentList);
        studentList.sort(Comparator.comparing(Student::getName));

        //Calculating the largest age by using reduce operation which is a
        //combo of Identity and Accumulator.
        Optional<Student> optionalStudent =
                studentList
                        .stream()
                        .reduce((p1,p2) -> p1.getAge() > p2.getAge() ? p1 : p2);

        optionalStudent.ifPresent(s -> log.info("Eldest student is {}", s.getName()));

        //Calculating sum using classic for loop
        int sumUsingClassicForLoop = 0;
        for (Student student : studentList) {
            sumUsingClassicForLoop += student.getAge();
        }
        log.info("sumOfAges Using ClassicForLoop = {} ", sumUsingClassicForLoop);

        //Calculating sum using mapToInt intermediate operation and
        //sum terminal operation
        int sumUsingMapToInt = studentList
                .stream()
                .mapToInt(Student::getAge)
                .sum();
        log.info("sumOfAges using MapToInt = {}", sumUsingMapToInt);

        //Calculating sum using reduce with Identity, accumulator, combiner
        int sumUsingReduce = studentList
                .stream()
                .reduce(0,
                        (age, student) -> age + student.getAge(),
                        Integer::compare);
        log.info("sumOfAges using reduce = {}", sumUsingReduce);

        //Calculating Shortest name using only Accumulator in reduce
        Optional<String> longName = studentList
                .stream()
                .map(Student::getName)
                .reduce((s1, s2) -> s1.length() < s2.length() ? s1 : s2);

        longName.ifPresent(s -> log.info("Shortest Name is {} with length: {}", s, s.length()));
    }

}
