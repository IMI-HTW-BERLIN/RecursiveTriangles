import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Triangles {
    private Screen screen;

    private Triangles() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen = new Screen();
        screen.setMaximum(25);
        screen.setPreferredSize(new Dimension(600,500));
        screen.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                screen.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }

        });

        JSlider size = new JSlider(JSlider.HORIZONTAL,1,1000,100);
        size.addChangeListener(e -> {
            screen.setMaximum(size.getValue());
            screen.repaint();
        });


        frame.add(screen);
        frame.add(size,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        screen.repaint();

    }

    public static void main(String[] args) {
        new Triangles();
    }

}
