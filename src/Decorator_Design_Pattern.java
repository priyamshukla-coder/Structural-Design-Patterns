import java.util.*;
public class Decorator_Design_Pattern {
    public static void main(String[] args) {
        bike bk=new normal_bike();
        System.out.println("Simple Bike created :");
        bk.design();
        System.out.println();

        //Now here we create the sports bike which has both the features of normal bike and sports bike.
        System.out.println("Sports Bike :");
        bike sp_bike=new sports_bike(bk);
        sp_bike.design();
        System.out.println();

        //Now create Mountain Rider
        System.out.println("Mountain Rider Bike :");
        bike mountain_rider = new mountain_bike(bk);
        mountain_rider.design();
        System.out.println();

        //Now we can create a more interesting bike which is both a sports and mountain rider
        System.out.println("Super Speedy Mountain Rider :");
        bike sp_mountain_bike = new decorate_bike(new sports_bike(new mountain_bike(new normal_bike())));
        sp_mountain_bike.design();
    }
}

interface bike{
    void design();
}

class normal_bike implements bike{

    @Override
    public void design() {
        System.out.println("Bike with normal features");
    }
}

class decorate_bike implements bike{
    private bike b;
    public decorate_bike(bike b) {
        this.b = b;
    }

    @Override
    public void design() {
        b.design();
    }
}

class sports_bike extends decorate_bike{

    public sports_bike(bike b) {
        super(b);
    }

    @Override
    public void design(){
        super.design();
        System.out.println("Sports Bike with additional Features");
    }
}

class mountain_bike extends decorate_bike{

    public mountain_bike(bike b) {
        super(b);
    }

    @Override
    public void design() {
        super.design();
        System.out.println("Mountain Bike with extra speed functionality");
    }
}