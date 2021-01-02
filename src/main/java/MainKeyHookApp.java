import Utils.HookProcess;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HINSTANCE;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;

import java.io.File;

public class MainKeyHookApp {

    public MainKeyHookApp() {
    }

    public static void main(String[] args) throws Exception {
        HOOKPROC hookProc = new HookProcess();
        HINSTANCE hInst = Kernel32.INSTANCE.GetModuleHandle(null);

        User32.HHOOK hHook = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, hookProc, hInst, 0);
        if (hHook == null)
            return;
        User32.MSG msg = new User32.MSG();
        File file = new File(new File(MainKeyHookApp.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile()+"\\dotaTimer.flag");
        //FileWriter fileWriter = new FileWriter("C:\\Users\\zmenk\\OneDrive\\Рабочий стол\\1.txt");
        //fileWriter.write(new File(MainTestKeyHook.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile()+"\\dotaTimer.flag");
        //fileWriter.close();
        file.createNewFile();

        new Thread(()->{
            while(true){
                try {
                    if (!file.exists()){
                        System.err.println("Flag file deleted!");
                        System.exit(1);
                    }
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            User32.INSTANCE.GetMessage(msg, null, 0, 0);
        }
    }
}

