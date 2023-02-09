package ru.yandex.practicum.diplom3;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerateUser {

    private final String name;
    private final String email;
    private final String validPassword;
    private final String notValidPassword;

    public GenerateUser() {
        name = getRandomName();
        email = getRandomEmail();
        validPassword = getRandomValidPassword();
        notValidPassword = getRandomNotValidPassword();
    }

    private static String getRandomName() {
        return new Faker(new Locale("en"))
                .name()
                .firstName();
    }

    private static String getRandomEmail() {
        return new Faker(new Locale("en"))
                .internet()
                .emailAddress();
    }

    private static String getRandomValidPassword() {
        return new Faker(new Locale("en"))
                .internet().password(6, 10);
    }

    private static String getRandomNotValidPassword() {
        return new Faker(new Locale("en"))
                .internet().password(4,5);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getNotValidPassword() {
        return notValidPassword;
    }
}