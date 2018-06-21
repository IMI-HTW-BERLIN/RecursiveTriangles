import java.awt.*;

public interface Canvas {
        void setVisible(boolean visible);

        void drawShape(Shape shape);

        void fill(Shape shape);

        void erase();

        void setColor(Color color);

        Color getColor();

        void setBackground(Color color);

        Color getBackground();
}
