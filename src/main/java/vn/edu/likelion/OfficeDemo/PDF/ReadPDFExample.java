package vn.edu.likelion.OfficeDemo.PDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ReadPDFExample {
    public static void main(String[] args) {
        try {
            // Tạo đối tượng PDDocument từ file PDF
            PDDocument document = PDDocument.load(new File("output.pdf"));

            // Tạo đối tượng PDFTextStripper để trích xuất văn bản từ PDF
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Lấy nội dung văn bản từ PDF
            String text = pdfStripper.getText(document);

            // In ra nội dung văn bản từ PDF
            System.out.println("PDF Content:");
            System.out.println(text);

            // Đóng tài liệu PDF
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
