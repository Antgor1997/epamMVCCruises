import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Help {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        properties.setProperty("greetings","Hello!");
        FileOutputStream out1=new FileOutputStream("default.properties");
        properties.store(out1,"my comments");

        properties.setProperty("greetings","Привет!");
        FileOutputStream out2=new FileOutputStream("ru.properties");
        properties.store(out2,"my comments");


        properties.setProperty("greetings","Привіт!");
        FileOutputStream out3=new FileOutputStream("ua.properties");
        properties.store(out3,"my comments");



    }
}
