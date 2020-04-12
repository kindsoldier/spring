/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

public class Response<T> {

    private boolean error = false;
    private T result;

    public T getResult() {
        return result;
    }

    public boolean getError() {
        return error;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
