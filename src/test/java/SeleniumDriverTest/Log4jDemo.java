package SeleniumDriverTest;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Log4jDemo {

    public static void main(String[] args) {
        System.out.println("Hello World");
        log.info("Hello World");
        log.debug("THis is debug");
        log.error("This is Error");
    }
}
