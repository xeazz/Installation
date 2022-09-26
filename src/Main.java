import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<File> dirList = Arrays.asList(new File("/home/dmitry/Games/src"),
                new File("/home/dmitry/Games/src/main"),
                new File("/home/dmitry/Games/src/test"),
                new File("/home/dmitry/Games/res"),
                new File("/home/dmitry/Games/res/drawables"),
                new File("/home/dmitry/Games/res/vectors"),
                new File("/home/dmitry/Games/res/icons"),
                new File("/home/dmitry/Games/savegames"),
                new File("/home/dmitry/Games/temp"));
        List<File> fileList = Arrays.asList(new File("/home/dmitry/Games/src/main/Main.java"),
                new File("/home/dmitry/Games/src/main/Utils.java"),
                new File("/home/dmitry/Games/temp/text.txt"));


        StringBuilder sb = new StringBuilder();
        for (File x : dirList) {
            sb.append(createDir(x));
            sb.append('\n');
        }
        for (File y : fileList) {
            sb.append(createFile(y));
            sb.append('\n');
        }
        String text = sb.toString();
        Writter(text);

    }

    public static boolean createDir(File file) {
        if (file.mkdir()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean createFile(File file) {
        try {
            if (file.createNewFile())
                return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static void Writter(String text) {
        try (FileWriter writer = new FileWriter("/home/dmitry/Games/temp/text.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}