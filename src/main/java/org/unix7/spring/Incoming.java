/*
 *
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 *
 *
 */

package org.unix7.spring;

public class Incoming {

    private int id;
    private int agentId;
    private String agentName;
    private int divisionId;
    private String divisionName;
    private int value;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAgentId() {
        return agentId;
    }
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public int getDivisionId() {
        return divisionId;
    }
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }


}
