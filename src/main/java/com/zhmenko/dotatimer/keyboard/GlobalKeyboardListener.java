package com.zhmenko.dotatimer.keyboard;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import com.zhmenko.dotatimer.gsi.DotaGSI;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GlobalKeyboardListener implements NativeKeyListener {
    private Robot rb;
    private MessageConverter messageConverter;
    private ClipboardService clipboardService;
    private DotaGSI dotaGSI;

    private int operationDelay;

    public GlobalKeyboardListener(MessageConverter messageConverter, DotaGSI dotaGSI) throws AWTException {
        this.messageConverter = messageConverter;
        this.operationDelay = 200;
        this.dotaGSI = dotaGSI;

        clipboardService = new ClipboardService();
        rb = new Robot();
    }

    public GlobalKeyboardListener(MessageConverter messageConverter, int operationDelay) throws AWTException {
        this.messageConverter = messageConverter;
        this.operationDelay = operationDelay;

        clipboardService = new ClipboardService();
        rb = new Robot();
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        if (nativeEvent.getKeyCode() == 0xe4e) {
/*            // ctrl+a
            rb.delay(operationDelay);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_A);
            rb.keyRelease(KeyEvent.VK_A);
            rb.keyRelease(KeyEvent.VK_CONTROL);+
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
            rb.keyPress(KeyEvent.VK_BACK_SPACE);
            rb.keyRelease(KeyEvent.VK_BACK_SPACE);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
    }
}