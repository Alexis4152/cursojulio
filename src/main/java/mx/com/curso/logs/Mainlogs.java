package mx.com.curso.logs;

import org.apache.log4j.Logger;

public class Mainlogs {
	
	private static Logger logJava = Logger.getLogger(Mainlogs.class);

	public static void main(String[] args) {
		logJava.debug("LOG DEBUG");
		logJava.info("LOG INFO");
		logJava.warn("LOG WARN");
		logJava.error("LOG ERROR");
		logJava.fatal("LOG FATAL");
	}

}
