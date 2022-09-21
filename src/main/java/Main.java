import driver.DriverManagerFactory;
import steps.ExcelSteps;
import steps.Manager;
import steps.SpeechSteps;


public class Main{

    private static final String RUSSIAN_SPEED = "1.3";
    private static final String ALL = "all.csv";
    private static final String PART_2 = "Part2.csv";
    private static final String PART_3 = "Part3.csv";
    private static final String PART_4 = "Part3.csv";

    public static void main(String[] args) {

        String file1 = ALL;
        String file2 = PART_2;
        String file3 = PART_3;
        String file4 = PART_4;
        ExcelSteps excelSteps = new ExcelSteps(file1);

        SpeechSteps.openChrome();

        SpeechSteps.setRussianSpeed(RUSSIAN_SPEED);
        SpeechSteps.minimizeChrome();

        while (excelSteps.isContainData()){

            excelSteps.setNextRandomRow();
            SpeechSteps.enterRussian(excelSteps.getRussian());
            Manager.readIn();

            SpeechSteps.enterEnglish(excelSteps.getEnglish());
            Manager.readIn();
//            Manager.sleep5();
//
//            SpeechSteps.enterEnglish(excelSteps.getEnglish());
////            Manager.readIn();
//            Manager.sleep5();
//
//            SpeechSteps.enterEnglish(excelSteps.getEnglish());
////            Manager.readIn();
//            Manager.sleep5();
//
////            SpeechSteps.enterRussian(excelSteps.getRussian());
////            Manager.readIn();
        }

        DriverManagerFactory.quitDriver();



    }
}
