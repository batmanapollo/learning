package recursion;

import java.io.File;
import java.util.*;

public class FilesFinder {

    public List<String> find(String path) {
        return find(new File(path));
    }

    private List<String> find(File directory) {
        List<String> fileNames = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                fileNames.addAll(find(file));
            } else {
                fileNames.add(file.getName());
            }
        }
        return fileNames;
    }

}
