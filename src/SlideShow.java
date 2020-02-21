import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;


public class SlideShow extends Birthday {

    private static final long serialVersionUID = 1L;

    Timer tm;
    int x = 0;
    File[] pic;
    
    public SlideShow() {

        File folder = new File("res");
        pic = folder.listFiles();

        tm = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //SetImageSize(x);
                x++;
                if(x >= getFileSize()) x = 0; 
            }
        });

        System.out.println(getFileSize());

        frame.setContentPane(new JLabel(new ImageIcon(pic[x].toString())));
        tm.start();
    }

    private int getFileSize() {
        
        if(pic == null) return 0;

        return pic.length;
    }

}