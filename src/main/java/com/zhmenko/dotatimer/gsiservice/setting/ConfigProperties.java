package com.zhmenko.dotatimer.gsiservice.setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigProperties {
    private String stringBeforeAegisExpiredTime;
    private String stringBeforeRoshanRecoveryLeftTime;
    private String stringBeforeRoshanRecoveryRightTime;
    private boolean usingColon;
    private Character execChar;

    public ConfigProperties(ConfigProperties configProperties) {
        this.stringBeforeAegisExpiredTime = configProperties.getStringBeforeAegisExpiredTime();
        this.stringBeforeRoshanRecoveryLeftTime = configProperties.getStringBeforeRoshanRecoveryLeftTime();
        this.stringBeforeRoshanRecoveryRightTime = configProperties.getStringBeforeRoshanRecoveryRightTime();
        this.usingColon = configProperties.isUsingColon();
        this.execChar = configProperties.getExecChar();
    }

    public void setConfigProperties(ConfigProperties configProperties) {
        this.stringBeforeAegisExpiredTime = configProperties.getStringBeforeAegisExpiredTime();
        this.stringBeforeRoshanRecoveryLeftTime = configProperties.getStringBeforeRoshanRecoveryLeftTime();
        this.stringBeforeRoshanRecoveryRightTime = configProperties.getStringBeforeRoshanRecoveryRightTime();
        this.usingColon = configProperties.isUsingColon();
        this.execChar = configProperties.getExecChar();
    }
}
