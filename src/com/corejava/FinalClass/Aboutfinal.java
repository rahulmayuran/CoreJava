package com.corejava.FinalClass;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Aboutfinal {
	
	private static Logger LOGGER = Logger.getLogger(Aboutfinal.class.getName());

	static final int a; //decalring a static variable 
	
	static
	{
		//should be initialized in static block
		LOGGER.log(Level.CONFIG, "Initializing the static variable inside static block as ", a=10);
	}
	
	final int b=15; //initialized ,but called in a constructor
	
	
	public Aboutfinal(int b) {
		
		b=16;
		LOGGER.info("Inside the Constructor, but modifying the final variable :" + b);
	}
	
	
	public Aboutfinal() {
		
	}


	public static void main(String[] args) {

		LOGGER.info("The value of a is "+a);
		LOGGER.info("Instantiating the AboutFinal class without the parametrized constructor -> " + new Aboutfinal());
		LOGGER.info("Instantiating the AboutFinal class with the parametrized constructor -> " + new Aboutfinal(16));
		LOGGER.info("ClassLoader for AboutFinal class is "+Aboutfinal.class.getClassLoader());
		LOGGER.info("ClassLoader for String Class is " + String.class.getClassLoader());
		
	}


	@Override
	public String toString() {
		return "Aboutfinal{" +
				"b=" + b +
				'}';
	}
}
