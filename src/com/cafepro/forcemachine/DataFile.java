package com.cafepro.forcemachine;

import java.io.*;
import java.util.HashMap;

public class DataFile {
    final String MaterialPath = "Material.txt";
    HashMap<String, String> material = new HashMap<String, String>();

    // Load Material Stock
    public void ReadData() throws IOException {
        File materialFile = new File(MaterialPath);

        if(materialFile.exists()) {
            BufferedReader readFile = new BufferedReader(new FileReader(materialFile));
            String tempLine = null;
            while((tempLine = readFile.readLine()) != null) {
                String[] partTemp = tempLine.split(":");

                // Save Array to HashMap
                if(partTemp.length > 0)  {
                    String key = partTemp[0];
                    String value = partTemp[1];
                    material.put(key, value);
                }
            }
        }
    }

    // Edit Material Stock
    public void EditData(String name, int value) {
    }
}
