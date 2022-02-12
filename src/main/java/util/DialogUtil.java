package util;

import javax.swing.*;

public class DialogUtil {

    public static void showError(String text) {
        JOptionPane.showMessageDialog(null, text, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}