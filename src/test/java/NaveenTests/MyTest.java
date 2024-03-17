package NaveenTests;

public class MyTest {
    public static void main(String[] args) {
    	
    	Person p= new Person();
    	p.setName("John");
    	p.setEmpId(1);
//    	p.getEmpId();
    	System.out.println(p.getName());
    	System.out.println(p.getEmpId());
    	
    	
//        try {
//            int result = divide(10, 2);
//            System.out.println("Result: " + result);
//        } catch (ArithmeticException e) {
//            System.err.println("An arithmetic exception occurred: " + e.getMessage());
//        }
    }

//    public static int divide(int dividend, int divisor) {
//        if (divisor == 0) {
//            throw new ArithmeticException("Division by zero");
//        }
//        return dividend / divisor;
//    }
}

