import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    Dimension dimension;

    public Screen(Dimension dimension) {
        this.dimension = dimension;
        repaint();
    }

    public void paint(Graphics g) {
        g.drawPolygon(triangle());
    }

    private Polygon triangle() {
        Polygon polygon = new Polygon();
        int height,width = 0;
        if(dimension.width > dimension.height) {
            width = dimension.height;
            height = (int) (dimension.height / 2 * Math.sqrt(3));
        }else {
            width = dimension.width;
            height = (int) (dimension.width / 2 * Math.sqrt(3));
        }
        polygon.addPoint(0,0);
        polygon.addPoint(width,0);
        polygon.addPoint(width/2, height);
        return polygon;
    }

}