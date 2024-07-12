package vn.edu.likelion.OfficeDemo.PDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class WritePDFExample {
    public static void main(String[] args) {
        try {
            // tạo ra 1 đối tượng PDF
            PDDocument document = new PDDocument();

            // tạo ra 1 trang từ đối tượng PDF trên
            PDPage page = new PDPage();

            // tạo ra 1 cái lớp cho phép vẽ văn bản
            PDPageContentStream content = new PDPageContentStream(document, page);

            // set font và fontsize cho nội dung
            content.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // nội dung phải bọc bên trong beginText() và endText()
            content.beginText();
            // kiểm tra toạ độ của page
            System.out.println(page.getBleedBox());
            content.newLineAtOffset(20, 772);
            content.showText("123 abc");

            content.newLineAtOffset(0, -20);
            content.showText("abc 123");
            content.endText();

            // tạo ra file PDF vật lý
            File file = new File("output.pdf");

            document.addPage(page);
            content.close();
            document.save(file);
            document.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
