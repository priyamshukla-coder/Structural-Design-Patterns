import java.util.*;
public class Composite_Design_Pattern {
    public static void main(String[] args) {

        computer_parts mouse=new leaf_objects(300,"Mouse");
        computer_parts monitor=new leaf_objects(10000,"Monitor");
        computer_parts ram=new leaf_objects(20000,"RAM");
        computer_parts keyboard=new leaf_objects(2500,"Keyboard");
        computer_parts printer=new leaf_objects(35000,"Printer");
        computer_parts pen_drive=new leaf_objects(800,"PenDrive");

        composite_objects mother_board=new composite_objects("MotherBoard");
        composite_objects peripheral_devices=new composite_objects("Peripheral Devices");
        composite_objects computer=new composite_objects("Computer");
        composite_objects storage=new composite_objects("Storage Devices");

        peripheral_devices.addparts(keyboard);
        peripheral_devices.addparts(printer);
        storage.addparts(pen_drive);
        mother_board.addparts(ram);

        computer.addparts(peripheral_devices);
        computer.addparts(monitor);

        ram.price();
        System.out.println();
        System.out.println("Peripheral Devices are as follows :");
        peripheral_devices.price();

        System.out.println();
        System.out.println("Computer Cabinet is as follows :");
        computer.price();

        System.out.println();
        System.out.println("Storage Devices are as follows :");
        storage.price();

    }
}

interface computer_parts{
    void price();
}

class leaf_objects implements computer_parts{

    int price;
    String nm;

    public leaf_objects(int price, String nm) {
        this.price = price;
        this.nm = nm;
    }

    @Override
    public void price() {
        System.out.println(nm+" Price is "+price);
    }
}

class composite_objects implements computer_parts{

    String nm;

    public composite_objects(String nm) {
        this.nm = nm;
    }

    List<computer_parts> cp=new ArrayList<>();
    public void addparts(computer_parts p){
        cp.add(p);
    }
    @Override
    public void price() {
        for(computer_parts p: cp){
            p.price();
        }
    }
}