package BaSeDeVerDad.INTERFEIS;


import OldDatabase.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Interfaz extends JFrame {


    StartSession st = new StartSession();

    public Interfaz(Database p) {
        SetUp(p);
    }
    private void SetUp(Database p){
        setResizable(false);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(st);
        setVisible(true);
    }


}