/**
 * Created by Arsen on 10.08.2017.
 */
public class DelegateApp {
    public static void main(String[] args) {

        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Treangle());
        painter.draw();
    }
}

interface Graphics {
    void draw();
}

class Treangle implements Graphics {

    @Override
    public void draw() {
        System.out.println("Рисуем треуголнник");
    }
}

class Square implements Graphics {

    @Override
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}

class Circle implements Graphics {

    @Override
    public void draw() {
        System.out.println("Рисуем треуголнник");
    }


}


class Painter {
    Graphics graphics;

    void setGraphics(Graphics g) {
        graphics = g;
    }

    void draw() {
        graphics.draw();
    }
}