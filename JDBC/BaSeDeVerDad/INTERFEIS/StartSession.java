package BaSeDeVerDad.INTERFEIS;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartSession extends JPanel {
    JPanel data, buttons;
    JLabel tittle, errors;
    JButton login, register;
    JLabel username, password;
    JTextField user, pass;
    StartSession(){
        setPreferredSize(new Dimension(500,300));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.tittle = new JLabel("Login");
        add(Box.createRigidArea(new Dimension(1,30)));
        this.add(tittle);
        tittle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(1,50)));

        data = new JPanel();
        data.setPreferredSize(new Dimension(100,110));
        data.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
        data.setLayout(new GridLayout(2,2, 10,10));
        add(data);
        username = new JLabel("USERNAME: ");
        data.add(username);
        password = new JLabel("PASSWORD: ");
        data.add(password);
        user = new JTextField();
        data.add(user);
        pass = new JTextField();
        data.add(pass);
        errors = new JLabel("     ");
        add(errors);
        errors.setVisible(false);
        add(Box.createRigidArea(new Dimension(1,60)));

        buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        login = new JButton("Login");
        register = new JButton("Register");
        buttons.add(Box.createRigidArea(new Dimension(300,1)));
        buttons.add(login);
        buttons.add(Box.createRigidArea(new Dimension(30,1)));
        buttons.add(register);
        add(buttons);
        setActionerLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(((JButton)actionEvent.getSource()).getText());

                errors.setText("Hola, " + user.getText());
                errors.setVisible(true);
                System.out.println("USER: " + user.getText());
                System.out.println("PASS: " + pass.getText());
            }
        });
        setActionerRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(((JButton)actionEvent.getSource()).getText());
                getsize();

            }
        });
    }
private void getsize(){
    Dimension d = getSize();
    System.out.println(" h: " + d.height + " w: " + d.width);
}
    public void setActionerLogin(ActionListener e){
        this.login.addActionListener(e);
    }
    public void setActionerRegister(ActionListener e){
        this.register.addActionListener(e);
    }
}
