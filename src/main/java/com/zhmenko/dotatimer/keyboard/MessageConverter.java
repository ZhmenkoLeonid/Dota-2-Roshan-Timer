package com.zhmenko.dotatimer.keyboard;

import com.zhmenko.dotatimer.setting.Config;
import com.zhmenko.dotatimer.setting.JsonConfig;

import java.text.SimpleDateFormat;

public class MessageConverter {
    private Config config;
    private SimpleDateFormat simpleDateFormat;

    public MessageConverter(Config config) {
        this.config = config;
        this.simpleDateFormat = new SimpleDateFormat("mmm:ss");
    }

    public String convert(String str) {
        try {
            Integer.parseInt(str, 10);
            return clearConvert(str);
        } catch (NumberFormatException e) {
            return trashConvert(str);
        }
    }

    public String convert(long clockTimeSeconds) {
        //                                                  Учитываем задержку сервера GSI
        //                                                                        |
        //                                                                        v
        return buildString(clockTimeSeconds / 60, (clockTimeSeconds + 1) % 60 );
    }

    @Deprecated
    private String trashConvert(String str) {
        int min = -1;
        int seconds = -1;

        String resultStr;
        if (str.length() == 5 && str.charAt(0) <= '9' && str.charAt(0) >= '0'
                && str.charAt(1) <= '9' && str.charAt(1) >= '0'
                && str.charAt(2) <= '9' && str.charAt(2) >= '0' && str.charAt(3)
                <= '9' && str.charAt(3) >= '0') {
            min = intFromChar(str.charAt(0)) * 10 + intFromChar(str.charAt(1));
            seconds = intFromChar(str.charAt(2)) * 10 + intFromChar(str.charAt(3));
        } else if (str.length() == 6 && str.charAt(0) <= '9' && str.charAt(0)
                >= '0' && str.charAt(1) <= '9' &&
                str.charAt(1) >= '0' && str.charAt(2) <= '9' && str.charAt(2)
                >= '0' && str.charAt(3) <= '9'
                && str.charAt(3) >= '0' && str.charAt(4) <= '9' & str.charAt(4) >= '0') {
            min = intFromChar(str.charAt(0)) * 100 + intFromChar(str.charAt(1)) * 10
                    + intFromChar(str.charAt(2));
            seconds = intFromChar(str.charAt(3)) * 10 + intFromChar(str.charAt(4));
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

        String resultStr;
        if (str.length() == 4 && str.charAt(0) <= '9' && str.charAt(0) >= '0'
                && str.charAt(1) <= '9' && str.charAt(1) >= '0'
                && str.charAt(2) <= '9' && str.charAt(2) >= '0' && str.charAt(3)
                <= '9' && str.charAt(3) >= '0') {
            min = intFromChar(str.charAt(0)) * 10 + intFromChar(str.charAt(1));
            seconds = intFromChar(str.charAt(2)) * 10 + intFromChar(str.charAt(3));
        } else if (str.length() == 5 && str.charAt(0) <= '9' && str.charAt(0)
                >= '0' && str.charAt(1) <= '9' &&
                str.charAt(1) >= '0' && str.charAt(2) <= '9' && str.charAt(2)
                >= '0' && str.charAt(3) <= '9'
                && str.charAt(3) >= '0' && str.charAt(4) <= '9' & str.charAt(4) >= '0') {
            min = intFromChar(str.charAt(0)) * 100 + intFromChar(str.charAt(1)) * 10
                    + intFromChar(str.charAt(2));
            seconds = intFromChar(str.charAt(3)) * 10 + intFromChar(str.charAt(4));
        }
        if (min == -1 || seconds == -1) {
            return "";
        }
        return buildString(min, seconds);
    }

    public String buildString(long min, long seconds) {
        String symbBetweenTime = config.getJsonConfig().getUsingColon() ? ":" : "";

        String roshan_Killed = writeZeroIfMsgLenEq1(min) + symbBetweenTime
                + writeZeroIfMsgLenEq1(seconds);
        String aegis = writeZeroIfMsgLenEq1(min + 5) + symbBetweenTime
                + writeZeroIfMsgLenEq1(seconds);
        String roshan_Recovery_minimum = writeZeroIfMsgLenEq1(min + 8) + symbBetweenTime
                + writeZeroIfMsgLenEq1(seconds);
        String roshan_Recovery_maximum = writeZeroIfMsgLenEq1(min + 11) + symbBetweenTime
                + writeZeroIfMsgLenEq1(seconds);
        JsonConfig jsonConfig = config.getJsonConfig();

        return new StringBuilder()
                .append(jsonConfig.getStringBeforeAegisExpiredTime()).append(aegis)
                .append(jsonConfig.getStringBeforeRoshanRecoveryLeftTime())
                .append(" ")
                .append(roshan_Recovery_minimum)
                .append(jsonConfig.getStringBeforeRoshanRecoveryRightTime())
                .append(" ")
                .append(roshan_Recovery_maximum)
                .toString();
    }

    private String writeZeroIfMsgLenEq1(long num) {
        String resultStr = String.valueOf(num);
        if (resultStr.length() == 1) {
            return '0' + resultStr;
        }
        return resultStr;
    }

    private int intFromChar(char symb) {
        return symb - '0';
    }

    public void setConfig(Config conf) {
        config = conf;
    }
}
