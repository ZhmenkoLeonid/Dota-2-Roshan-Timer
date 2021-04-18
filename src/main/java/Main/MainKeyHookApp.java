package Main;

import Utils.HookProcess;
import Utils.Processing;
import Utils.Servlet;
import Utils.ServletThread;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HINSTANCE;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;

import java.io.*;
import java.net.ServerSocket;

import static Main.Config.setConfigFromFile;
import static Main.Config.writeConfigToFile;

public class MainKeyHookApp {
        private static Config config;
    public static void main(String[] args) throws Exception {
        System.setErr(new PrintStream(new File("log.txt")));
        User32.MSG msg = new User32.MSG();
        File appDir = new File(MainKeyHookApp.class.getProtectionDomain().getCodeSource()
                .getLocation().toURI().getPath()).getParentFile();
        File fileFlag = new File(appDir+"\\dotaTimer.flag");
        File fileConfig = new File(appDir+"\\config.cfg");

        if (!fileConfig.exists()){
            System.err.println("Main Config file not found! Creating new one...");
            if (!fileConfig.createNewFile()) {
                System.err.println("Error while creating default config file!");
                System.exit(1);
            }


        // set default settings
        config = new Config("","","",true,"+");
        writeConfigToFile(config,fileConfig);
        System.err.println("Successful creation of default config file!");
    } else {
        config = setConfigFromFile(fileConfig);
        System.out.println("Successful read from config!");
    }
        Processing.setConfig(config);
        HOOKPROC hookProc = new HookProcess();
        HINSTANCE hInst = Kernel32.INSTANCE.GetModuleHandle(null);
        User32.HHOOK hHook = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, hookProc, hInst, 0);
        if (hHook == null)
            return;

        Thread flagCheckThread = new Thread(()-> {
            try {
                flagCheck(fileFlag);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        flagCheckThread.start();

        //ServletThread servletThread = new ServletThread();
        //servletThread.run();
        while (true) {
            User32.INSTANCE.GetMessage(msg, null, 0, 0);
        }
    }

    private static void flagCheck(File f) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
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
}

