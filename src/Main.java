import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\User\\Desktop\\Desktop";
        long sizeLimit = 50 * 1024;
        File file = new File(folderPath);
        Node root = new Node(file, sizeLimit);

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
    }
}