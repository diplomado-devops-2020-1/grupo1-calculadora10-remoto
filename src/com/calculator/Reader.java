package com.calculator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Reader {

	private Scanner scanner;
	
	public Reader(InputStream stream) {
		super();
		this.scanner = new Scanner(new InputStreamReader(stream));
	}

	public String read() {
		String value = scanner.nextLine();
		while(value.trim().isEmpty()) {
			value = scanner.nextLine();
		}
		return value;
	}
	
}
