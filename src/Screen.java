import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    Dimension dimension;

    public Screen() {
        repaint();
    }

    public void paint(Graphics g) {
        g.drawPolygon(triangle());
    }

    private Polygon triangle() {
        Dimension dimension = getSize();
        Polygon polygon = new Polygon();
        int height,width = 0;
        if(dimension.width > dimension.height) {
            width = dimension.height;
            height = (int) (dimension.height / 2 * Math.sqrt(3));
        }else {
            width = dimension.width;
            height = (int) (dimension.width / 2 * Math.sqrt(3));
        }
        polygon.addPoint(0, height);
        polygon.addPoint(width / 2,0);
        polygon.addPoint(width, height);
        return polygon;
    }

}