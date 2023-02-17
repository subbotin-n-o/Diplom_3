package ru.yandex.practicum.diplom3.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserGenerator {

    private final String name;
    private final String email;
    private final String password;
    private final String notValidPassword;

    public UserGenerator() {
        Faker faker = new Faker(new Locale("en"));

        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 10);
        notValidPassword = faker.internet().password(4,5);
    }

    public UserGenerator getUserCredential() {
        return new UserGenerator(null, getEmail(), getPassword(), null);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNotValidPassword() {
        return notValidPassword;
    }
}