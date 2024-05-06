package com.zhmenko.dotatimer.gsiservice.gui.listeners;

import com.zhmenko.dotatimer.gsiservice.setting.ConfigProperties;
import com.zhmenko.dotatimer.gsiservice.gui.frames.ExampleTextArea;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
