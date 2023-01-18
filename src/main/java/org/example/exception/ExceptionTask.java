package org.example.exception;

/**
 * Основное задание на исключения:
 * 1. Создать класс, в котором будет статический метод.
 * Этот метод принимает на вход три параметра:
 * Login,
 * Password,
 * confirmPassword.
 * Все поля имеют тип данных String.
 * Длина login должна быть меньше 20 символов и не должен содержать
 * пробелы.
 * Если login не соответствует этим требованиям, необходимо выбросить
 * WrongLoginException.
 * Длина password должна быть меньше 20 символов, не должен содержать
 * пробелом и должен содержать хотя бы одну цифру.
 * Также password и confirmPassword должны быть равны.
 * Если password не соответствует этим требованиям, необходимо
 * выбросить WrongPasswordException.
 * WrongPasswordException и WrongLoginException - пользовательские
 * классы исключения с двумя конструкторами – один по умолчанию, второй
 * принимает сообщение исключения и передает его в конструктор класса
 * Exception.
 * Метод возвращает true, если значения верны или false в другом случае.
 */
public class ExceptionTask {
    private static final String userLogin = "login";
    private static final String userPassword = "passw0rd";
    public boolean doLogin(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (isLengthCondition(login) || isContainsSpace(login)) {
            throw new WrongLoginException();
        }

        if (isLengthCondition(password)
                || isContainsSpace(password)
                || !(isContainsNumber(password))
                || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }

        return userLogin.equals(login) && userPassword.equals(password);
    }

    private boolean isLengthCondition(String str) {
        return str.length() >= 20;
    }

    private boolean isContainsSpace(String str) {
        return str.contains(" ");
    }

    private boolean isContainsNumber(String str) {
        return str.matches(".*\\d.*");
    }

}
