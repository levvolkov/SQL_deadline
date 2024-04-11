package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static final Faker FAKER = new Faker(new Locale("en"));

    private DataHelper() {
    }

    // метод, который возвращает объект с информацией об аутентификации
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    // метод, который умеет генерировать случайный логин
    private static String generateRandomLogin() {
        return FAKER.name().username();
    }

    // метод, который умеет генерировать случайный пароль
    private static String generateRandomPassword() {
        return FAKER.internet().password();
    }

    // метод генерирующий случайного пользователя
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    // метод генерирующий случайный код верификации с помощью FAKER
    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(FAKER.numerify("######"));
    }

    // дата класс для создания объекта с информацией об аутентификации
    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    // дата класс для создания объекта кода верификации
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerificationCode {
        String code;
    }
}
