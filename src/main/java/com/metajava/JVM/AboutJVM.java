package com.metajava.JVM;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*To see how JVM creates Class type and stores in Heap memory*/
@Slf4j
public class AboutJVM {

    public static void main(String[] args) {

        SampleClass sample = new SampleClass();

        Class jvm = sample.getClass();
        log.info("The Super class of JVM object is : "+ jvm.getSuperclass());
        log.info("The Class of JVM object is : "+ jvm.getName());

        /*To print all the methods*/
        Method[] methods = jvm.getDeclaredMethods();
        for(Method m : methods){
            log.info("All methods inside Sample class is " + m);
        }

        /*To print all the fields*/
        Field [] fields = jvm.getDeclaredFields();
        for (Field f:
             fields) {
            log.info("All the fields of Sample class are " + f);
        }

    }
}
