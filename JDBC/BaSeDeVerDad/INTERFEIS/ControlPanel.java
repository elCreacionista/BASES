package BaSeDeVerDad.INTERFEIS;

import javax.print.attribute.AttributeSetUtilities;
import javax.swing.*;
import java.awt.*;

public class ControlPanel extends Container {
    ControlPanel(int rows, int cols){
        SetUp();
        setLayout(new GridLayout(rows, cols));
    }
    private void SetUp(){
        setVisible(true);
        setBackground(Color.lightGray);
    }
    public void setLayout(int rows, int cols){
        setLayout(new GridLayout(rows, cols));
    }

    public void AddButton(String text, Color color){
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setVisible(true);
        add(button);
    }

}
