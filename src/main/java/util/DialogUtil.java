package util;

import javax.swing.*;

public class DialogUtil {

    /**
     * Показывает окошко с ошибкой
     * @param text - текст ошибки
     */
    public static void showError(String text) {
        JOptionPane.showMessageDialog(null, text, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}