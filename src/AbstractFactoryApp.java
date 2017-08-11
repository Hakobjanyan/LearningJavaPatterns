/**
 * Created by Arsen on 11.08.2017.
 */

/***
 * Abstract Factory
 */
public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCoutryCode("EN");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();

        m.click();
        k.print();
        k.println();
        t.track(5,6);
    }

    public static DeviceFactory getFactoryByCoutryCode(String lang) {
        switch (lang) {
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeiceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code: " + lang);
        }
    }
}

interface Mouse {
    void click();

    void dblclick();

    void scroll(int direction);
}

interface Keyboard {
    void print();

    void println();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    Touchpad getTouchpad();
}

class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("шелчок мышью");
    }

    @Override
    public void dblclick() {
        System.out.println("двойной шелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Скролим верх");
        else if (direction < 0)
            System.out.println("Скролим вниз");
        else
            System.out.println("не скролим");
    }
}

class RuKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.print("печатаем без переноса строки");
    }

    @Override
    public void println() {
        System.out.println("Печатаем с переносом строки");
    }
}

class RuTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}

class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void dblclick() {
        System.out.println("Mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Scroll Up");
        else if (direction < 0)
            System.out.println("Scroll Down");
        else
            System.out.println("no Scrolling");
    }
}

class EnKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.print("Print ");
    }

    @Override
    public void println() {
        System.out.println("print line");
    }
}

class EnTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + " pixels");
    }
}

class RuDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}

class EnDeiceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}