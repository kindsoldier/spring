/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

public class Hello {

    private final String message = "hello";
    private final int data[] = { 1, 2, 3, 4 };

    public String getMessage() {
        return message;
    }

    public int[] getData() {
        return data;
    }
}
