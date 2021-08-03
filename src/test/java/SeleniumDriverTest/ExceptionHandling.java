package SeleniumDriverTest;

public class ExceptionHandling {
    public static void main(String[] args) {
        System.out.println("Hello World");
        try {
            demo();
        }catch (Exception e){
            System.out.println("Exception thrown: "+e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("Finally");
        }

        System.out.println("Completed");
    }

    public static void demo() throws ArithmeticException{
        int i = 1/0;
    }
}
