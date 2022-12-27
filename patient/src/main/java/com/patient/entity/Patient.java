package com.patient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
    private int id;
    private String name;
    private String phone;
}
