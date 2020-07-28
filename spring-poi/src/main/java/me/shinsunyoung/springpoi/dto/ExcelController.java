package me.shinsunyoung.springpoi.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tika.Tika;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ExcelController {

  @GetMapping("/excel")
  public String main() {
    return "excel";
  }


  @PostMapping("/excel/read")
  public String readExcel(@RequestParam("file") MultipartFile file, Model model)
      throws IOException {

    Tika tika = new Tika(); // Apache Tika 사용
    String detect = tika.detect(file.getBytes()); // Tika를 사용해서 MIME 타입 얻어내기

    List<ExcelData> dataList = new ArrayList<>();
    String extension = FilenameUtils.getExtension(file.getOriginalFilename());

    if (!isExcel(detect, extension)) {
      throw new IOException("엑셀파일만 업로드 해주세요.");
    }

    Workbook workbook = null;

    if (extension.equals("xlsx")) {
      workbook = new XSSFWorkbook(file.getInputStream());
    } else if (extension.equals("xls")) {
      workbook = new HSSFWorkbook(file.getInputStream());
    }

    Sheet worksheet = workbook.getSheetAt(0);

    for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

      Row row = worksheet.getRow(i);

      ExcelData data = new ExcelData();

      data.setNum((int) row.getCell(0).getNumericCellValue());
      data.setName(row.getCell(1).getStringCellValue());
      data.setEmail(row.getCell(2).getStringCellValue());

      dataList.add(data);
    }

    model.addAttribute("datas", dataList);

    return "excelList";

  }

  private boolean isExcel(String mime, String extension) {
    if (!mime.equals("application/x-tika-ooxml")) { // Microsoft Office 파일의 MIME은 application/x-tika-ooxml
        return false;
    } else if (!extension.equals("xlsx") && !extension.equals("xls")) { // 확장자가 xls 또는 xlsx가 아니라면 false 리턴
      return false;
    }

    return true;
  }
}