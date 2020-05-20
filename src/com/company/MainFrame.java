package com.company;

import com.company.Packet.BossFrame;

public class MainFrame {
    public static BossFrame frame;

    public static void main(String[] args) {
        frame = new BossFrame();
        frame.setVisible(true);
    }
}
