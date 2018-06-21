import javax.swing.*;
import java.awt.*;

public class Triangles {
    private JFrame frame;
    private Screen screen;

    public Triangles() {
        frame = new JFrame();
        frame.setSize(500, 500);
        screen = new Screen(new Dimension(frame.getWidth(),frame.getHeight()));
        screen.setLayout(new GridLayout(1,1,0,0));
        frame.add(screen);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Triangles();
    }

}
