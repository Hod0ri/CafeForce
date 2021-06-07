package com.cafepro.forcemachine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class BeverageData {
    final String BeveragePath = "Beverage.txt";
    Map<String, String> beverage = new HashMap<String, String>();
    File beverageFile = new File(BeveragePath);

    // Load Material Stock
    public Map ReadData() throws IOException {
        // Only use Method
        MaterialData md = new MaterialData();
        beverage = md.ReadData();
        return beverage;
    }

    MaterialData md = new MaterialData();


    // Edit Material Stock
    public void EditData(String name, Map<String, String> material, int value) {
        material.put(name, String.valueOf(Integer.parseInt(material.get(name)) + value));
        writeFile(material);
    }

    // Save Data File
    public void writeFile(Map<String, String> changeMap) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(beverageFile));

            if(beverageFile.isFile() && beverageFile.canWrite()) {
                for (String key : changeMap.keySet() ) {
                    writer.write(key+":"+changeMap.get(key)+"\n");
                }
                writer.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
