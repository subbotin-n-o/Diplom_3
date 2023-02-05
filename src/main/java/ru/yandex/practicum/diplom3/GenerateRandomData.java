package ru.yandex.practicum.diplom3;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerateRandomData {

    public static String getRandomName() {
        return new Faker(new Locale("en"))
                .name()
                .firstName();
    }

    public static String getRandomEmail() {
        return new Faker(new Locale("en"))
                .internet()
                .emailAddress();
    }

    public static String getRandomValidPassword() {
        return new Faker(new Locale("en"))
                .internet().password(6, 10);
    }

    public static String getRandomNotValidPassword() {
        return new Faker(new Locale("en"))
                .internet().password(4,5);
    }

}