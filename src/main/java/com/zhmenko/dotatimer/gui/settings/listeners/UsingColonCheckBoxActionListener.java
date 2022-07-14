package com.zhmenko.dotatimer.gui.settings.listeners;

import com.zhmenko.dotatimer.gui.settings.frames.ExampleTextArea;
import com.zhmenko.dotatimer.setting.ConfigProperties;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class UsingColonCheckBoxActionListener implements ActionListener {
    private final ConfigProperties currentConfigProperties;
    private final ExampleTextArea exampleOutputTextArea;

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox source = (JCheckBox) e.getSource();
        currentConfigProperties.setUsingColon(source.isSelected());
        exampleOutputTextArea.updateTextAreaText(currentConfigProperties);
    }
}
