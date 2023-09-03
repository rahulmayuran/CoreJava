package com.corejava.FinalClass;


import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Level;
import java.util.logging.Logger;

@Slf4j
@ToString
public class Aboutfinal {

	static final int a; //declaring a static variable
	
	static
	{
		//should be initialized in static block
		a=10;
		log.info("Initializing the static variable inside static block as {}", a);
	}
	
	final int b=15; //initialized ,but called in a constructor
	
	
	public Aboutfinal(int b) {
		
		b=16;
		log.info("Inside the Constructor, but modifying the final variable :" + b);
	}
	
	
	public Aboutfinal() {
		
	}


	public static void main(String[] args) {

		log.info("The value of a is "+a);
		log.info("Instantiating the AboutFinal class without the parametrized constructor -> " + new Aboutfinal());
		log.info("Instantiating the AboutFinal class with the parametrized constructor -> " + new Aboutfinal(16));
		log.info("ClassLoader for AboutFinal class is "+Aboutfinal.class.getClassLoader());
		log.info("ClassLoader for String Class is " + String.class.getClassLoader());
		
	}
}
