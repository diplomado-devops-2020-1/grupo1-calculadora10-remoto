package com.calculator;

public class Validator {

    private static final String PLUS_SIGN = "\\++";
    private static final String MINUS_SIGN = "\\-+";
    private static final String MULTIPLICATION_SIGN = "\\*+";
    private static final String PARENTHESES_OPEN = "\\(+";
    private static final String PARENTHESES_CLOSE = "\\)+";
    private static final String DOT_SIGN = "\\.+";

	public void execute(String sentence) {
        String aux = removeNumbers(sentence);
        aux = removeParentheses(aux);
        aux = removeDecimal(aux);
        validateSigns(aux);
    }

    private void validateSigns(String sentence) {
        String aux = sentence.replaceAll(PLUS_SIGN, "");
        aux = aux.replaceAll(MINUS_SIGN, "");
        aux = aux.replaceAll(MULTIPLICATION_SIGN, "");
        if(!aux.isEmpty()){
            throw new IllegalArgumentException("OPERACION_NO_VALIDA");
        }
    }

    private String removeNumbers(String sentence) {
        return sentence.replaceAll("[0-9]", "")
            .replaceAll("\\ +", "");
    }

    private String removeParentheses(String sentence){
        return sentence
            .replaceAll(PARENTHESES_OPEN, "")
            .replaceAll(PARENTHESES_CLOSE, "");
    }

    private String removeDecimal(String sentence){
        return sentence
            .replaceAll(DOT_SIGN, "");
    }

}
