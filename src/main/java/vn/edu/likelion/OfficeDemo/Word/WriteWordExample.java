package vn.edu.likelion.OfficeDemo.Word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteWordExample {
    public static void main(String[] args) {
        // tạo 1 đối tượng xử lý tài liệu docx
        XWPFDocument document = new XWPFDocument();

        // tạo ra 1 đoạn văn bản
        XWPFParagraph paragraph = document.createParagraph();

        // tạo câu văn
        XWPFRun run = paragraph.createRun();
        run.setText("Văn bản đầu tiên\n");
        run.setText("Đuọc viết bằng java");

        try {
            // Tạo 1 file mới tên output.docx
            FileOutputStream fos = new FileOutputStream("output.docx");
            // ghi các cái giá trị của document vào file output.docx
           document.write(fos);

            System.out.println("Đã tạo file docx thành công!");
            document.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
