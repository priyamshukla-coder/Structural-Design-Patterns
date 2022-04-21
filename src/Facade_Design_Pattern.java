import java.util.*;

public class Facade_Design_Pattern {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        int c=S.nextInt();
        shop sh=new shop();
        if(c==1){
            System.out.println("Nokia Set purchased");
            sh.nokia_sale();
        }
        else if(c==2){
            System.out.println("Motorola Set Purchased");
            sh.motorola_sale();
        }
        else{
            System.out.println("Iphone Set Purchased");
            sh.iphone_sale();
        }
    }
}

interface mobile_shop{
    void model_number();
    void mobile_price();
}

class motorola implements mobile_shop{

    @Override
    public void model_number() {
        System.out.println("Motorola 51S");
    }

    @Override
    public void mobile_price() {
        System.out.println("Cost of the mobile is Rs750000");
    }
}

class nokia implements mobile_shop{

    @Override
    public void model_number() {
        System.out.println("Nokia 2600");
    }

    @Override
    public void mobile_price() {
        System.out.println("Cost of the mobile is Rs15000");
    }
}

class iphone implements mobile_shop{

    @Override
    public void model_number() {
        System.out.println("Iphone 11S");
    }

    @Override
    public void mobile_price() {
        System.out.println("Cost of the mobile is Rs75000");
    }
}

class shop{
    private mobile_shop iphone;
    private mobile_shop nokia;
    private mobile_shop motorola;

    public shop() {
        iphone=new iphone();
        nokia=new nokia();
        motorola=new motorola();
    }

    public void iphone_sale(){
        iphone.model_number();
        iphone.mobile_price();
    }

    public void motorola_sale(){
        motorola.mobile_price();
        motorola.model_number();
    }

    public void nokia_sale(){
        nokia.model_number();
        nokia.mobile_price();
    }
}