import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class Ngram {

	private static DecimalFormat dec = new DecimalFormat("##.######");	
	StringBuilder result=new StringBuilder();
	
	
	JFileChooser fileChooser = new JFileChooser();


	public  void uniGram() throws Exception {

		if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			java.io.File file=fileChooser.getSelectedFile();

			long startTime = System.currentTimeMillis(); 
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(file));          
			String row = reader.readLine();

			ArrayList newArray=new ArrayList();

			while (row!=null) { 
				StringTokenizer st=new StringTokenizer(row,",. ?:-=;*-!({/})@\"") ;
				while(st.hasMoreTokens()){
					newArray.add(st.nextToken());
				}
				row = reader.readLine();
			}


			HashMap<String,Double> oneGram=new HashMap<String,Double>();
			double cone=0;

			for (int i = 0; i < newArray.size(); i++) {
				for (int j = 0; j <  newArray.size(); j++) {
					if(newArray.get(i).equals( newArray.get(j))){cone++;}
				}

				if(!oneGram.containsKey( newArray.get(i))) {
					oneGram.put( newArray.get(i).toString(),cone/ newArray.size());
				}
				cone=0;
			}   

			Set set = oneGram.entrySet();              	     
			Iterator i = set.iterator();
			int x = 1; 
			double value =0;

			while(i.hasNext() && x<101) { 

				Map.Entry me = (Map.Entry)i.next();

				result.append(x+".)");
				result.append(me.getKey() + " : ");              	      
				result.append(dec.format(me.getValue()));
				result.append("\n");
				x++;

			}  

			long endTime = System.currentTimeMillis();
			long estimatedTime = endTime - startTime;
			double seconds = (double)estimatedTime/1000;
			System.out.println();
			result.append("RUNNING TIME:  "+seconds);
		}
	}

	public  void biGram() throws Exception {

		if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			java.io.File file=fileChooser.getSelectedFile();
			ArrayList newArray=new ArrayList();
			long startTime = System.currentTimeMillis(); 
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(file));
			String row = reader.readLine();

			while (row!=null) { 
				StringTokenizer st=new StringTokenizer(row,",. ?:-=;-!(*{/})@\"");
				while(st.hasMoreTokens())
				{
					newArray.add(st.nextToken());
				}
				row = reader.readLine();
			}  
			HashMap<String,Double> twogram=new HashMap<String,Double>();   

			int ctwo=0;
			String twostring1=null;
			String twostring2=null;


			for (int i = 0; i <newArray.size()-1; i++) {
				for (int j = 0; j < newArray.size()-1; j++) {
					twostring1= newArray.get(i).toString()+" "+newArray.get(i+1).toString();
					twostring2= newArray.get(j).toString()+" "+newArray.get(j+1).toString();

					if(twostring1.equals(twostring2)){ctwo++;}

				} 


				Double count=(double)ctwo/newArray.size();

				if(!twogram.containsKey(twostring1)&&ctwo!=0)
				{
					twogram.put(twostring1,count);
				}
				ctwo=0;     	         
			}      	

			Set set = twogram.entrySet(); 
			Iterator i = set.iterator();
			int x=1;


			while(i.hasNext()&&x<101) { 

				Map.Entry me = (Map.Entry)i.next(); 
				result.append(x+".)");
				result.append(me.getKey() + " : "); 
				result.append(dec.format(me.getValue())); 
				result.append("\n");
				x++;

			} 

			long endTime = System.currentTimeMillis();
			long estimatedTime = endTime - startTime;
			double seconds = (double)estimatedTime/1000;
			System.out.println();

			result.append("RUNNING TIME:  "+seconds);

		}

	}

	public  void triGram() throws Exception {

		if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {

			java.io.File file=fileChooser.getSelectedFile();
			ArrayList newArray=new ArrayList();  long startTime = System.currentTimeMillis();
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(file));
			String row = reader.readLine();


			while (row!=null) { 
				StringTokenizer st=new StringTokenizer(row,",. ?:!-=;-(*{/})@\"");

				while(st.hasMoreTokens())
				{
					newArray.add(st.nextToken());
				}
				row = reader.readLine();
			}  
			HashMap<String,Double> threegram=new HashMap<String,Double>();

			int cthree=0;
			String twostring1=null;
			String twostring2=null;

			for (int i = 0; i <newArray.size()-2; i++) {
				for (int j = 0; j < newArray.size()-2; j++) {

					twostring1= newArray.get(i).toString()+ " "+ newArray.get(i+1).toString()+" "+newArray.get(i+2).toString();
					twostring2= newArray.get(j).toString()+" "+newArray.get(j+1).toString()+" "+newArray.get(j+2).toString();

					if(twostring1.equals(twostring2)){cthree++;}
				} 

				Double count=(double)cthree/newArray.size();

				if(!threegram.containsKey(twostring1)&&cthree!=0)
				{
					threegram.put(twostring1,count);
				}
				cthree=0;     	         
			}      	


			Set set = threegram.entrySet(); 
			Iterator i = set.iterator();
			int x=1;


			while(i.hasNext()&&x<101) { 
				Map.Entry me = (Map.Entry)i.next(); 
				result.append(x+".)");
				result.append(me.getKey() + " : "); 
				result.append(dec.format(me.getValue())); 
				result.append("\n");
				x++;
			} 
			long endTime = System.currentTimeMillis();
			long estimatedTime = endTime - startTime;
			double seconds = (double)estimatedTime/1000;

			System.out.println();
			result.append("RUNNING TIME:  "+ seconds);


		}


	}




}

