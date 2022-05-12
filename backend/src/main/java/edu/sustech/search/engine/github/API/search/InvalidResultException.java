package edu.sustech.search.engine.github.API.search;

public class InvalidResultException extends Exception {
    public InvalidResultException() {
        super("Result matched json, but was either an usage error message or warning (and interruption) from API.");
    }
}
