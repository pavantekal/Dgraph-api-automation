package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlReader {
  private String filePath;

  public YamlReader(String filePath) {
    this.filePath = filePath;
  }

  public Map<String, String> readTestDataAsMap() {
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);

    return new Yaml().load(inputStream);
  }
}
