package command;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MkFileTest extends TestCase {

    @Test
    public void testExecute() {
        Context context = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command"));
        Context context1 = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\NewFile.txt"));
        MkFile mkFile = new MkFile(context);
        MkFile mkFile1 = new MkFile(context1);

        List<String> args = new ArrayList<>();


        Assertions.assertEquals("Enter file's name", mkFile.execute(args));
        args.add("NewFile.txt");
        mkFile.execute(args);
        Assertions.assertEquals("Please back to directory", mkFile1.execute(args));
        Assertions.assertTrue(new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command\\newFile.txt").exists());
    }
}