import java.util.Date;

/**
 * Created by ars on 10.08.2017.
 */

/**
 * pattern Factory
 */
public class FactoryMethodApp {
    public static void main(String[] args) {

        //Watch watch = new DigitalWatch();
       // watch.showTime();

        WatchMaker maker = getMakerByName("fsf");//new DigitalWatchMaker();
        Watch watch = maker.creatWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital")){
            return new DigitalWatchMaker();
        }else if(maker.equals("Rome")){
            return new RomeWatchMaker();
        }
        throw  new RuntimeException("не поддерживаемая производственная линия " + maker );
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("VII-XX");

    }
}

interface WatchMaker{
    Watch creatWatch();
}
class DigitalWatchMaker implements WatchMaker{
    public Watch creatWatch(){
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker{
    @Override
    public Watch creatWatch() {
        return new RomeWatch();
    }
}