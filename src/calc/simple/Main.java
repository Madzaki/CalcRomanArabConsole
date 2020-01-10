package calc.simple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello! This is Calculator!");
        System.out.println("There are some rules.");
        System.out.println("1) Enter two numbers and a mathematical action between them.");
        System.out.println("2) Enter numbers from 1 to 10.");
        System.out.println("3) Enter integers.");
        System.out.println("4) Enter only Roman or Arabic numerals.");
        System.out.println("5) Write the expression according to the following pattern:");
        System.out.println("INPUT:5 + 2");
        System.out.println("INPUT:X * III");
        System.out.println("To exit INPUT:exit\n");
        while(true){
            Scanner inputScan = new Scanner(System.in);
            String input = inputScan.nextLine();    //Ввод пользователя и присвоение его полю 'input'
            if (input.equals("exit")) {     //Проверка ввода пользователя на значение 'exit'
                System.out.println("\nBye bye!\n");
                break;  //Завершение программы
            } else {
                MathClass.calcThis(input);  //Запуск расчёта
            }
        }
    }
}
