package com.zhmenko.dotatimer.keyboard.mapper;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.util.HashMap;
import java.util.Map;

public class KeyCharMapper {
    private static Map<Integer, Character> keyCharMap;

    public static Character map(int charCode) {
        if (keyCharMap == null) init();
        return keyCharMap.getOrDefault(charCode, null);
    }

    private static void init() {
        keyCharMap = new HashMap<>();
        keyCharMap.put(NativeKeyEvent.VC_A, 'a');
        keyCharMap.put(NativeKeyEvent.VC_B, 'b');
        keyCharMap.put(NativeKeyEvent.VC_C, 'c');
        keyCharMap.put(NativeKeyEvent.VC_D, 'd');
        keyCharMap.put(NativeKeyEvent.VC_E, 'e');
        keyCharMap.put(NativeKeyEvent.VC_F, 'f');
        keyCharMap.put(NativeKeyEvent.VC_G, 'g');
        keyCharMap.put(NativeKeyEvent.VC_H, 'h');
        keyCharMap.put(NativeKeyEvent.VC_I, 'i');
        keyCharMap.put(NativeKeyEvent.VC_J, 'j');
        keyCharMap.put(NativeKeyEvent.VC_K, 'k');
        keyCharMap.put(NativeKeyEvent.VC_L, 'l');
        keyCharMap.put(NativeKeyEvent.VC_M, 'm');
        keyCharMap.put(NativeKeyEvent.VC_N, 'n');
        keyCharMap.put(NativeKeyEvent.VC_O, 'o');
        keyCharMap.put(NativeKeyEvent.VC_P, 'p');
        keyCharMap.put(NativeKeyEvent.VC_Q, 'q');
        keyCharMap.put(NativeKeyEvent.VC_R, 'r');
        keyCharMap.put(NativeKeyEvent.VC_S, 's');
        keyCharMap.put(NativeKeyEvent.VC_T, 't');
        keyCharMap.put(NativeKeyEvent.VC_U, 'u');
        keyCharMap.put(NativeKeyEvent.VC_V, 'v');
        keyCharMap.put(NativeKeyEvent.VC_W, 'w');
        keyCharMap.put(NativeKeyEvent.VC_X, 'x');
        keyCharMap.put(NativeKeyEvent.VC_Y, 'y');
        keyCharMap.put(NativeKeyEvent.VC_Z, 'z');

        keyCharMap.put(NativeKeyEvent.VC_0, '0');
        keyCharMap.put(NativeKeyEvent.VC_1, '1');
        keyCharMap.put(NativeKeyEvent.VC_2, '2');
        keyCharMap.put(NativeKeyEvent.VC_3, '3');
        keyCharMap.put(NativeKeyEvent.VC_4, '4');
        keyCharMap.put(NativeKeyEvent.VC_5, '5');
        keyCharMap.put(NativeKeyEvent.VC_6, '6');
        keyCharMap.put(NativeKeyEvent.VC_7, '7');
        keyCharMap.put(NativeKeyEvent.VC_8, '8');
        keyCharMap.put(NativeKeyEvent.VC_9, '9');

        keyCharMap.put(NativeKeyEvent.VC_EQUALS, '=');
        keyCharMap.put(NativeKeyEvent.VC_MINUS, '-');
        keyCharMap.put(NativeKeyEvent.VC_BACKQUOTE, '`');
        keyCharMap.put(NativeKeyEvent.VC_SPACE, ' ');
        keyCharMap.put(NativeKeyEvent.VC_COMMA, ',');
        keyCharMap.put(NativeKeyEvent.VC_PERIOD, '.');
        keyCharMap.put(NativeKeyEvent.VC_SLASH, '/');
        keyCharMap.put(NativeKeyEvent.VC_BACK_SLASH, '\\');
        keyCharMap.put(NativeKeyEvent.VC_SEMICOLON, ';');
        keyCharMap.put(NativeKeyEvent.VC_QUOTE, '\'');

        // Numpad '+'
        keyCharMap.put(0xe4e, '+');
        // Numpad '.'
        keyCharMap.put(83, '.');
        // Numpad '*'
        keyCharMap.put(3639, '*');
    }
}
