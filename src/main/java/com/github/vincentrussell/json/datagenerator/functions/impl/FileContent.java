package com.github.vincentrussell.json.datagenerator.functions.impl;

import com.github.vincentrussell.json.datagenerator.functions.Function;
import com.github.vincentrussell.json.datagenerator.functions.FunctionInvocation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Read content from file
 *
 */
@Function(name = "file")
public class FileContent {

  /**
   *
   * @param name of the file
   * @return String content of file
   * @throws IOException
   */
  @FunctionInvocation
  public String file(final String name) throws IOException {
    File file = new File(name);
    if (file.exists()) {
      return readFileData(file);
    }
    return name + " Not found";
  }

  private String readFileData(final File file) {
    try (FileInputStream fis = new FileInputStream(file)) {
      byte[] data = new byte[(int) file.length()];
      fis.read(data);
      fis.close();
      return new String(data, "UTF-8").trim();
    } catch (Exception e) {
      return e.getMessage();
    }
  }

}
