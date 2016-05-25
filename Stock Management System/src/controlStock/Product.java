package controlStock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.Character.UnicodeBlock;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Product {
	private static int id;
	private static String title;
	private static String author;
	private static String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString(){
		return id + "\t" + title + "\t" + author + "\t" + content;
	}
	
	public static void write() throws Exception{
		/*%-10s Align-Center,%-15s Align-Right (Note:s is String) 
		 *%15s Align-Right
		 */
		String leftAlignFormat = "\t║ %-11s        ║ %-13s     ║ %-20s     ║ %-11s       ║%n";
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
		Product p=new Product();
		LinkedHashSet<String> product=new LinkedHashSet<String>();
		//TreeSet<String> listProduct=new TreeSet<String>();
		//System.out.println("ID\t" + "Title\t" + "Author\t" + "Content\t");
		System.out.format("\t╔════════════════════╦═══════════════════╦══════════════════════════╦═══════════════════╗%n");
		System.out.format("\t║        ID          ║     TITLE         ║          AUTHOR          ║       DATE        ║%n");
		System.out.format("\t╠════════════════════╬═══════════════════╬══════════════════════════╬═══════════════════╣%n");
		for(int i=0;i<100;i++){
			p.setId(i+1);
			p.setTitle("Title");
			p.setAuthor("Author");
			p.setContent("Content");
			System.out.format(leftAlignFormat, id, (title.length()>10)?title.substring(0, 10)+"...":title, (author.length()>10)?author.substring(0, 10)+"...":author, dateFormat.format(date) );
			System.out.format("\t╠════════════════════╬═══════════════════╬══════════════════════════╬═══════════════════╣%n");
			product.add(p.toString());
		}
		FileOutputStream fout=new FileOutputStream("C:/Users/Heng MengTang/Desktop/test.txt");
		ObjectOutputStream ob=null;
		ob = new ObjectOutputStream(fout);
		ob.writeObject(product);
		ob.close();
		//product.addAll(product);
		/*Iterator<String> it=product.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
	}
	
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		
		try {
			write();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		long totalTime=endTime-startTime;
		System.out.println(totalTime);
		
		
	}
}
