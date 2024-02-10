package com.society_Gate_Visitor_Registration.ExcelDownload;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.society_Gate_Visitor_Registration.Entity.Visitor;
import com.society_Gate_Visitor_Registration.Service.VisitorService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/visitors")
public class ExcelDownload {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/download")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        List<Visitor> visitors = visitorService.getAllVisitors();

        // Here We Create Excel workbook and sheet
        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Visitors");

        // For Create a header row
        
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Visitor Name", "Vehicle Number", "Visitor From", "Resident Name",
                "Resident Address", "In Time (ms)", "Out Time (ms)"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Now Fill data rows
        
        int rowNum = 1;
        for (Visitor visitor : visitors) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(visitor.getId());
            row.createCell(1).setCellValue(visitor.getVisitorName());
            row.createCell(2).setCellValue(visitor.getVehicleNumber());
            row.createCell(3).setCellValue(visitor.getVisitorFrom());
            row.createCell(4).setCellValue(visitor.getResidentName());
            row.createCell(5).setCellValue(visitor.getResidentAddress());
            row.createCell(6).setCellValue(visitor.getInTime());
            row.createCell(7).setCellValue(visitor.getOutTime());
        }

        // Set content type and header
        
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=visitors.xlsx");

        // Now Here we Write Excel to response output stream
        
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
