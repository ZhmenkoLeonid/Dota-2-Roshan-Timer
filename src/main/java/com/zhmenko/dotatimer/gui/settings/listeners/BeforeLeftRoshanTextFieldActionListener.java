package com.zhmenko.dotatimer.gui.settings.listeners;

import com.zhmenko.dotatimer.gui.settings.frames.ExampleTextArea;
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
import java.text.MessageFormat;

@RequiredArgsConstructor
public class BeforeLeftRoshanTextFieldActionListener implements DocumentListener {
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
                .setStringBeforeRoshanRecoveryLeftTime(e.getDocument().getText(0, e.getDocument().getLength()));

        exampleOutputTextArea.updateTextAreaText(currentConfigProperties);
    }
}
