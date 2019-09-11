package tradutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Vector;

public class BaseDeDados {
	
	public static void escreverPT(Vector v) throws IOException {
		
		try{
			
			FileOutputStream arquivo = new FileOutputStream("C:\\Users\\Sys\\Desktop\\ISUTC\\4º semestre\\Programação III\\Tradutor\\src\\tradutor\\PalavrasPT.dat");
		    ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);
			    
		    objGravar.writeObject(v);
		    objGravar.flush();
		    objGravar.close();
		    arquivo.flush();
		    arquivo.close();
		}
			
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void escreverIN(Vector v) throws IOException {
		
		try{
			
			FileOutputStream arquivo = new FileOutputStream("C:\\Users\\Sys\\Desktop\\ISUTC\\4º semestre\\Programação III\\Tradutor\\src\\tradutor\\PalavrasIN.dat");
		    ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);
			    
		    objGravar.writeObject(v);
		    objGravar.flush();
		    objGravar.close();
		    arquivo.flush();
		    arquivo.close();
		}
			
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void lerPT(Vector v) {
		
		try{
			FileInputStream arquivo= new FileInputStream("C:\\Users\\Sys\\Desktop\\ISUTC\\4º semestre\\Programação III\\Tradutor\\src\\tradutor\\PalavrasPT.dat");
		    ObjectInputStream objLeitura = new ObjectInputStream(arquivo);
		    v.addAll((Collection<?>) objLeitura.readObject());
		    objLeitura.close();
		    arquivo.close();
		 }
	 
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void lerIN(Vector v) {
		
		try{
			FileInputStream arquivo= new FileInputStream("C:\\Users\\Sys\\Desktop\\ISUTC\\4º semestre\\Programação III\\Tradutor\\src\\tradutor\\PalavrasIN.dat");
		    ObjectInputStream objLeitura = new ObjectInputStream(arquivo);
		    v.addAll((Collection<?>) objLeitura.readObject());
		    objLeitura.close();
		    arquivo.close();
		 }
	 
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	
}
