package com.company.datadriventesting;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

    //Besides the Apache Poi I also added the ooxml-lib dependency.
    public static void main(String[] args) {

        XSSFWorkbook ExcelWBook;
        XSSFSheet ExcelWSheet;
        XSSFCell Cell;

        // Location of the Excel file
        //String path = "C:\\Users\\JuliaGirona\\Downloads\\ExcelRead.xlsx";
        String path = "C:\\Users\\JuliaGirona\\IdeaProjects\\SeleniumWebDriverSetupTest\\src\\com\\company\\datadriventesting\\ExcelRead.xlsx";
        String sheetName = "Sheet1";

        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(sheetName);

            Cell = ExcelWSheet.getRow(0).getCell(0);
            String cellData = Cell.getStringCellValue();
            System.out.println("Cell Data: " + cellData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
