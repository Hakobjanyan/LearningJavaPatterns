/**
 * Created by Arsen on 10.08.2017.
 */

/**
 * pattern Facade
 * */
public class FacadeApp {
    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power {
    void on() {
        System.out.println("Включение питания");
    }

    void off() {
        System.out.println("Выключение питания");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Происходит копироваие данных с диска");
        } else {
            System.out.println("Вставьте диск с данными");

        }
    }
}