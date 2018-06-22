import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    Boolean firstTime = true;


    public Screen() {
        repaint();
    }

    public void paint(Graphics g) {
        int width = (getWidth() > (getHeight() / Math.sqrt(3) * 2)) ? (int) (getHeight() / Math.sqrt(3) * 2) : getWidth();
        g.drawPolygon(setUp(new Point(0,getHeight()),width,g));
        g.drawPolygon(triangle(new Point(0,getHeight()),width,g));

    }

    private Polygon setUp(Point p, int width, Graphics g) {
        Polygon polygon = new Polygon();
        polygon.addPoint(p.x,p.y);
        polygon.addPoint(p.x+width,p.y);
        polygon.addPoint(p.x+width/2, p.y-(int) (width/2*Math.sqrt(3)));
        return polygon;

    }

    private Polygon triangle(Point p, int width, Graphics g) {
        Polygon polygon = new Polygon();
        int height = p.y - (int) (width / 2 * Math.sqrt(3));
        Point center = centerOf(p, new Point(p.x + width / 2, height));

        polygon.addPoint(p.x + width / 2, p.y);
        polygon.addPoint(center.x, center.y);
        polygon.addPoint(center.x + width/2, center.y);

        if (width > 50) {
            g.drawPolygon(triangle(new Point(centerOf(p, new Point(p.x+width / 2, height))), width / 2,g));
            g.drawPolygon(triangle(new Point(p.x, p.y), width / 2,g));
            g.drawPolygon(triangle(new Point(p.x + width / 2, p.y), width / 2,g));
        }

        return polygon;

    }

    private Point centerOf (Point p1, Point p2) {
        Point c = new Point();
        int x = Math.round((float) (p1.x+p2.x)/2);
        int y = (p1.y+p2.y)/2;
        c.setLocation(x,y);
        return c;
    }

    private Polygon triangleOpt1 (Point p, int width, Graphics g) {
        Polygon polygon = new Polygon();
        polygon.addPoint(p.x,p.y);
        polygon.addPoint(p.x+width,p.y);
        polygon.addPoint(p.x+width/2, p.y-(int) (width/2*Math.sqrt(3)));

        if(width > 100) {
            int height = p.y - (int) (width / 2 * Math.sqrt(3));
            g.drawPolygon(triangleOpt1(new Point(centerOf(p, new Point(p.x+width / 2, height))), width / 2,g));
            g.drawPolygon(triangleOpt1(new Point(p.x, p.y), width / 2,g));
            g.drawPolygon(triangleOpt1(new Point(p.x + width / 2, p.y), width / 2,g));
        }

        return polygon;
    }


}