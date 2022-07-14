package com.zhmenko.dotatimer.gui.settings.listeners;

import com.zhmenko.dotatimer.gui.settings.frames.ExampleTextArea;
import com.zhmenko.dotatimer.setting.ConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.*;
import java.text.MessageFormat;

@RequiredArgsConstructor
public class BeforeAegisTextFieldActionListener implements DocumentListener {
    private final ConfigProperties currentConfigProperties;
    private final ExampleTextArea exampleOutputTextArea;

    @Override
    public void insertUpdate(DocumentEvent e) {
        action(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        action(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        action(e);
    }

    @SneakyThrows
    private void action(DocumentEvent e) {
        currentConfigProperties
                .setStringBeforeAegisExpiredTime(e.getDocument().getText(0,e.getDocument().getLength()));

        exampleOutputTextArea.updateTextAreaText(currentConfigProperties);
    }
}
