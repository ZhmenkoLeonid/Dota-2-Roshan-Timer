package Utils;
import Main.Config;

public class Processing {
    static Config cfg = null;
    public static String run(String str){
        int min = -1;
        int seconds = -1;

        String resultStr;
        if ( str.length() == 5 && str.charAt(0) <= '9' && str.charAt(0) >= '0' && str.charAt(1) <= '9' && str.charAt(1) >= '0'
                && str.charAt(2) <= '9' && str.charAt(2) >= '0' && str.charAt(3) <= '9' && str.charAt(3) >= '0') {
            min = intFromChar(str.charAt(0))* 10 + intFromChar(str.charAt(1));
            seconds = intFromChar(str.charAt(2)) * 10 + intFromChar(str.charAt(3));
        }
        else if ( str.length() == 6 && str.charAt(0) <= '9' && str.charAt(0) >= '0' && str.charAt(1) <= '9' &&
                str.charAt(1) >= '0' && str.charAt(2) <= '9' && str.charAt(2) >= '0' && str.charAt(3) <= '9'
        && str.charAt(3) >= '0' && str.charAt(4) <= '9' & str.charAt(4) >= '0'){
            min = intFromChar(str.charAt(0)) * 100 + intFromChar(str.charAt(1)) * 10 +intFromChar(str.charAt(2));
            seconds = intFromChar(str.charAt(3)) * 10 + intFromChar(str.charAt(4));
        }
        if (min == -1 || seconds == -1){
            return "";
        }
        return buildString(str,min,seconds);
    }
    static String buildString(String str,int min,int seconds){
        String symbBetweenTime;
        if (cfg.usingColon){
            symbBetweenTime = ":";
        } else {
            symbBetweenTime = "";
        }

        String roshan_Killed = WriteZeroIfMsgLenEq1(min) + symbBetweenTime + WriteZeroIfMsgLenEq1(seconds);
        String aegis = WriteZeroIfMsgLenEq1(min + 5) + symbBetweenTime + WriteZeroIfMsgLenEq1(seconds);
        String roshan_Recovery_minimum = WriteZeroIfMsgLenEq1(min + 8) + symbBetweenTime
                + WriteZeroIfMsgLenEq1(seconds);
        String roshan_Recovery_maximum = WriteZeroIfMsgLenEq1(min + 11) + symbBetweenTime
                + WriteZeroIfMsgLenEq1(seconds);

        return cfg.stringBeforeAegisExpiredTime+aegis+cfg.stringBeforeRoshanRecoveryLeftTime+" "
                +roshan_Recovery_minimum+cfg.stringBeforeRoshanRecoveryRightTime+" "+roshan_Recovery_maximum;
    }
    static String WriteZeroIfMsgLenEq1(int num){
        String resultStr = String.valueOf(num);
        if (resultStr.length() == 1){
            return '0'+resultStr;
        }
        return resultStr;
    }
    static int intFromChar(char symb){
        return symb -'0';
    }

    public static void setConfig(Config conf){
        cfg = conf;
    }
}
