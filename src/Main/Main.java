package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws Exception{
        System.out.println("One expression:\n");
        ReadFromFile("one_expression.txt");
        System.out.println("Three expressions:\n");
        ReadFromFile("three_expressions.txt");
    }

    public static void ReadFromFile(String path) throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(path));
        while (true){
            String str=reader.readLine();
            if(str==null) break;
            System.out.println("\nFound Expression: "+str);
            System.out.println("\nExpresssion: "+CheckParentheses(str));
        }
    }

    public static String CheckParentheses(String expr){
        if (expr.isEmpty())
            return "Is Empty!";

        Stack<Character> stack=new Stack<Character>();
        for(int i=0; i<expr.length();i++){
            char firstChar=expr.charAt(i);
            if(firstChar=='(' || firstChar=='[' || firstChar=='{'){
                stack.push(firstChar);
            }
            else if(firstChar==')' || firstChar==']' || firstChar=='}'){
                if(stack.isEmpty())
                    return "Incorrect!";

                char lastChar= stack.peek();

                if (firstChar=='(' && lastChar==')' || firstChar=='[' && lastChar==']' ||firstChar=='{' && lastChar=='}')
                stack.pop();

                else return "Incorrect!";
            }
        }
        if(stack.isEmpty())
            return "Correct!";
        else
            return "Incorrect!";
    }
}
