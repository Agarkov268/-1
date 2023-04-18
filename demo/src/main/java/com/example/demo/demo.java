package com.example.demo;

import java.util.Scanner;


public class demo  {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+","-","/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите пример");
        String exp = scn.nextLine();
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("Формат математической операции не корректен");
            return;
        }
        String str1 = new String(exp);
        if(str1.length()>3){
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            }else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            if (a>10){
                System.out.println("Некорректное выражение");
                return;
            }
            if (b>10){
                System.out.println("Некорректное выражение");
                return;
            }
            if (a<1){
                System.out.println("Некорректное выражение");
                return;
            }
            if (b<1){
                System.out.println("Некорректное выражение");
                return;
            }

            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if (isRoman){
                System.out.println(converter.intToRoman(result));
            } else {
                System.out.println(result);
            }

        }else{
            System.out.println("Используются одновременно разные системы счисления");
        }
    }



}
