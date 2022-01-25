package org.maria.demoexam;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor

public class ClientEntity {
    private int ID;
    private String FirstName;
    private String LastName;
    private String Patronymic;
    private Date Birthday;
    private Date RegistrationDate;
    private String Email;
    private String Phone;
    private String GenderCode;
    private String PhotoPath;
}
