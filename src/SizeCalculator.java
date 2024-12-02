import java.io.File;
import java.util.HashMap;

public class SizeCalculator {
    private static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};
    private static HashMap<Character, Integer> char2multipliers = getMultipliers();

//    public static long getFolderSize(File folder) {
//        if (folder.isFile()) { //Проверяем файл или папка. Если файл, то возвращаем размер.
//            return folder.length(); //если папка, то идем дальше
//        }
//        long sum = 0;
//        File[] files = folder.listFiles(); //получаем список файлов в папке, получаем их размер и суммируем
//        for (File file : files) {
//            sum += getFolderSize(file);
//        }
//        return sum; //получаем общий размер итоговой папки
//    }

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = size / Math.pow(1024, i);
            if (value < 1024) {
                return Math.round(value * 100) / 100. + " " + sizeMultipliers[i] + (i > 0 ? "b" : "");
            }
        }
        return "Very big!";
    }

    public static long getSizeFromHumanReadable (String size) {

        char sizeFactor = size
                .replaceAll("[0-9\\s+]+", "")
                .charAt(0);
        int multipliers = char2multipliers.get(sizeFactor);
        long lenght = multipliers * Long.valueOf(size.replaceAll("[^0-9]", ""));

        return lenght;
    }

    private static HashMap<Character, Integer> getMultipliers() {
        HashMap<Character, Integer> char2multiplier = new HashMap();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            char2multiplier.put(sizeMultipliers[i], (int) Math.pow(1024, i));
        }
        return char2multiplier;
    }
}
