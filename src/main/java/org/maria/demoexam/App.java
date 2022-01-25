package org.maria.demoexam;

import ui.ServiceTableForm;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            new ServiceTableForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
