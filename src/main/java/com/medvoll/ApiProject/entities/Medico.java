package com.medvoll.ApiProject.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Medico {

    private String name;
    private String email;
    private String phone;
    private String crm;
}
