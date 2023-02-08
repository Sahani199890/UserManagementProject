package com.example.UserManagementProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Model {
    private int userId;
    private String name;
    private String userName;
    private  String address;
    private String phoneNo;
}
