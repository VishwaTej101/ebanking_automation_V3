package com.inetbanking.utilites;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyXLSReader implements Closeable {

    private String filepath;
    private FileInputStream fis = null;
    private Workbook workbook = null;
    private Sheet sheet = null;
    private Row row = null;
    private Cell cell = null;
    private FileOutputStream fileOut = null;
    private String fileExtension = null;

    public MyXLSReader(String filepath) throws IOException {
        this.filepath = filepath;
        fileExtension = filepath.substring(filepath.lastIndexOf("."));
        fis = new FileInputStream(filepath);
        if (fileExtension.equals(".xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fis);
        }
    }

    // Implement the Closeable interface to ensure resources are closed properly
    public void close() throws IOException {
        if (fis != null) {
            fis.close();
        }
        if (fileOut != null) {
            fileOut.close();
        }
    }

    // returns the row count in a sheet
    public int getRowCount(String sheetname) {
        int sheetIndex = workbook.getSheetIndex(sheetname);
        if (sheetIndex == -1) {
            return 0;
        } else {
            sheet = workbook.getSheetAt(sheetIndex);
            int rowsCount = sheet.getLastRowNum() + 1;
            return rowsCount;
        }
    }

 // returns the data from a cell
 // ... (previous methods)

 // returns the data from a cell
 public String getCellData(String sheetname, Object colIdentifier, int rowNum) {
     try {
         if (rowNum <= 0)
             return "";

         int sheetIndex = workbook.getSheetIndex(sheetname);
         if (sheetIndex == -1)
             return "";

         sheet = workbook.getSheetAt(sheetIndex);
         row = sheet.getRow(0);
         int colNum = -1;

         if (colIdentifier instanceof String) {
             // Search for column name by string comparison
             String colName = (String) colIdentifier;
             for (int i = 0; i < row.getLastCellNum(); i++) {
                 if (row.getCell(i).getStringCellValue().equals(colName)) {
                     colNum = i;
                     break;
                 }
             }
         } else if (colIdentifier instanceof Integer) {
             // Use column number directly
             colNum = (Integer) colIdentifier - 1; // Convert to 0-based index
         }

         if (colNum == -1)
             return "";

         sheet = workbook.getSheetAt(sheetIndex);
         row = sheet.getRow(rowNum - 1);
         if (row == null)
             return "";

         cell = row.getCell(colNum);
         if (cell == null)
             return "";

         CellType cellType = cell.getCellType();
         if (cellType == CellType.STRING) {
             return cell.getStringCellValue();
         } else if (cellType == CellType.NUMERIC || cellType == CellType.FORMULA) {
             if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(cell.getDateCellValue());
                 String cellText = (cal.get(Calendar.DAY_OF_MONTH)) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
                         + (cal.get(Calendar.YEAR));
                 return cellText;
             } else {
                 return String.valueOf(cell.getNumericCellValue());
             }
         } else if (cellType == CellType.BLANK)
             return "";
         else
             return String.valueOf(cell.getBooleanCellValue());
     } catch (Exception e) {
         e.printStackTrace();
         return "row " + rowNum + " or column " + colIdentifier + " does not exist in xls";
     }
 }

 // ... (other methods)

    // returns true if data is set successfully else false
    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try {
            if (rowNum <= 0)
                return false;

            int sheetIndex = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (sheetIndex == -1)
                return false;

            sheet = workbook.getSheetAt(sheetIndex);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                    colNum = i;
            }
            if (colNum == -1)
                return false;

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            // cell style
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            cell.setCellStyle(cs);
            cell.setCellValue(data);

            fileOut = new FileOutputStream(filepath);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if data is set successfully else false
    public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {
        try {
            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
                    colNum = i;
            }

            if (colNum == -1)
                return false;
            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);
            CreationHelper createHelper = workbook.getCreationHelper();

            // cell style for hyperlinks
            CellStyle hlink_style = workbook.createCellStyle();
            Font hlink_font = workbook.createFont();
            hlink_font.setUnderline(Font.U_SINGLE);
            hlink_font.setColor(IndexedColors.BLUE.getIndex());
            hlink_style.setFont(hlink_font);

            Hyperlink link = createHelper.createHyperlink(HyperlinkType.FILE);
            link.setAddress(url);
            cell.setHyperlink(link);
            cell.setCellStyle(hlink_style);

            fileOut = new FileOutputStream(filepath);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
 // ... (previous methods)

 // removes a column and all the contents
 // removes a column and all the contents
    public boolean removeColumn(String sheetName, int colNum) {
        try {
            if (!isSheetExist(sheetName))
                return false;

            sheet = workbook.getSheet(sheetName);
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            @SuppressWarnings("unused")
            CreationHelper createHelper = workbook.getCreationHelper();
            style.setFillPattern(FillPatternType.NO_FILL);

            for (int i = 0; i < getRowCount(sheetName); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cell = row.getCell(colNum - 1);
                    if (cell != null) {
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }

            // Shift the columns to the left after removing the column
            for (int r = 0; r < getRowCount(sheetName); r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    for (int c = colNum - 1; c < row.getLastCellNum() - 1; c++) {
                        Cell nextCell = row.getCell(c + 1);
                        if (nextCell != null) {
                            Cell newCell = row.createCell(c, nextCell.getCellType());
                            cloneCell(newCell, nextCell);
                            row.removeCell(nextCell);
                        }
                    }
                }
            }

            fileOut = new FileOutputStream(filepath);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Helper method to clone cell style and value
    private void cloneCell(Cell newCell, Cell cellToClone) {
        newCell.setCellStyle(cellToClone.getCellStyle());
        if (cellToClone.getCellType() == CellType.BOOLEAN) {
            newCell.setCellValue(cellToClone.getBooleanCellValue());
        } else if (cellToClone.getCellType() == CellType.NUMERIC) {
            newCell.setCellValue(cellToClone.getNumericCellValue());
        } else if (cellToClone.getCellType() == CellType.STRING) {
            newCell.setCellValue(cellToClone.getStringCellValue());
        } else if (cellToClone.getCellType() == CellType.ERROR) {
            newCell.setCellValue(cellToClone.getErrorCellValue());
        } else if (cellToClone.getCellType() == CellType.FORMULA) {
            newCell.setCellFormula(cellToClone.getCellFormula());
        }
    }

 // find whether sheets exists
 public boolean isSheetExist(String sheetName) {
     int index = workbook.getSheetIndex(sheetName);
     if (index == -1) {
         index = workbook.getSheetIndex(sheetName.toUpperCase());
         return index != -1;
     }
     return true;
 }

 // returns number of columns in a sheet
 public int getColumnCount(String sheetName) {
     if (!isSheetExist(sheetName))
         return -1;

     sheet = workbook.getSheet(sheetName);
     row = sheet.getRow(0);

     if (row == null)
         return -1;

     return row.getLastCellNum();
 }

 // ... (other methods)

 // Add your other methods here...

 // ... (other methods)


    
}
