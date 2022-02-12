package org.maria.demoexam;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.Date;

@Data
@AllArgsConstructor

public class ClientEntity {

    private int ID;
    private String Title;
    private String ProductTypeID;
    private String ArticleNumber;
    private String Description;
    private String Image;
    private int ProductionPersonCount;
    private int ProductionWorkshopNumber;
    private double MinCostForAgent;

}