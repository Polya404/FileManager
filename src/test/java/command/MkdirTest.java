package command;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MkdirTest extends TestCase {

    public void testExecute() {
        Context context = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command"));
        Context context1 = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\NewFile.txt"));
        Mkdir mkdir = new Mkdir(context);
        Mkdir mkdir1 = new Mkdir(context1);

        List<String> args = new ArrayList<>();


        Assertions.assertEquals("Enter directory's name", mkdir.execute(args));
        args.add("NewDirectory");
        mkdir.execute(args);
        Assertions.assertEquals("Please back to directory", mkdir1.execute(args));
        Assertions.assertTrue(new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\newDirectory").exists());
    }
}