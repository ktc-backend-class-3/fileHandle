package vn.edu.likelion.OfficeDemo.Word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadWordExample {
    public static void main(String[] args) {
        // đọc file vật lý
        File file = new File("output.docx");

        try {
            InputStream is = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(is);

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                System.out.println(paragraph.getText());
            }

            document.close();
            is.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
