package org.example.exception;

import javax.security.auth.login.CredentialException;

public class WrongPasswordException extends CredentialException {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String msg) {
        super(msg);
    }
}
