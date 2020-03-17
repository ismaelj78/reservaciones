import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class GenerarExcel {
    
    public void generarExcel(String [][] entrada, String ruta){
        //WritableWorkbook libro1= null;
        try {
            WorkbookSettings conf= new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");
            WritableWorkbook libro1 = Workbook.createWorkbook(new File(ruta),conf);
            WritableSheet hoja1= libro1.createSheet("Resultado", 0);
            WritableFont f1= new WritableFont(WritableFont.ARIAL,16,WritableFont.BOLD);
            WritableCellFormat f1format= new WritableCellFormat(f1);
            
            for(int i=0;i< entrada.length;i++){
                for(int j=0;j<entrada[i].length;j++){
                    
                    hoja1.addCell(new jxl.write.Label(j,i,entrada[i][j],f1format));
                }
            }
            libro1.write();
            libro1.close();
        }
            catch (IOException ex) {
            Logger.getLogger(GenerarExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (WriteException ex){
                    Logger.getLogger(GenerarExcel.class.getName()).log(Level.SEVERE,null,ex);
            } 
    }
    
}
