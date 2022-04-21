public class Bridge_Design_Pattern {
    public static void main(String[] args) {
        ElectronicItem item1 = new Tv(new Configured(), new Released());
        item1.produce();
        ElectronicItem item2 = new Mobile(new Configured(), new Released());
        item2.produce();
    }
}

interface Factory {
     void production();
}

abstract class ElectronicItem {
    protected Factory factory1;
    protected Factory factory2;
    protected ElectronicItem(Factory factory1, Factory factory2) {
        this.factory1 = factory1;
        this.factory2 = factory2;
    }
    abstract public void produce();
}

class Tv extends ElectronicItem {
    public Tv(Factory factory1, Factory factory2) {
        super(factory1, factory2);
    }
    @Override
    public void produce() {
        System.out.print("Tv ");
        factory1.production();
        factory2.production();
    }
}

class Mobile extends ElectronicItem {
    public Mobile(Factory factory1, Factory factory2) {
        super(factory1, factory2);
    }
    @Override
    public void produce() {
        System.out.print("Mobile ");
        factory1.production();
        factory2.production();
    }
}

class Configured implements Factory {
    @Override
    public void production() {
        System.out.print("Configured");
    }
}

class Released implements Factory {
    @Override
    public void production() {
        System.out.print(" And");
        System.out.println(" Released.");
    }
}