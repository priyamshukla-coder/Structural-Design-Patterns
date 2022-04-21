public class Adapter_Design_Pattern {
    public static void main(String[] args) {
        College_Assignment ob=new College_Assignment();
        //ob.setP(p);//Here comes the error as we need to create an object of pen by=ut as pen is a interface we cannot instantiate it.
        pen obj=new connector();
        ob.setP(obj);
        ob.write_exam("Today is Maths Exam");
    }
}
interface pen{
    void write_exam(String s);
}

class Parker_Pen{
    public void write_using_pen(String s){
        System.out.println(s);
    }
}
class College_Assignment{
    private pen p;

    public pen getP() {
        return p;
    }

    public void setP(pen p) {
        this.p = p;
    }

    public void write_exam(String s){
        p.write_exam(s);
    }
}
class connector implements pen{
    Parker_Pen pp=new Parker_Pen();

    @Override
    public void write_exam(String s) {
        pp.write_using_pen(s);
    }
}