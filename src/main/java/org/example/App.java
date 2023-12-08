package org.example;


import org.example.tests.Store77Test;

public class App {
    public static void main(String[] args) throws InterruptedException {
//2023
        System.out.println("Запуск теста регистрации и выборки ноутбуков на сайте Store77..");
        Store77Test.RegistrationAndSelectionItemTest();
        System.out.println("Тест проведен успешно");
    }
}
