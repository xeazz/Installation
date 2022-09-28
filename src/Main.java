import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
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

        listDir(sb, dirList);
        listFile(sb, fileList);
        Writter(sb.toString());

    }

    public static boolean createDir(File file) {
        return file.mkdir();
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

    public static void listDir(StringBuilder sb, List<File> dirList) {
        for (File x : dirList) {
            if (createDir(x)) {
                sb.append("Каталог ");
                sb.append(x.getName());
                sb.append(" успешно создан");
                sb.append('\n');
            } else {
                sb.append("Ошибка создания каталога c именем ");
                sb.append(x.getName());
                sb.append('\n');
            }
        }
    }

    public static void listFile(StringBuilder sb, List<File> fileList) {
        for (File y : fileList) {
            if (createFile(y)) {
                sb.append("Файл ");
                sb.append(y.getName());
                sb.append(" успешно создан");
                sb.append('\n');
            } else {
                sb.append("Ошибка создания файла c именем ");
                sb.append(y.getName());
                sb.append('\n');
            }
        }
    }
}