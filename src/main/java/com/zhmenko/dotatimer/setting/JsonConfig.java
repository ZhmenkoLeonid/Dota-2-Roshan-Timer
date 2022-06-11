package com.zhmenko.dotatimer.setting;

public class JsonConfig {
    private String stringBeforeAegisExpiredTime;
    private String stringBeforeRoshanRecoveryLeftTime;
    private String stringBeforeRoshanRecoveryRightTime;
    private String execChar;
    private boolean usingColon;

    public String getStringBeforeAegisExpiredTime() {
        return stringBeforeAegisExpiredTime;
    }

    public void setStringBeforeAegisExpiredTime(String stringBeforeAegisExpiredTime) {
        this.stringBeforeAegisExpiredTime = stringBeforeAegisExpiredTime;
    }

    public String getStringBeforeRoshanRecoveryLeftTime() {
        return stringBeforeRoshanRecoveryLeftTime;
    }

    public void setStringBeforeRoshanRecoveryLeftTime(String stringBeforeRoshanRecoveryLeftTime) {
        this.stringBeforeRoshanRecoveryLeftTime = stringBeforeRoshanRecoveryLeftTime;
    }

    public String getStringBeforeRoshanRecoveryRightTime() {
        return stringBeforeRoshanRecoveryRightTime;
    }

    public void setStringBeforeRoshanRecoveryRightTime(String stringBeforeRoshanRecoveryRightTime) {
        this.stringBeforeRoshanRecoveryRightTime = stringBeforeRoshanRecoveryRightTime;
    }

    public String getExecChar() {
        return execChar;
    }

    public void setExecChar(String execChar) {
        this.execChar = execChar;
    }

    public boolean getUsingColon() {
        return usingColon;
    }

    public void setUsingColon(boolean usingColon) {
        this.usingColon = usingColon;
    }
}
