package command;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RmTest extends TestCase {

    public void testExecute() {
        Context context = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\NewFile.txt"));

        Rm rm = new Rm(context);

        List<String> args = new ArrayList<>();

        Assertions.assertEquals("Enter path", rm.execute(args));

        args.add("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\NewFile.txt");
        rm.execute(args);
        Assertions.assertFalse(new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\newFile.txt").exists());
    }
}