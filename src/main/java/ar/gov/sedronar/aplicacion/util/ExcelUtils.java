package ar.gov.sedronar.aplicacion.util;

import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * Created by Tomas Mendes Ribeiro on 15/01/2018.
 */
public class ExcelUtils {

    public static void createHeaderRow(Sheet sheet, List<String> headers){
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 10);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Row row = sheet.createRow(0);
        int count = 0;
        for(String header : headers) {
            Cell cellId = row.createCell(count);
            cellId.setCellStyle(cellStyle);
            cellId.setCellValue(header);
            count++;
        }
    }

    public static CellStyle createCellStyleDate(String dateFormat, Workbook wb) {
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(dateFormat));
        return cellStyle;
    }
}
