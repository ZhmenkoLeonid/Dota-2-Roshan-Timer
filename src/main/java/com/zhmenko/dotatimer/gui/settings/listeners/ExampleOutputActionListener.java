package com.zhmenko.dotatimer.gui.settings.listeners;

import com.zhmenko.dotatimer.setting.Config;
import com.zhmenko.dotatimer.setting.ConfigProperties;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;

@RequiredArgsConstructor
public class ExampleOutputActionListener implements ActionListener {
    private final JTextArea exampleOutputTextArea;
    private final ConfigProperties configProperties;
    @Override
    public void actionPerformed(ActionEvent e) {
        String symbolBetweenTime = configProperties.isUsingColon() ? ":" : "";
        String aeg = MessageFormat.format("{0}{1}{2}", "05", symbolBetweenTime, "00");
        String leftRoshan = MessageFormat.format("{0}{1}{2}", "08", symbolBetweenTime, "00");
        String rightRoshan = MessageFormat.format("{0}{1}{2}", "11", symbolBetweenTime, "00");

        exampleOutputTextArea.setText(MessageFormat.format("{0} {1} {2} {3} {4} {5}",
                configProperties.getStringBeforeAegisExpiredTime(),
                aeg,
                configProperties.getStringBeforeRoshanRecoveryLeftTime(),
                leftRoshan,
                configProperties.getStringBeforeRoshanRecoveryRightTime(),
                rightRoshan));
    }
}
