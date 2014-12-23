import java.util.*;
import java.math.*;


abstract class Twix {
    String name;
    String caramel;
    String choco;
   
    public String getName() {
        return name;
    }
    public void prepare() {
        System.out.println(name + " палочка:");
        System.out.println("Приготовление: ");
        System.out.println("Карамель "+ caramel);
        System.out.println("Шоколад "+ choco);
    }
    public void create() {
        System.out.println("Доводим до готовности");
    }
}


class LeftTwix extends Twix {
    public LeftTwix() {
        name = "Левая ";
        caramel = "наливается волнами";
        choco = "наливается вертикально";
    }
}

abstract class TwixStore {
    public Twix orderTwix () {
        Twix twix;
        twix = createTwix();
        twix.prepare();
        twix.create();
        return twix;
    }
    protected abstract Twix createTwix ();
}


class LeftTwixStore extends TwixStore{
    @Override
    protected Twix createTwix() {
        
            return new LeftTwix();
    }
}

class RightTwix extends Twix {
    public RightTwix() {
        name = "Правая";
        caramel = "струится";
        choco = "наливается сверху вниз";
    }
   
}

class RightTwixStore extends TwixStore{
    @Override
    protected Twix createTwix() {
        return new RightTwix();
    }
}

public class TwixTest {

    public static void main(String[] args) {
        ChoiseBar first = new ChoiseBar();
        ChoiseBar second = new ChoiseBar();
        System.out.println("В пачку попадут две палочки: \n");
        if (first.rand==1) {
            TwixStore lStore = new LeftTwixStore();
            Twix twix = lStore.orderTwix();
            System.out.println("Произвели левую палочку Twix\n");
        }
        else {
            TwixStore rStore = new RightTwixStore();
            Twix twix = rStore.orderTwix();
            System.out.println("Произвели правую палочку Twix\n");
        } 
        if (second.rand==1) {
            TwixStore lStore = new LeftTwixStore();
            Twix twix = lStore.orderTwix();
            System.out.println("Произвели левую палочку Twix\n");
        }
        else  {
            TwixStore rStore = new RightTwixStore();
            Twix twix = rStore.orderTwix();
            System.out.println("Произвели правую палочку Twix\n");
        }                  
        System.out.println("Упаковываем палочки в фирменную упаковку");
    }
}

class ChoiseBar {
    //Random rand = new Random();
    //rand.nextInt(20);
    int rand = (int) (Math.random()*2 + 1);
}