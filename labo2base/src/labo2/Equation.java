package labo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Equation extends Vecteur {
    private ArrayList<Character> variables = new ArrayList<Character>();
    private ArrayList<Integer> coefficients = new ArrayList<Integer>();
    private int constante;
    private String equation;

    public Equation(ArrayList<Character> pVariables, ArrayList<Integer> pCoefficients, int pConstante) {
        variables = pVariables;
        coefficients = pCoefficients;
        constante = pConstante;
    }

    public Equation(){
    }

    public String toString(){
        String res = "";
        res += coefficients.get(0) + "" + variables.get(0);

        for (int i = 1; i < variables.size(); i++) {

            int coeff = coefficients.get(i);
            if (coeff < 0) {
                res += " - ";
            } else {
                res += " + ";
            }

            res += Math.abs(coeff) + "" + variables.get(i);
        }

        res += " = " + constante;
        return res;
    }
    public void lire(String source) {
        final String delims = "+-=";
        HashMap<Character, Integer> signes = new HashMap<Character, Integer>();
        signes.put('+', 1);
        signes.put('-', -1);

        int lastSign = 1;
        boolean complete = false;

        StringTokenizer tokenizer = new StringTokenizer(source, delims, true);

        while (tokenizer.hasMoreTokens()) {

            String val = tokenizer.nextToken().trim();
            if (val.length() == 0)
                continue;

            if (isOperator(val)) {

                lastSign = signes.get(val.charAt(0));

            } else if (isOperatorEquals(val)) {

                if (!tokenizer.hasMoreTokens())
                    throw new IllegalArgumentException("Equation: équation mal formée (constante manquante à la fin");

                constante = Integer.parseInt(tokenizer.nextToken().trim());
                complete = true;
                break;

            } else {

                int coeff = Integer.parseInt(val.substring(0, val.length() - 1));
                char var = val.charAt(val.length() - 1);

                if (variables.contains(var))
                    throw new IllegalArgumentException("Equation: équation mal formée (variable dupliquée");

                variables.add(var);
                coefficients.add(coeff * lastSign);
            }
        }
        if (tokenizer.hasMoreTokens())
            throw new IllegalArgumentException("Equation: équation mal formée (expression continue après la constante");
        if (!complete)
            throw new IllegalArgumentException("Equation: équation mal formée (manque = constante à la fin)");

    }

    private static boolean isOperator(String c) {

        if (c.length() == 1) {
            return c.charAt(0) == '+' || c.charAt(0) == '-';
        }

        return false;
    }

    private static boolean isOperatorEquals(String c) {

        if (c.length() == 1) {
            return c.charAt(0) == '=';
        }

        return false;
    }

    public boolean equals(Object obj){
        if (obj instanceof Equation) {
            Equation eq = (Equation) obj;
            if(variables.size() != eq.variables.size()){
                return false;
            }
            for (int i = 0; i < variables.size(); i++) {
                if (!variables.get(i).equals(eq.variables.get(i))) {
                    return false;
                }
            }
            if (coefficients.size() != eq.coefficients.size()) {
                return false;
            }
            for (int i = 0; i < coefficients.size(); i++) {
                if (!coefficients.get(i).equals(eq.coefficients.get(i))) {
                    return false;
                }
            }
            if (constante != eq.constante) {
                return false;
            }
            return true;
        }
        return false;
    }
}
