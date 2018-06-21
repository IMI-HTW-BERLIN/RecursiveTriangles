import javax.swing.*;
import java.awt.*;

public class CustomCanvas implements Canvas{
    private Graphics2D g;
    private JFrame frame;
    private JPanel panel;

    public CustomCanvas(int width, int height) {
        frame = new JFrame();
        panel = new JPanel();
        frame.setContentPane(panel);
        panel.setPreferredSize(new Dimension(width, height));
        frame.pack();
    }

    @Override
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    @Override
    public void drawShape(Shape shape) {
        g.draw(shape);
        frame.repaint();
    }

    @Override
    public void fill(Shape shape) {

    }

    @Override
    public void erase() {

    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setBackground(Color color) {

    }

    @Override
    public Color getBackground() {
        return null;
    }
}
