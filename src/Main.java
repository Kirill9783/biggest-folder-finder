import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\User\\Desktop\\Desktop";
        File file = new File(folderPath);

        System.out.println(getFolderSize(file));
    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }

        long sum = 0;
        File[] files = folder.listFiles(); //получаем список файлов в папке
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }
}