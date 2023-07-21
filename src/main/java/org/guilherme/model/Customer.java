package org.guilherme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Customer {

    @JsonProperty
    private String cpf;
    @JsonProperty
    private String name;

    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Customer() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
