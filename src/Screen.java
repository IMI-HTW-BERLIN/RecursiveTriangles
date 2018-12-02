import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Screen extends JPanel {
    private int minimumWidth = 50;


    Screen() {
        repaint();
    }

    public void paint(Graphics g) {
        int temp = (int) (getHeight() / Math.sqrt(3) * 2);
        int width = (getWidth() > temp) ? temp : getWidth();
        g.drawPolygon(setUp(new Point(0, getHeight()), width));
        g.drawPolygon(triangle(new Point(0, getHeight()), width, g));

    }

    private Polygon setUp(Point p, int width) {
        Polygon polygon = new Polygon();
        polygon.addPoint(p.x, p.y);
        polygon.addPoint(p.x + width, p.y);
        polygon.addPoint(p.x + width / 2, p.y - (int) (width / 2 * Math.sqrt(3)));
        return polygon;

    }

    private Polygon triangle(Point p, int width, Graphics g) {
        Polygon polygon = new Polygon();
        int height = p.y - (int) (width / 2 * Math.sqrt(3));
        Point center = centerOf(p, new Point(p.x + width / 2, height));

        polygon.addPoint(p.x + width / 2, p.y);
        polygon.addPoint(center.x, center.y);
        polygon.addPoint(center.x + width / 2, center.y);

        if (width > minimumWidth) {
            g.drawPolygon(triangle(new Point(centerOf(p, new Point(p.x + width / 2, height))), width / 2, g));
            g.drawPolygon(triangle(new Point(p.x, p.y), width / 2, g));
            g.drawPolygon(triangle(new Point(p.x + width / 2, p.y), width / 2, g));
        }
        g.setColor(Color.BLACK);
        g.fillPolygon(polygon);
        return polygon;

    }

    private Point centerOf(Point p1, Point p2) {
        int x = Math.round((float) (p1.x + p2.x) / 2);
        int y = (p1.y + p2.y) / 2;
        return new Point(x, y);
    }

    private Color level(int factor) {
        return new Color(1000000000+33333*factor);
    }

    private Color random() {
        return new Color(new Random().nextInt(0xFFFFFF));
    }

    void setMinimumWidth(int minimumWidth){
        this.minimumWidth = minimumWidth;
    }
}
