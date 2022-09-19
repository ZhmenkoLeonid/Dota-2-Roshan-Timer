package com.zhmenko.dotatimer.gui.frames;

import com.zhmenko.dotatimer.setting.ConfigProperties;

import javax.swing.*;
import java.text.MessageFormat;

public class ExampleTextArea extends JTextArea {
    public void updateTextAreaText(ConfigProperties configProperties) {
        String symbolBetweenTime = configProperties.isUsingColon() ? ":" : "";
        String aeg = MessageFormat.format("{0}{1}{2}", "05", symbolBetweenTime, "00");
        String leftRoshan = MessageFormat.format("{0}{1}{2}", "08", symbolBetweenTime, "00");
        String rightRoshan = MessageFormat.format("{0}{1}{2}", "11", symbolBetweenTime, "00");
        setText(MessageFormat.format("{0} {1} {2} {3} {4} {5}",
                configProperties.getStringBeforeAegisExpiredTime(),
                aeg,
                configProperties.getStringBeforeRoshanRecoveryLeftTime(),
                leftRoshan,
                configProperties.getStringBeforeRoshanRecoveryRightTime(),
                rightRoshan));
    }
}
