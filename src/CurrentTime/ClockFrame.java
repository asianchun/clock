package CurrentTime;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ClockFrame extends JFrame {

    private SimpleDateFormat timeFormat; //Formats the date i.e. am/pm, 12/24hr and etc.
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private JLabel timeLabel;
    private JLabel dayLabel;
    private JLabel dateLabel;
    private String time;
    private String day;
    private String date;

    ClockFrame(){
        //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("E"); //E - abr.; EEEE - full name
        dateFormat = new SimpleDateFormat("dd MMMMM, yyyy"); //MM - number month; MMMMM - name month

        timeLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();

        timeLabel.setFont(new Font("Verdana",Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aus clock");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setVisible(true);

        setTime();
    }

    private void setTime(){
        while (true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            day = dayFormat.format(Calendar.getInstance().getTime());
            date = dateFormat.format(Calendar.getInstance().getTime());

            timeLabel.setText(time);
            dayLabel.setText(day);
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
