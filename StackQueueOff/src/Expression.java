import java.util.Arrays;

public class Expression {

    public static double evaluate(String input) {
        LinkedStack<Double> values = new LinkedStack<>();
        String[] expr = toRPN(input);
        for (String s : expr) {
            try {
                double val = Double.parseDouble(s);
                values.push(val);
            } catch (NumberFormatException e) {
                values.push(operate(values.pop(), values.pop(), s.charAt(0)));
            }
        }
        if (values.size() != 1) throw new RuntimeException();
//        System.out.printf("RPN: %s\n", Arrays.toString(expr));
        return values.pop();
    }

    private static String[] toRPN(String input) {
        LinkedStack<String> rpn = new LinkedStack<>();
        LinkedStack<Character> operator = new LinkedStack<>();
        char[] expr = input.toCharArray();
        boolean unary = false;
        for (int i = 0; i < expr.length; i++) {
            char c = expr[i];
            if (c == '(') {
                operator.push('(');
            } else if (c == ')') {
                if (operator.size() == 0) throw new IllegalArgumentException("Parentheses mismatched");
                while (operator.peek() != '(') {
                    rpn.push(String.valueOf(operator.pop()));
                    if (operator.size() == 0) throw new IllegalArgumentException("Parentheses mismatched");
                }
                operator.pop();
            } else if (c >= '0' && c <= '9' || c == '.') {
                int end = i;
                while (end < expr.length && (expr[end] >= '0' && expr[end] <= '9' || expr[end] == '.')) end++;
                String operand = "";
                if (unary) {
                    operand += "-";
                    unary = false;
                    if (end >= expr.length || expr[end] != ')')
                        throw new UnsupportedOperationException("unary - not enclosed in ()");
                }
                rpn.push(operand + new String(Arrays.copyOfRange(expr, i, end)));
                i = end - 1;
            } else {
//                if (i + 1 >= expr.length) throw new IllegalArgumentException("Invalid expression");
                if (c == '-' && expr[i - 1] == '(') {
                    unary = true;
                    continue;
                }
                while (operator.size() != 0 && operator.peek() != '(' && opPrecedence(c) <= opPrecedence(operator.peek()))
                    rpn.push(String.valueOf(operator.pop()));
                operator.push(c);
            }
        }
        while (operator.size() != 0) {
            char op = operator.pop();
            if (op == '(' || op == ')') throw new IllegalArgumentException("Parenthesis did not match");
            rpn.push(String.valueOf(op));
        }
        return rpn.toArray();
    }

    private static int opPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new UnsupportedOperationException("Operator not supported");
        }
    }

    private static double operate(double val2, double val1, char op) {
        switch (op) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
            default:
                throw new UnsupportedOperationException("Invalid operator found in expression");
        }
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{
                "12*(-12)",
                "12*123/((-5)+2)",
                "((80-(19)))",
                "(1-2)+(((-4)))",
                "1+1",
                "12*(-123)",
                "2/2+3*4.75--6",
                "2/(2+3)*4.33-(-6.792)",
                "((2.33/(2.9+3.5)*4)-(-6.34))",
                "123.45*(678.90/((-2.5)+11.5)-(80-19)*33.25)/20+11",
                "(123.45*(678.90/((-2.5)+11.5)-(((80-(19)))*33.25))/20)-(123.45*(678.90/(-2.5+11.5)-(((80-(19)))*33.25))/20)+(13-2)/(-11)",
                "(123.45*(678.90/((-2.5)+11.5)-(((80-(19)))*33.25))/20)-(123.45*(678.90/((-2.5)+11.5)-(((80-(19)))*33.25))/20)+(13-2)/(-11)",
                "12*(-123)",
                "123.45*(678.90/(-2.5+11.5)-(80-19)*33.25)/0+11",
                "123",
                "-123",
                "(-123)",
                "(((1-5)+(3.93*2.34)*10)+(10+10+19-8*7/6+10))",
                "(9*3-(7*8+((-4/2)))",
                "2+3*4-5*2-10+"
        };
        for (String s : inputs) {
            System.out.printf("Input expression: %s\n", s);
            try {
                System.out.println(evaluate(s));
            } catch (Exception e) {
                System.out.println("Not valid");
            }
        }
    }

}
