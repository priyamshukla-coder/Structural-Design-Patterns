import java.util.*;
public class Proxy_Design_Pattern {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        official_operations ob=new proxy_office_operations(1);
        ob.view();
        ob.edit();
        System.out.println();

        official_operations ob1=new proxy_office_operations(34);
        ob1.edit();
        ob1.view();
    }
}

interface official_operations{
    void edit();
    void view();
}

class real_office_operations implements official_operations{

    @Override
    public void edit() {
        System.out.println("Enabling and performing edit operations");
    }

    @Override
    public void view() {
        System.out.println("Enabling and performing view operations");
    }
}

class proxy_office_operations implements official_operations{
    private real_office_operations real_operations;
    private int emp_id;
    public proxy_office_operations(int id){
        this.emp_id=id;
    }

    @Override
    public void edit() {
        boolean get_role_val=verify_id(emp_id);
        if((get_role_val)){
            real_operations=new real_office_operations();
            real_operations.edit();
        }
        else{
            System.out.println("You are not a valid user so  you can't edit the database and can only view it");
            System.out.println("Access Denied");
            //System.exit(0);
        }
    }

    @Override
    public void view() {
            real_operations=new real_office_operations();
            real_operations.view();
    }

    public boolean verify_id(int emp_id){
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(24);
        l.add(8976);
        l.add(7565);
        if(l.contains(emp_id)){
            return true;
        }
        else{
            return false;
        }
    }
}