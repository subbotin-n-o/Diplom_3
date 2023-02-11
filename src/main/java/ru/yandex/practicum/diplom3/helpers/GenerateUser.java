package ru.yandex.practicum.diplom3.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerateUser {

    private final String name;
    private final String email;
    private final String validPassword;
    private final String notValidPassword;

    public GenerateUser() {
        Faker faker = new Faker(new Locale("en"));

        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        validPassword = faker.internet().password(6, 10);
        notValidPassword = faker.internet().password(4,5);
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