package com.zhmenko.dotatimer.keyboard;

import com.zhmenko.dotatimer.setting.Config;
import com.zhmenko.dotatimer.setting.ConfigProperties;

import java.text.MessageFormat;

public class MessageConverter {
    private final Config config;

    public MessageConverter(Config config) {
        this.config = config;
    }

    @Deprecated
    public String convert(String str) {
        try {
            Integer.parseInt(str, 10);
            return clearConvert(str);
        } catch (NumberFormatException e) {
            return trashConvert(str);
        }
    }

    public String convert(long clockTimeSeconds) {
        //                                             Учитываем задержку сервера GSI
        //                                         |                                    |
        //                                         v                                    v
        return buildString((clockTimeSeconds + 1) / 60, (clockTimeSeconds + 1) % 60);
    }

    @Deprecated
    private String trashConvert(String str) {
        int min = -1;
        int seconds = -1;

        if (str.length() == 5 && str.charAt(0) <= '9' && str.charAt(0) >= '0'
                && str.charAt(1) <= '9' && str.charAt(1) >= '0'
                && str.charAt(2) <= '9' && str.charAt(2) >= '0' && str.charAt(3)
                <= '9' && str.charAt(3) >= '0') {
            min = atoi(str.charAt(0)) * 10 + atoi(str.charAt(1));
            seconds = atoi(str.charAt(2)) * 10 + atoi(str.charAt(3));
        } else if (str.length() == 6 && str.charAt(0) <= '9' && str.charAt(0)
                >= '0' && str.charAt(1) <= '9' &&
                str.charAt(1) >= '0' && str.charAt(2) <= '9' && str.charAt(2)
                >= '0' && str.charAt(3) <= '9'
                && str.charAt(3) >= '0' && str.charAt(4) <= '9' & str.charAt(4) >= '0') {
            min = atoi(str.charAt(0)) * 100 + atoi(str.charAt(1)) * 10
                    + atoi(str.charAt(2));
            seconds = atoi(str.charAt(3)) * 10 + atoi(str.charAt(4));
        }
        if (min == -1 || seconds == -1) {
            return "";
        }
        return buildString(min, seconds);
    }

    @Deprecated
    private String clearConvert(String str) {
        int min = -1;
        int seconds = -1;

        if (str.length() == 4 && str.charAt(0) <= '9' && str.charAt(0) >= '0'
                && str.charAt(1) <= '9' && str.charAt(1) >= '0'
                && str.charAt(2) <= '9' && str.charAt(2) >= '0' && str.charAt(3)
                <= '9' && str.charAt(3) >= '0') {
            min = atoi(str.charAt(0)) * 10 + atoi(str.charAt(1));
            seconds = atoi(str.charAt(2)) * 10 + atoi(str.charAt(3));
        } else if (str.length() == 5 && str.charAt(0) <= '9' && str.charAt(0)
                >= '0' && str.charAt(1) <= '9' &&
                str.charAt(1) >= '0' && str.charAt(2) <= '9' && str.charAt(2)
                >= '0' && str.charAt(3) <= '9'
                && str.charAt(3) >= '0' && str.charAt(4) <= '9' & str.charAt(4) >= '0') {
            min = atoi(str.charAt(0)) * 100 + atoi(str.charAt(1)) * 10
                    + atoi(str.charAt(2));
            seconds = atoi(str.charAt(3)) * 10 + atoi(str.charAt(4));
        }
        if (min == -1 || seconds == -1) {
            return "";
        }
        return buildString(min, seconds);
    }

    public String buildString(long min, long seconds) {
        ConfigProperties configProperties = config.getConfigProperties();

        String symbolBetweenTime = configProperties.isUsingColon() ? ":" : "";

        String aegis = writeZeroIfMsgLenEq1(min + 5) + symbolBetweenTime
                + writeZeroIfMsgLenEq1(seconds);
        String roshanRecoveryMinimum = writeZeroIfMsgLenEq1(min + 8) + symbolBetweenTime
                + writeZeroIfMsgLenEq1(seconds);
        String roshanRecoveryMaximum = (min + 11) + symbolBetweenTime
                + writeZeroIfMsgLenEq1(seconds);

        return MessageFormat.format("{0} {1} {2} {3} {4} {5}",
                configProperties.getStringBeforeAegisExpiredTime(),
                aegis,
                configProperties.getStringBeforeRoshanRecoveryLeftTime(),
                roshanRecoveryMinimum,
                configProperties.getStringBeforeRoshanRecoveryRightTime(),
                roshanRecoveryMaximum);
    }

    private String writeZeroIfMsgLenEq1(long num) {
        String numStr = String.valueOf(num);
        return num / 10 >= 1 ? numStr : "0" + numStr;
    }

    private int atoi(char symbol) {
        return symbol - '0';
    }
}
