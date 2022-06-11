package com.zhmenko.dotatimer.fileflag;

import java.io.File;

public class FlagThread extends Thread {
    File flagFile;
    long frequency;

    public FlagThread(File flagFile, long frequency) {
        this.flagFile = flagFile;
        this.frequency = frequency;
    }

    @Override
    public void run() {
        try {
            if (!flagFile.exists()) {
                flagFile.createNewFile();
            }
            while (true) {

                if (!flagFile.exists()) {
                    System.err.println("Flag file deleted!");
                    System.exit(0);
                }
                Thread.sleep(frequency);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
