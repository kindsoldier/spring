/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

public class Response<T> {
    private boolean error = false;
    private String message = "";
    private T result;

    public boolean getError() {
        return error;
    }
    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }
    public void setResult(T result) {
        this.result = result;
    }
}
