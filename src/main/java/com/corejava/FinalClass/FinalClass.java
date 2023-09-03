package com.corejava.FinalClass;


import lombok.extern.slf4j.Slf4j;

/*
 * When they are having the label 'final', They can't be overridden,
 * used with this pointers
 * They can be a field initializer, initialization block or constructor.
 */
@Slf4j
public class FinalClass {

    private static final int NOT_YET = 9;
    private final int ifscCode = 100003;
    private int accountNo = 6701245;


    public FinalClass() {
        log.info("I will be second From Constructor ->" + accountNo);
        log.info("I will be third From Constructor accessing final variable ->" + ifscCode);
        //will be printed second , As JVM prints statements from main method
    }

    public FinalClass(int accountNo) {
        this.accountNo = accountNo;
        /*
         * what this means? this.accountNo will enable you to change the
         * values of the field to whatever you pass as an accountNo parameter
         * while instantiating to call this constructor from main method
         * So it prints 777.
         */
        this.accountNo = 888;
        /*
         * The same case, this.accountNo gets the value of 888 and it stores in the
         * accountNo parameter inside constructor
         * So, it prints 888
         */

    }

    public FinalClass(int accountNo, int ifscCode, int NOT_YET) {
        this.accountNo = accountNo;
        ifscCode = 200003;
        log.info("I will be fourth , printing new value of IFSC code as I'm final " +
                ifscCode);
        NOT_YET = 8;
        log.info("I will be 5th , to modify the static final field " + NOT_YET);
        //this.ifscCode = ifscCode;

        /*
         * The above field of this.IfscCode throws error as this pointer will let us to modify the value
         * and as it can't be assigned to a final variable, hence commenting it.
         */
    }


    public static void main(String[] args) {

        log.info("I will be the first statement from JVM");
        /*
         * We have private variables in the non-static class They are assigned some
         * value and you need to print it So, main method is static and needs an object
         * of non-static class to access the private fields and constructors
         * This is the normal approach.
         */

        FinalClass fc = new FinalClass(); // instantiating class
        FinalClass fcAcc = new FinalClass(777); // instantiating constructor with 1 param
        FinalClass fcAcc2 = new FinalClass(247234, 287492, 7); // instantiating constr with 2 params

        log.info("I will be 6th From main method ->" + fc.accountNo);

        log.info("I will be 7th From main method , with 1 parameterized const ->" +
                fcAcc.accountNo);
        /*
         * here, this. pointer will change the field value defined at top by replacing with
         * the instantiating value, if i want the same accountNo as in fields, remove this pointer.
         */
        log.info("I will be 8th with 3 parameterized const ->" +
                "IFSC ->" + fcAcc2.ifscCode +
                " and Acc No ->" + fcAcc2.accountNo + " Static Final variable " + fcAcc2.NOT_YET);
        /*
         * This pointer will enable to change the original accountNo and replace with
         * value provided while instantiating and this can't be done with IFSC as it is
         * final
         */
        log.info("I'm 9th and can directly be printed and can't be instantiated " + NOT_YET);
    }

}
