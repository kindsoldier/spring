/*
 *
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 *
 *
 */

package org.unix7.spring;

public class ListResult<T> {
    private int limit;
    private int offset;
    private int total;

    private T list;

    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public T getList() {
        return list;
    }
    public void setList(T list) {
        this.list = list;
    }

}
