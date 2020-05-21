package com.training.dataproviders;

import java.util.List;
import org.testng.annotations.DataProvider;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
//import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ApachePOIExcelRead2;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders2 {

	@DataProvider(name = "db-inputs for mytest")
	public static Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs for mytest")
	public static Object[][] getExcelData(){
		String fileName ="C:\\Users\\PrithaBanerjee\\Documents\\training java program\\Selenium\\SeleniumLab.xlsx"; 
		String sheetname="Sheet1";
		List<List<Object>> retVal= ApachePOIExcelRead2.getExcelContent(fileName,sheetname);
		System.out.println("size" + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()];
		int count=0;
		
		for(List<Object> temp : retVal){
			if(temp!=null){
				Object[] obj = new Object[4];
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				
				obj[0]=temp.get(0);
				obj[1]=temp.get(1);
				obj[2]=temp.get(2);
				obj[3]=temp.get(3);
				
				result[count ++]= obj;
			}
		}
		return result;
		
		
	}
	
	@DataProvider(name = "excel-inputs for mytest1")
	public static Object[][] getExcelData1(){
		String fileName ="C:\\Users\\PrithaBanerjee\\Documents\\training java program\\Selenium\\SeleniumLab.xlsx"; 
		String sheetname="Sheet2";
		List<List<Object>> retVal= ApachePOIExcelRead2.getExcelContent(fileName,sheetname);
		System.out.println("size" + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()];
		int count=0;
		
		for(List<Object> temp : retVal){
			if(temp!=null){
				Object[] obj = new Object[7];
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				System.out.println(temp.get(4));
				System.out.println(temp.get(5));
				System.out.println(temp.get(6));
				
				obj[0]=temp.get(0);
				obj[1]=temp.get(1);
				obj[2]=temp.get(2);
				obj[3]=temp.get(3);
				obj[4]=temp.get(4);
				obj[5]=temp.get(5);
				obj[6]=temp.get(6);
				
				result[count ++]= obj;
			}
		}
		return result;
		
		
	}
	
	@DataProvider(name = "excel-inputs for mytest2")
	public static Object[][] getExcelData2(){
		String fileName ="C:\\Users\\PrithaBanerjee\\Documents\\training java program\\Selenium\\SeleniumLab.xlsx"; 
		String sheetname="Sheet3";
		List<List<Object>> retVal= ApachePOIExcelRead2.getExcelContent(fileName,sheetname);
		System.out.println("size" + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()];
		int count=0;
		
		for(List<Object> temp : retVal){
			if(temp!=null){
				Object[] obj = new Object[8];
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				System.out.println(temp.get(4));
				System.out.println(temp.get(5));
				System.out.println(temp.get(6));
				System.out.println(temp.get(7));
				
				obj[0]=temp.get(0);
				obj[1]=temp.get(1);
				obj[2]=temp.get(2);
				obj[3]=temp.get(3);
				obj[4]=temp.get(4);
				obj[5]=temp.get(5);
				obj[6]=temp.get(6);
				obj[7]=temp.get(7);
				
				
				result[count ++]= obj;
			}
		}
		return result;
		
		
	}
	
	@DataProvider(name = "xls-inputs for mytest")
	public static Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Users\\PrithaBanerjee\\Documents\\training java program\\Selenium\\SeleniumLab.xlsx", "Sheet1"); 
	}
}
