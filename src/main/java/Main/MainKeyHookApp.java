import Utils.HookProcess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HINSTANCE;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;

import java.io.*;

public class MainKeyHookApp {
        private static Config config = new Config("","",
                "",true);
    public static void main(String[] args) throws Exception {
        HOOKPROC hookProc = new HookProcess();
        HINSTANCE hInst = Kernel32.INSTANCE.GetModuleHandle(null);

        User32.HHOOK hHook = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, hookProc, hInst, 0);
        if (hHook == null)
            return;
        File appDir = new File(MainKeyHookApp.class.getProtectionDomain().getCodeSource()
                .getLocation().toURI().getPath()).getParentFile();

        User32.MSG msg = new User32.MSG();

        File fileFlag = new File(appDir+"\\dotaTimer.flag");

        if (!fileFlag.exists()) {
            fileFlag.createNewFile();
        }

        File fileConfig = new File(appDir+"\\config.cfg");

        if (!fileConfig.exists()){
            System.err.println("Config file not found! Creating new one...");
            if (!fileConfig.createNewFile()) {
                System.err.println("Error while creating default config file!");
                System.exit(1);
            }
            writeConfigToFile(config,fileConfig);
            System.err.println("Successful creation of default config file!");
        } else {
            config = readConfigFromFile(fileConfig);
        }

        Thread flagCheckThread = new Thread(()->flagCheck(fileFlag));
        flagCheckThread.start();

        while (true) {
            User32.INSTANCE.GetMessage(msg, null, 0, 0);
        }
    }

    private static void flagCheck(File f){
        while(true){
            try {
                if (!f.exists()){
                    System.err.println("Flag file deleted!");
                    System.exit(0);
                }
                Thread.sleep(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static Config readConfigFromFile(File cfgPath) throws IOException {
        FileReader fileConfigReader = new FileReader(cfgPath);
        ObjectMapper mapper = new ObjectMapper();
        Config newConfig = mapper.readValue(fileConfigReader, Config.class);
        return newConfig;
    }

    private static void writeConfigToFile(Config cfg, File cfgPath) throws IOException {
        FileWriter fileConfigWriter = new FileWriter(cfgPath);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(fileConfigWriter,cfg);
        fileConfigWriter.close();
    }

}

