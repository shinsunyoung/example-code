package me.shinsunyoung.springpoi.util;

public class ExcelUtils {

  private ExcelUtils() {

  }

  public static boolean isExcel(String mime, String extension) {
    return mime.equals("application/x-tika-ooxml") &&   // Microsoft Office 파일의 MIME은 application/x-tika-ooxml
        extension.equals("xlsx") || extension.equals("xls");  // 확장자가 xls 또는 xlsx
  }

}
