package com.mindtree.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class DemoLog4j {
	private Logger logger;
	@Test
	public void userLogin() {
		logger=Logger.getLogger("DemoLog4j.class");
		PropertyConfigurator.configure("C:\\Users\\mindsdet143\\eclipse-workspace\\CA_Hybrid_Framework\\src\\main\\resources\\log4j.properties");
		System.out.println("\n Printing Logger messages \n");
		logger.trace("to trace the execution");
		logger.info("Browser launched");
		logger.error("it in not printed");
		logger.warn("printing warning messages");
		logger.fatal("It is a fatal defect");
		
		System.out.println("\n Printing Logger messages are completed \n");
		
	}

}
