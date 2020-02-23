import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;


public class SlideShow {

    Timer tm;
    int x = 0;
    File[] pic;
    Birthday bday;
    
    public SlideShow(Birthday c) {

        bday = c;

        File folder = new File("res");
        pic = folder.listFiles();

        tm = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                if(x >= pic.length) x = 0;
                //bday.frame.setContentPane(new JLabel(new ImageIcon(pic[x].toString())));
            }
        });

        System.out.println(pic[x]);
        tm.start();
    }

}