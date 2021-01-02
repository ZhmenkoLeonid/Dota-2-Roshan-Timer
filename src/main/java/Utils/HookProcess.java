package Utils;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class HookProcess implements WinUser.HOOKPROC {
    Robot rb = new Robot();
    TextTransfer textTransfer = new TextTransfer();
    public HookProcess() throws AWTException {
    }

    public WinDef.LRESULT callback(int nCode, WinDef.WPARAM wParam, WinUser.KBDLLHOOKSTRUCT info) throws IOException, UnsupportedFlavorException {
        if (info.vkCode == 107 && wParam.intValue() == WinUser.WM_KEYDOWN){
            // ctrl+a
            rb.delay(300);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_A);
            rb.keyRelease(KeyEvent.VK_A);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            //ctrl+c
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_C);
            rb.keyRelease(KeyEvent.VK_C);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.delay(100);
            // получаем данные из буфера обмена
            String strFromPyperClip = textTransfer.getData();
            // обрабатываем и получаем тайминги
            String resultStr = Processing.run(strFromPyperClip);
            // закидываем в буфер обмена
            textTransfer.setData(resultStr);
            rb.delay(100);
            // ctrl+v
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
        }
        return new WinDef.LRESULT(0);
    }
}