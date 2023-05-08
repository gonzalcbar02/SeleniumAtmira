package parameterization;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Hashtable;

public class TestNGParameterizationExcel {

    // FALTA ENCONTRAR LA LIBRERIA EXCELREADER
    //public static ExcelReader excelReader = null;


    @Test(dataProvider = "getData")
    public void testData(Hashtable<String,String> data){

        //System.out.println(username+"------"+password+"----------"+is_correct);

        System.out.println(data.get("username")+"----"+data.get("password")+"-----"+data.get("is_correct")+"-----"+data.get("age")+"-----"+data.get("gender"));

    }

    @DataProvider
    public static Object[][] getData() {

      /*if (excelReader == null){
            excelReader= new ExcelReader("C://selenium//tesstngdata.xlsx");
      }*/


        String sheetName = "loginTest";
        //int rows = excelReader.getRowCount(sheetName);
        //int cols = excelReader.getColumnCount(sheetName);
        //Object[][] data  = new Object[rows-1][cols];

        Hashtable<String,String> table = null;

        /*for (int rowNum = 2; rowNum <= rows; rowNum++){

            table = new Hashtable<String,String>();

            for (int colNum = 0; colNum < cols; colNum++){

                //data[rowNum-2][colNum] =   excelReader.getCellData(sheetName,colNum,rowNum);
                table.put(excelReader.getCellData(sheetName,colNum,1),excelReader.getCellData(sheetName,colNum,rowNum));

                data[rowNum-2][colNum] = table;
            }

        }

        return data;
        */

        // DESCOMENTAR TODO EL CODIGO CUANDO FUNFIONE LO DEMAS
        return null;
    }

}
