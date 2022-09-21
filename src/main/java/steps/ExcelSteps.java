package steps;

import utils.RandomUtils;
import utils.ReadCSV;
import java.util.List;

public class ExcelSteps {
    public List<String[]> data;
    private String[] row;

    public boolean isContainData(){
        if (!data.isEmpty()){
            return true;
        }
        else return false;
    }

    public ExcelSteps(String ...name){
        for (String file: name) {
            if (data != null) {
                data.addAll(ReadCSV.getAsListsOfArray(file));
            } else {
                data = ReadCSV.getAsListsOfArray(file);
            }
        }
    }

    public void setNextRandomRow(){
        row = RandomUtils.getRandomItemFromList(data);
        data.remove(row);
    }



    public String getRussian(){
        return row[0];
    }

    public String getEnglish(){
        return row[1];
    }
}
