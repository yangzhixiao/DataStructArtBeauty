package com.company;

import java.util.*;

public class MyStackDemo {

    public static void main(String args[]) {
        System.out.println("1+2+3+4-4-5-6 = " + exprValue("1+2+3+4-4-5-6"));
        System.out.println("1+2*3-4/2 = " + exprValue("1+2*3-4/2"));
        System.out.println("1+2*3-4/2+9*2/3*3 = " + exprValue("1+2*3-4/2+9*2/3*3"));
        System.out.println("11+2*13-24/2 = " + exprValue("11+2*13-24/2"));
        System.out.println("111*20/2.3 = " + exprValue("111*20/2.3"));

        System.out.println("2*(1+3) = " + eval("2*(1+3)"));
        System.out.println("2*[(6+3)/3-2] = " + eval("2*[(6+3)/3-2]"));
        System.out.println("100-2*[(6+3)/3-2+(1+2*3)]/4+3/1.5 = " + eval("100-2*[(6+3)/3-2+(1+2*3)]/4+3/1.5"));
    }

    public static String eval(String str) {
        Stack<Character> scopeStack = new Stack<>();
        Stack<ExprNode> exprStack = new Stack<>();
        char[] chars = str.toCharArray();
        int level = 0;
        StringBuilder tempExpr = new StringBuilder();
        for (int i = 0; i < chars.length; i ++) {
            Character c = chars[i];
            if (c.equals('[') || c.equals('(')) {
                if (tempExpr.length() != 0) {
                    exprStack.push(new ExprNode(level, tempExpr.toString()));
                    tempExpr.delete(0, tempExpr.length());
                }
                level++;
                scopeStack.push(c);
            } else if (c.equals(']') || c.equals(')')) {
                if (tempExpr.length() != 0) {
                    exprStack.push(new ExprNode(level, tempExpr.toString()));
                    tempExpr.delete(0, tempExpr.length());
                }
                if (isPairScope(scopeStack.peek(), c)) {
                    scopeStack.pop();
                    String value = exprValue(exprStack.pop().expr);
                    level--;
                    if (!exprStack.isEmpty() && exprStack.peek().level == level) {
                        exprStack.push(new ExprNode(level, exprStack.pop().expr.concat(value)));
                    } else {
                        tempExpr.append(value);
                    }
                }
            } else {
                tempExpr.append(c);
                if (i == chars.length - 1) {
                    exprStack.push(new ExprNode(level, tempExpr.toString()));
                    tempExpr.delete(0, tempExpr.length());
                }
            }
        }
        if (exprStack.size() == 1) {
            return exprValue(exprStack.pop().expr);
        }
        if (exprStack.size() > 1) {
            StringBuilder sb = new StringBuilder();
            for (ExprNode e : exprStack) {
                sb.append(e.expr);
            }
            return exprValue(sb.toString());
        }
        return "";
    }

    public static String exprValue(String expr) {
        expr = expr.replace(" ", "");
        Stack<Double> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        List<String> list = splitExpr(expr);
        for (int i = 0; i < list.size(); i++) {
            String c = list.get(i);
            if (isOp(c)) {
                if (opStack.empty()) {
                    opStack.push(c);
                } else if (!opStack.empty() && isOpHigh(c, opStack.peek())) {
                    opStack.push(c);
                } else {
                    numStack.push(calc(numStack.pop(), numStack.pop(), opStack.pop()));
                    if (!opStack.empty() && !isOpHigh(c, opStack.peek())) {
                        numStack.push(calc(numStack.pop(), numStack.pop(), opStack.pop()));
                    }
                    opStack.push(c);
                }
            } else {
                numStack.push(Double.parseDouble(c.toString()));
                if (i == list.size() - 1) {
                    while (!opStack.isEmpty()) {
                        numStack.push(calc(numStack.pop(), numStack.pop(), opStack.pop()));
                    }
                }
            }
        }

        return numStack.pop().toString();
    }

    public static boolean isPairScope(Character left, Character right) {
        if (left.equals('[') && right.equals(']')) {
            return true;
        }
        if (left.equals('(') && right.equals(')')) {
            return true;
        }
        return false;
    }

    public static boolean isOp(String c) {
        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
            return true;
        }
        return false;
    }

    public static boolean isOpHigh(String source, String target) {
        Map<String, Integer> opMap = new HashMap<>();
        opMap.put("/", 4);
        opMap.put("*", 4);
        opMap.put("-", 1);
        opMap.put("+", 1);
        return opMap.get(source) > opMap.get(target);
    }

    public static Double calc(Double a, Double b, String op) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return b - a;
        }
        if (op.equals("*")) {
            return a * b;
        }
        if (op.equals("/")) {
            return b / a;
        }
        return 0.0;
    }

    public static List<String> splitExpr(String expr) {
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (Character c : expr.toCharArray()) {
            if (isOp(c.toString())) {
                list.add(temp.toString());
                list.add(c.toString());
                temp.delete(0, temp.capacity() - 1);
            } else {
                temp.append(c.toString());
            }
        }
        list.add(temp.toString());
        return list;
    }

    public static class ExprNode {
        public int level = 0;
        public String expr;

        public ExprNode() {

        }

        public ExprNode(int level, String expr) {
            this.level = level;
            this.expr = expr;
        }

        @Override
        public String toString() {
            return expr + "  level: " + level;
        }
    }
}
