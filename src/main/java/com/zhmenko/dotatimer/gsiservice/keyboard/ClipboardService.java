package com.zhmenko.dotatimer.gsiservice.keyboard;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class ClipboardService implements ClipboardOwner {
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }

    public void setData(String data){
        StringSelection stringSelection = new StringSelection(data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
    }

    public String getData() throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }
}