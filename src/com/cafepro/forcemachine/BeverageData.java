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
    MaterialData md = new MaterialData();

    final String BeveragePath = "Beverage.txt";
    Map<String, String> beverage = new HashMap<String, String>();
    File beverageFile = new File(BeveragePath);

    // Load Material Stock
    public Map ReadData() throws IOException {

        String delimiter = ":";
        Map<String, String> map = new HashMap<>();

        try(Stream<String> lines = Files.lines(Paths.get(BeveragePath))){
            lines.filter(line -> line.contains(delimiter)).forEach(
                    line -> map.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
            );
        }
        beverage = map;
        return map;
    }


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
