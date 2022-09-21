package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReadCSV {
    public static String resourcesPath = getRootOfProject() + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator;

    public static String getRootOfProject() {
        String realPath = System.getProperty("user.dir");
        String tempPath = System.getProperty("user.dir");
        File dir = new File(tempPath);
        String[] listOfFiles = dir.list();
        for (int a = 0; a < listOfFiles.length; a++) {
            if (listOfFiles[a].equals("pom.xml")) {
                tempPath = realPath.substring(0, realPath.lastIndexOf(File.separator));
                for (String item : new File(tempPath).list()) {
                    if (item.equals("pom.xml")) {
                        realPath = realPath.substring(0, realPath.lastIndexOf(File.separator));
                        a = 0;
                    }
                }
            }

        }
        return realPath;
    }

    public static  List<String[]> getAsListsOfArray(String dataCSVFileName) {
        String path = resourcesPath + dataCSVFileName;

        List<String[]> CURRENT_DATA = null;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))){

            CSVReader csvReader = new CSVReader(br);
            try {
                CURRENT_DATA = csvReader.readAll();
            } catch (CsvException e) {
                e.printStackTrace();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return CURRENT_DATA;
    }
}
