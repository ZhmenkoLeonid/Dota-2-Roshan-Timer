package com.zhmenko.dotatimer.keyboard;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import com.zhmenko.dotatimer.gsi.DotaGSI;
import com.zhmenko.dotatimer.setting.Config;

import java.awt.*;

public class GlobalKeyboardListener implements NativeKeyListener {
    private Robot rb;
    private final MessageConverter messageConverter;
    private final ClipboardService clipboardService;
    private final DotaGSI dotaGSI;
    private final Config config;

    public GlobalKeyboardListener(Config config, DotaGSI dotaGSI) throws AWTException {
        this.messageConverter = new MessageConverter(config);
        this.dotaGSI = dotaGSI;
        this.config = config;
        clipboardService = new ClipboardService();
        rb = new Robot();
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        // TODO нормальное соответствие кодов символов
        System.out.println("raw:" + NativeKeyEvent.getModifiersText(nativeEvent.getModifiers()) +" char: "+  (int)config.getConfigProperties().getExecChar());

        if (nativeEvent.getKeyCode() == 0xe4e || nativeEvent.getKeyCode() == NativeKeyEvent.VC_EQUALS) {
/*          // ctrl+a
            rb.delay(operationDelay);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_A);
            rb.keyRelease(KeyEvent.VK_A);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            //ctrl+c
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_C);
            rb.keyRelease(KeyEvent.VK_C);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.delay(operationDelay);
            // получаем данные из буфера обмена
            String strFromPyperClip = textTransfer.getData();*/

            // обрабатываем и получаем тайминги
            String resultStr = messageConverter.convert(dotaGSI.getCurrentClockTime());
            // закидываем в буфер обмена
            clipboardService.setData(resultStr);
            //rb.delay(operationDelay);

            // ctrl+v
/*            rb.keyPress(KeyEvent.VK_BACK_SPACE);
            rb.keyRelease(KeyEvent.VK_BACK_SPACE);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);*/
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
    }
}