package com.cafepro.forcemachine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DataFile {
    final String MaterialPath = "Material.txt";
    Map<String, String> material = new HashMap<String, String>();
    File materialFile = new File(MaterialPath);

    // Load Material Stock
    public Map ReadData() throws IOException {

        String delimiter = ":";
        Map<String, String> map = new HashMap<>();

        try(Stream<String> lines = Files.lines(Paths.get(MaterialPath))){
            lines.filter(line -> line.contains(delimiter)).forEach(
                    line -> map.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
            );
        }
        material = map;
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(materialFile));

            if(materialFile.isFile() && materialFile.canWrite()) {
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
