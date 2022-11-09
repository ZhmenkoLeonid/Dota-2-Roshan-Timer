package com.zhmenko.dotatimer.keyboard;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import com.zhmenko.dotatimer.gsi.DotaGSIServerWrapper;
import com.zhmenko.dotatimer.keyboard.mapper.KeyCharMapper;
import com.zhmenko.dotatimer.setting.Config;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalKeyboardListener implements NativeKeyListener {
    private final MessageConverter messageConverter;
    private final ClipboardService clipboardService;
    private final DotaGSIServerWrapper dotaGSIServerWrapper;
    private final Config config;

    public GlobalKeyboardListener(Config config, DotaGSIServerWrapper dotaGSIServerWrapper) {
        this.messageConverter = new MessageConverter(config);
        this.dotaGSIServerWrapper = dotaGSIServerWrapper;
        this.config = config;
        clipboardService = new ClipboardService();
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        // TODO нормальное соответствие кодов символов
        //System.out.println("raw:" + nativeEvent.getKeyCode() +" char: "+  (int)config.getConfigProperties().getExecChar());
        Character configChar = config.getConfigProperties().getExecChar();
        Character inputChar = KeyCharMapper.map(nativeEvent.getKeyCode());
        //log.debug("Получен код: \"" + nativeEvent.getKeyCode() + "\"");
        if (inputChar != null && inputChar == configChar) {
            log.debug("Вызван запуск. Клавиша: \"" + configChar + "\"");
            // обрабатываем и получаем тайминги
            String resultStr = messageConverter.convert(dotaGSIServerWrapper.getCurrentClockTime());
            // закидываем в буфер обмена
            clipboardService.setData(resultStr);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
    }
}