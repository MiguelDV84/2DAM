package org.mdv.utils;

import javax.swing.*;

public class ModalPanel  {
    private String message;
    private String title;
    private int messageType;

    public ModalPanel(String message, String title, int messageType) {
        this.message = message;
        this.title = title;
        this.messageType = messageType;
        createPanel();
    }

    private void createPanel() {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}
