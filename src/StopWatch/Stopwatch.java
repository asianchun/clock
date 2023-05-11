package StopWatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame implements ActionListener {

    private JButton startStop;
    private JButton reset;
    private JLabel time;
    private int totalTime;
    private int hours;
    private int minutes;
    private int seconds;
    private String hoursString;
    private String minutesString;
    private String secondsString;
    private boolean started;
    private Timer timer;

    Stopwatch(){
        time = new JLabel();
        time.setFont(new Font("Verdana",Font.PLAIN, 35));
        time.setBounds(100,100,200,100);
        time.setBorder(BorderFactory.createBevelBorder(1));
        time.setOpaque(true);
        time.setHorizontalAlignment(JTextField.CENTER);

        started = false;
        stopwatchSetup();

        startStop = new JButton("START");
        startStop.setFocusable(false);
        startStop.setBounds(100,200,100,50);
        startStop.setFont(new Font("Ink Free",Font.PLAIN, 20));
        startStop.addActionListener(this);

        reset = new JButton("RESET");
        reset.setFocusable(false);
        reset.setBounds(200,200,100,50);
        reset.setFont(new Font("Ink Free",Font.PLAIN, 20));
        reset.addActionListener(this);

        this.add(time);
        this.add(startStop);
        this.add(reset);

        this.setTitle("Stopwatch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(400,400);
        this.setVisible(true);

        timer = new Timer(1000, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                totalTime+=1000;
                hours = totalTime/3600000;
                minutes = (totalTime/60000) % 60;
                seconds = (totalTime/1000) % 60;

                secondsString = String.format("%02d", seconds);
                minutesString = String.format("%02d", minutes);
                hoursString = String.format("%02d", hours);
                time.setText(String.format("%s:%s:%s", hoursString, minutesString, secondsString));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startStop){
            if (!started){
                timer.start();
                startStop.setText("STOP");
                started = true;
            }
            else {
                timer.stop();
                startStop.setText("START");
                started = false;
            }

        }
        else if (e.getSource() == reset){
            timer.stop();
            startStop.setText("START");
            started = false;

            stopwatchSetup();
        }
    }

    public void stopwatchSetup(){
        totalTime = 0;
        hours = 0;
        minutes = 0;
        seconds = 0;

        hoursString = String.format("%02d", hours);
        minutesString = String.format("%02d", minutes);
        secondsString = String.format("%02d", seconds);

        time.setText(String.format("%s:%s:%s", hoursString, minutesString, secondsString));
    }
}
