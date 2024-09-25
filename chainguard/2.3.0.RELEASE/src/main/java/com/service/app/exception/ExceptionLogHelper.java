package com.service.app.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;

public class ExceptionLogHelper {

	private static Logger logger = Logger.getLogger(ExceptionLogHelper.class);

	public static String convertToString(Exception argE) {
		try {
			ByteArrayOutputStream pvBAOS = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(pvBAOS);
			argE.printStackTrace(ps);
			return pvBAOS.toString();
		} catch (Exception e) {
			logger.error("Exception while converting exception ", e);
			return null;
		}
	}

}
