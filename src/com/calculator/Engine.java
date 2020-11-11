package com.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Engine {

	private static final String NOT_VALID = "No es una expresion valida";
	private static final String JAVASCRIPT = "JavaScript";

	private Validator validator;

	public Engine(){
		this.validator = new Validator();
	}

	private ScriptEngine getEngine() {
		ScriptEngineManager manager = new ScriptEngineManager();
		return manager.getEngineByName(JAVASCRIPT);
	}

	private Object getResult(String sentence) {
		try {
			validator.execute(sentence);
			return getEngine().eval(sentence);
		} catch (Exception e) {
			return NOT_VALID;
		}
	}

	public void calculate(String sentence) {
		System.out.println(getResult(sentence));
	}

}
