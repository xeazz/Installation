import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File srs = new File("/home/dmitry/Games/src");
        File srsMain = new File("/home/dmitry/Games/src/main");
        File srsMainMain = new File("/home/dmitry/Games/src/main/Main.java");
        File srsMainUtils = new File("/home/dmitry/Games/src/main/Utils.java");

        File srsTest = new File("/home/dmitry/Games/src/test");

        File res = new File("/home/dmitry/Games/res");
        File resDrawables = new File("/home/dmitry/Games/res/drawables");
        File resVectors = new File("/home/dmitry/Games/res/vectors");
        File resIcons = new File("/home/dmitry/Games/res/icons");

        File savegames = new File("/home/dmitry/Games/savegames");
        File temp = new File("/home/dmitry/Games/temp");
        File tempText = new File("/home/dmitry/Games/temp/text.txt");

        StringBuilder sb = new StringBuilder();
        sb
                .append(temp.getName() +" "+ createDir(temp))
                .append('\n')
                .append(tempText.getName() +" "+ createFile(tempText))
                .append('\n')
                .append(srs.getName() +" "+createDir(srs))
                .append('\n')
                .append(srsMain.getName() +" "+createDir(srsMain))
                .append('\n')
                .append(srsTest.getName() +" "+createDir(srsTest))
                .append('\n')
                .append(srsMainMain.getName() +" "+createFile(srsMainMain))
                .append('\n')
                .append(srsMainUtils.getName() +" "+createFile(srsMainUtils))
                .append('\n')
                .append(res.getName() +" "+createDir(res))
                .append('\n')
                .append(resDrawables.getName() +" "+createDir(resDrawables))
                .append('\n')
                .append(resVectors.getName() +" "+createDir(resVectors))
                .append('\n')
                .append(resIcons.getName() +" "+createDir(resIcons))
                .append('\n')
                .append(savegames.getName() +" "+createDir(savegames));
        String text = sb.toString();
        //System.out.println(text);
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
    public static void Writter (String text) {
        try (FileWriter writer = new FileWriter("/home/dmitry/Games/temp/text.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}