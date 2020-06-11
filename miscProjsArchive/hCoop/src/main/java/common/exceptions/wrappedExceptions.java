package common.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class wrappedExceptions {
	public static void throwRunTimeException(String type) {
		try {
			switch (type) {
			case "ERROR_001":
				throw new IOException("fail to I/O txt file");
			case "ERROR_002":
				throw new FileNotFoundException("cannot find file");
			default:
				return;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
