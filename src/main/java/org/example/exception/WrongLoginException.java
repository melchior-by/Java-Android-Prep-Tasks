package org.example.exception;

import javax.security.auth.login.CredentialException;

public class WrongLoginException extends CredentialException {
    public WrongLoginException(String msg) {
        super(msg);
    }

    public WrongLoginException() {
        super();
    }
}
