package com.mkyong.examples.Chapter8.VariantC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrongPasswordCheckerTest {

    @Test
    void testStrongPassword() {
        assertTrue(StrongPasswordChecker.isStrongPassword("YourPassword123_")); // Сильный пароль
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(StrongPasswordChecker.isStrongPassword("Short1_")); // Слишком короткий пароль
    }

    @Test
    void testMissingUpperCase() {
        assertFalse(StrongPasswordChecker.isStrongPassword("yourpassword123_")); // Отсутствует заглавная буква
    }

    @Test
    void testMissingLowerCase() {
        assertFalse(StrongPasswordChecker.isStrongPassword("YOURPASSWORD123_")); // Отсутствует строчная буква
    }

    @Test
    void testMissingDigit() {
        assertFalse(StrongPasswordChecker.isStrongPassword("YourPassword_")); // Отсутствует цифра
    }

    @Test
    void testInvalidCharacter() {
        assertFalse(StrongPasswordChecker.isStrongPassword("YourPassword123!")); // Неверный символ
    }

    @Test
    void testValidCharactersOnly() {
        assertTrue(StrongPasswordChecker.isStrongPassword("Valid_Password123")); // Сильный пароль с допустимыми символами
    }
}
