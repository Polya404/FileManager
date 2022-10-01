package command;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;

public class PWDTest extends TestCase {

    public void testExecute() {
        Context context = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command"));
        Context context1 = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\NewFile.txt"));

        PWD pwd = new PWD(context);
        PWD pwd1 = new PWD(context1);

        Assertions.assertEquals("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command", pwd.execute(new ArrayList<>()));
        Assertions.assertEquals("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\NewFile.txt", pwd1.execute(new ArrayList<>()));
        Assertions.assertNotEquals("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\NewFile.txt", pwd.execute(new ArrayList<>()));
    }
}