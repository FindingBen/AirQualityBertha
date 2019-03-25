package com.example.airqualityapi;

class PasswordChecker {

    // TODO: This method needs to do some proper password checking
    public static boolean Check(String username, String password) {
        return password.startsWith("P");
    }
}