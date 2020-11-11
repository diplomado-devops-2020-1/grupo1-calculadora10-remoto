package com.calculator;

import java.io.InputStream;

public class Calculator {

	private static final String SEPARATOR    = "==========================================================\n";
	private static final String INSTRUCTIONS_A = "Introduzca una expresion para evaluarla y presione Enter.\n";
	private static final String EXAMPLES = "Ejemplos:\n 1+1\n 200-300\n 5*5\n";
	private static final String INSTRUCTIONS_B = "Escriba 'exit' + Enter para salir.\n";
	private static final String EXIT = "exit";

	private Reader reader;
	private Engine engine;

	public Calculator(InputStream stream) {
		super();
		this.reader = new Reader(stream);
		this.engine = new Engine();
	}

	public void execute() {
		System.out.println(getInstructions());
		String sentence = reader.read();
		while (!sentence.equalsIgnoreCase(EXIT)) {
			engine.calculate(sentence);
			sentence = reader.read();
		}
	}

	private String getInstructions() {
		StringBuilder sb = new StringBuilder();
		sb.append(SEPARATOR);
		sb.append(INSTRUCTIONS_A);
		sb.append(EXAMPLES);
		sb.append(SEPARATOR);
		sb.append(INSTRUCTIONS_B);
		sb.append(SEPARATOR);
		return sb.toString();
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator(System.in);
		calculator.execute();
	}

}
