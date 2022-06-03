package com.metajava.JVM;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.BaseLogger.Logger.commmonLogger;

/*To see how JVM creates Class type and stores in Heap memory*/
public class AboutJVM {

    public static void main(String[] args) {

        SampleClass sample = new SampleClass();

        Class jvm = sample.getClass();
        commmonLogger.info("The Super class of JVM object is : "+ jvm.getSuperclass());
        commmonLogger.info("The Class of JVM object is : "+ jvm.getName());

        /*To print all the methods*/
        Method[] methods = jvm.getDeclaredMethods();
        for(Method m : methods){
            commmonLogger.info("All methods inside Sample class is " + m);
        }

        /*To print all the fields*/
        Field [] fields = jvm.getDeclaredFields();
        for (Field f:
             fields) {
            commmonLogger.info("All the fields of Sample class are " + f);
        }

    }
}
