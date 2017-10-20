package com.kramator.main;

import javax.swing.*;
import java.awt.*;

class ButtonCreater extends JButton {

    ButtonCreater(String nameButton, int X, int Y, int width, int height, int size) {
        super(nameButton);
        this.setFont(new Font("Tahoma", Font.PLAIN, size));
        this.setBounds(X, Y, width, height);
        this.requestFocus();
    }



}
