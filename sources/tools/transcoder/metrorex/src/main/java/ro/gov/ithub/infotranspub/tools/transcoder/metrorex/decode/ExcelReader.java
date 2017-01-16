package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;
import org.apache.poi.ss.usermodel.*;
import ro.gov.ithub.infotranspub.tools.transcoder.metrorex.temp.TempTextFile;

import java.io.*;
import java.text.SimpleDateFormat;

public class ExcelReader {

    public void ExcelReader() {

    }

    public TempTextFile readFile(String path){

        TempTextFile outputFile  = null;
        try
        {
            outputFile = new TempTextFile();
            outputFile.open(TempTextFile.WRITE);
            InputStream inp = new FileInputStream(path);

            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);

            for(int rowIndex = sheet.getFirstRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++)
            {
                Cell cell=null;
                Row row = null;

                int previousCell = -1;
                int currentCell = 0;
                row = sheet.getRow(rowIndex);

                for(int colIndex=row.getFirstCellNum(); colIndex < row.getLastCellNum(); colIndex++)
                {
                    cell = row.getCell(colIndex);
                    currentCell = cell.getColumnIndex();

                    StringBuilder sb = new StringBuilder();
                    sb.append(rowIndex).append(",").append(colIndex).append("=");

            /* Cell processing starts here*/

                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_BOOLEAN:

                            sb.append(cell.getBooleanCellValue()); //.append("\n");
                            outputFile.write(sb.toString());

                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell))
                            {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                String  strCellValue = dateFormat.format(cell.getDateCellValue());
                                sb.append(strCellValue); //.append("\n");
                                outputFile.write(sb.toString());


                            }
                            else
                            {
                                //System.out.println(cell.getNumericCellValue());
                                Double value = cell.getNumericCellValue();
                                Long longValue = value.longValue();
                                String strCellValue = new String(longValue.toString());

                                sb.append(strCellValue); //.append("\n");
                            }
                            break;

                        case Cell.CELL_TYPE_STRING:
                            if (cell.getRichStringCellValue() != null) {
                                String strCellValue=cell.getRichStringCellValue().getString();
                                if (strCellValue != null){
                                    strCellValue = strCellValue.trim();
                                    if (! strCellValue.isEmpty()){
                                        sb.append(strCellValue); //.append("\n");
                                        outputFile.write(sb.toString());
                                    }
                                }
                            }
                                break;

                        case Cell.CELL_TYPE_BLANK:
                            //cellDData.append("" +",");
                            break;

                        default:
                            break;
                    }
                }

            }
            outputFile.close();
            wb.close();
        } catch ( Exception e){
            e.printStackTrace();
        }

        return outputFile;
    }




}



