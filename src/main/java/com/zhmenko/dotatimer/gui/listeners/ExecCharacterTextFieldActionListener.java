package com.zhmenko.dotatimer.gui.listeners;

import com.zhmenko.dotatimer.setting.ConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

@RequiredArgsConstructor
public class ExecCharacterTextFieldActionListener implements DocumentListener {
    private final ConfigProperties currentConfigProperties;

    @Override
    public void insertUpdate(DocumentEvent e) {
        action(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        action(e);
    }

    @SneakyThrows
    @Override
    public void changedUpdate(DocumentEvent e) {
        action(e);
    }

    @SneakyThrows
    private void action(DocumentEvent e) {
        String text = e.getDocument().getText(0, e.getDocument().getLength());
        currentConfigProperties.setExecChar(text.length() == 0 ? null : text.charAt(0));
    }
}
