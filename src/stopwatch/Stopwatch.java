package stopwatch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch{
    Timer timer = new Timer(this);
    Thread t;
    int flag = 0;
    public JPanel mainPanel;
    private JTextField hourTF;
    private JTextField minTF;
    private JTextField secTF;
    private JButton startButton;
    private JButton pauseButton;
    private JButton lapButton;
    private JButton stopButton;
    private JTextArea lapTA;

    public void setTimer(int hr,int min,int sec) {
        hourTF.setText("" + hr);
        minTF.setText("" + min);
        secTF.setText("" + sec);
    }
    public Stopwatch(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t = new Thread(timer);
                t.start();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag==0) {
                    t.suspend();
                    pauseButton.setText("Resume");
                    flag = 1;
                }
                else if(flag==1) {
                    t.resume();
                    pauseButton.setText("Pause");
                    flag=0;
                }
            }
        });
        lapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lap  = hourTF.getText()+" "+minTF.getText()+" "+secTF.getText()+"\n";
                lapTA.append(lap);

            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
                setTimer(0,0,0);
            }
        });
    }
}


