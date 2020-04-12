/*
 *
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 *
 *
 */

package org.unix7.spring;

public class Incoming {

    private Long id;
    private Long agentId;
    private String agentName;
    private Long divisionId;
    private String divisionName;
    private Long value;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentId() {
        return agentId;
    }
    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Long getDivisionId() {
        return divisionId;
    }
    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Long getValue() {
        return value;
    }
    public void setValue(Long value) {
        this.value = value;
    }


}
