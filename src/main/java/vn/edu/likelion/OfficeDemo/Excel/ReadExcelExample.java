package vn.edu.likelion.OfficeDemo.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelExample {
    public static void main(String[] args) {
        try {
            // lấy file excel vật lý
            FileInputStream fis = new FileInputStream(new File("output.xlsx"));

            // tạo ra 1 cái workbook từ file vật lý
            Workbook workbook = new XSSFWorkbook(fis);

            // lấy cái sheet ở trong workbook trên
            Sheet sheet = workbook.getSheetAt(0);

            // duyệt từng row trong sheet
            for (Row row : sheet) {
                // duyệt từng cell trong row
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        default:
                            System.out.println(cell.getDateCellValue());
                            break;
                    }
                }
            }
            workbook.close();
            fis.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
