package functional_interfaces;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.function.*;

@Slf4j
public class FunctionPlay {

    private static final DecimalFormat decimalFormatter = new DecimalFormat("0.00");

    public static void main(String[] args) {


        //IntUnaryOperator does the job
        log.info("Using IntUnaryOperator::applyAsInt() got:{}",
                incrementByTenWithUnaryOperator.applyAsInt(1));

        log.info("\n Using DoubleUnaryOperator::applyAsDouble() got:{}",
                doubleUnaryOperator.applyAsDouble(0.5d));

        log.info("\n Using UnaryOperator::apply() got:{}",
                stringUnaryOperator.apply("test-"));

        //11 * 10 * 110 - Executes after applying
        log.info("\n Using Function::andThen got:{}",
                multiplyBy10.andThen(squareIt).apply(11));

        //11 * 11 * 10 - Executes before applying
        log.info("\n Using Function::compose got:{}",
                multiplyBy10.compose(squareIt).apply(11));

        log.info("\n Using ToIntBiFunction::applyAsInt got:{}",
                integerBiFunction.applyAsInt(2, 3));

        log.info("\n Using ToIntBiFunction::applyAsInt got:{}",
                decimalFormatter.format(doubleBiFunction.applyAsDouble(2, 3.4d)));

        log.info("\n Using BiFunction::apply method, we got:{}", biFunction.apply(3, 2));
    }

    static IntUnaryOperator incrementByTenWithUnaryOperator = n -> n + 10;
    static DoubleUnaryOperator doubleUnaryOperator = n -> n + 0.3d;
    static UnaryOperator<String> stringUnaryOperator = n -> n + "Unary";
    static Function<Integer, Integer> multiplyBy10 = n -> n * 10;
    static Function<Integer, Integer> squareIt = n -> n * n;
    static ToIntBiFunction<Integer, Integer> integerBiFunction = (x, y) -> ((x * 10) * y * y);
    static ToDoubleBiFunction<Integer, Double> doubleBiFunction = (x, y) -> ((x * 10) * Math.pow(y, y));
    static BiFunction<Integer, Integer, Integer> biFunction = (x , y) -> (x + y) * (x ^ y);
}
