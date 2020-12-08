package tests;

import utils.YamlReader;

import java.util.Map;

public class SetDataFile {

  public Map<String, String> setData() {
    String fileToLoad =
        System.getProperty("datafile") != null ? System.getProperty("datafile") : "data.yml";
    return new YamlReader(fileToLoad).readTestDataAsMap();
  }
}
