package BaSeDeVerDad;

import javax.print.attribute.AttributeSetUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends Container {
    ControlPanel(){
        SetUp();
    }
    private void SetUp(){
        setVisible(true);
        setBackground(Color.red);
        this.setLayout(1, 2);
        AddButton("ola", new Color(11111), new ButtonFunction("ola"));
        AddButton("ola2", Color.gray, new ButtonFunction("ola2"));
    }
    public void setLayout(int rows, int cols){
        setLayout(new GridLayout(rows, cols, 50, 50));
    }

    public void AddButton(String text, Color color, ActionListener al ){
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setVisible(true);
        button.addActionListener(al);
        add(button);
        TestLayout();
    }
    private void TestLayout(){
        System.out.println(this.getComponents().length);
    }

}
