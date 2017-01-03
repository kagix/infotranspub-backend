package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.io;

import java.io.File;
import java.io.FilenameFilter;

public class ExcelFileFilter implements FilenameFilter{

    public static final String OLD_EXCEL_FORMAT=".xls";
    public static final String NEW_EXCEL_FORMAT=".xlsx";

    public static boolean detectExcelFileName(String path){
        String lowCasePath = path.toLowerCase();
        if (  (lowCasePath.endsWith(OLD_EXCEL_FORMAT))
            ||(lowCasePath.endsWith(NEW_EXCEL_FORMAT))  ){
            return true;
        }

        return false;
    }

    @Override
    public boolean accept(File pathname, String name) {
        String fullPath = pathname + "/" + name;
        File f = new File(fullPath);
        if ( f.isFile() &&  detectExcelFileName(name)){
            return true;
        }
        return false;
    }
}
