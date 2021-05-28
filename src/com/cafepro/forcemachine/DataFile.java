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

    // Load Material Stock
    public Map ReadData() throws IOException {
        File materialFile = new File(MaterialPath);

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
    public void EditData(String name, Map<String, String> material) {
        material.put(name, material.get(name) + 1);
    }

    // Test Method
    // Edit Material Stock
    public void Test(Map<String, String> material) {
        EditData("초코", material);
        System.out.println(material);
    }
}
