import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;


public class SlideShow {

    Timer tm;
    int x = 0;
    
    public SlideShow(Display c) {

        File folder = new File("res");
        File[] pictures = folder.listFiles();

        tm = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                if(x >= pictures.length) x = 0;
                c.frame.setContentPane(new JLabel(new ImageIcon(pictures[x].toString())));
            }
        });

        System.out.println(pictures[x]);
        tm.start();
    }

}