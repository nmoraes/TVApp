package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import Gastos.ContenedorGastos;
import Gastos.Tarea;
import twitter.Usuario;

public class Persistir {

	public void persistirUsuarioTwitter(Usuario usuario){
		try {
			FileOutputStream file=new FileOutputStream(new File("usuario.dat"));
			ObjectOutputStream oos=new ObjectOutputStream(file);
			oos.writeObject(usuario);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario leerUsuarioTwitter(){
		try{
			FileInputStream file=new FileInputStream(new File("usuario.dat"));
			ObjectInputStream ois=new ObjectInputStream(file);
			Usuario usuario=(Usuario)ois.readObject();
			ois.close();
			return usuario;
		}catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
// 	public void persistirTareaGastos(Tarea T){
//		try {
//			FileOutputStream file=new FileOutputStream(new File("Tareas.txt"));
//			ObjectOutputStream oos=new ObjectOutputStream(file);
//			oos.writeObject(T);
//			oos.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
 	public Tarea[] LeerTareaGastos(){
		// Para cargar utilizo un while que lo carge mientras que arreglo[cont] != null
 		Tarea[] arreglo;
 		arreglo = new Tarea[10];
 		Boolean noLlegoAlFinal = true; 	
 		String lineaLeida = "";
 		
 		FileReader archivo;
 		archivo = null;
 		try {
			archivo = new FileReader("Gastos.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader lector = new BufferedReader(archivo);
		
		int cont = 0;
		// Mientras que no se llene el arreglo o se llegue al final del archivo hacer:
		while(cont < arreglo.length && noLlegoAlFinal){
						
			try{
				lineaLeida = lector.readLine();
			} catch (IOException err){
				
			}
		
			if (lineaLeida == null){
				noLlegoAlFinal = false;
			}else{
				
				String[] separador;
				separador = lineaLeida.split(";");
				//Si los datos fueron cargador de forma correcta entonces los agrega al arreglo, si no sigue en busca de datos bien cargados 
				if (separador.length == 4){
					arreglo[cont] = new Tarea(separador[0], separador[1], separador[2], separador[3]);
					cont++;
				}
			}
		}
		
		try {
			archivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// El valor de tareas que se cargaron en el arreglo
		ContenedorGastos.contador = cont;
		return arreglo;
	}
 	/*
 	public HashMap<String, List<Tarea>> LeerGastos(){
		// Para cargar utilizo un while que lo carge mientras que arreglo[cont] != null
 		HashMap<String, List<Tarea>> gastos = new HashMap();
 		
 		Boolean noLlegoAlFinal = true; 	
 		String lineaLeida = "";
 		
 		FileReader archivo;
 		archivo = null;
 		try {
			archivo = new FileReader("Gastos.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader lector = new BufferedReader(archivo);
		
		
		// Mientras que no se llene el arreglo o se llegue al final del archivo hacer:
		while(noLlegoAlFinal){
						
			try{
				lineaLeida = lector.readLine();
			} catch (IOException err){
				
			}
		
			if (lineaLeida == null){
				noLlegoAlFinal = false;
			}else{
				
				
				String[] separador;
				separador = lineaLeida.split(";");
				//Si los datos fueron cargador de forma correcta entonces los agrega al arreglo, si no sigue en busca de datos bien cargados 
				if (separador.length == 5){
					gastos.put(separador[0], value)
					arreglo[cont] = new Tarea(separador[0], separador[1], separador[2], separador[3]);
					cont++;
				}
			}
		}
		
		try {
			archivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// El valor de tareas que se cargaron en el arreglo
		ContenedorGastos.contador = cont;
		return gastos;
	}*/
 	
 	public void persistirTareaGastos(Tarea[] T){
 		String lineaParaEscribir = "";
		int cont = 0;
		Boolean noLlegoAlFinal = true;
		FileWriter archivo;
	 	archivo = null;
		System.out.println("**Entro a persistencia");
	 	System.out.println(T[cont].getDetalle());
 	 	 	 		
 		try {
			archivo = new FileWriter("Gastos.txt");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
 		BufferedWriter escritor = new BufferedWriter(archivo);
 			System.out.println(T.length);
 		// Mientras que no se llene el arreglo o se llegue al final del archivo hacer:
 		while(cont < T.length && noLlegoAlFinal){
 				System.out.println("ENTRO AL WHILE");
 			if (T[cont] == null) {
 				noLlegoAlFinal = false;
 			}else{
 			lineaParaEscribir =	new String(T[cont].getDetalle() + ";" + T[cont].getCantidad() + ";" + T[cont].getUnitario() + ";" + T[cont].getMonto() + ";");				
 			cont++;
 			// /r/n para el salto de linea
 			System.out.println("ENTRO AL ELSE"); 				
 				try{
 					System.out.println("****ENTRO A ESCRIBIR");
 					escritor.write(lineaParaEscribir);
 					escritor.newLine();
 					} catch (IOException err){
 					System.out.print("Fallo");
 					}
 				
 			}
 			
 		}
 			
 			try {
 				archivo.close();
 			} catch (IOException err) {
 				// TODO Auto-generated catch block
 				err.printStackTrace();
 			}
 					
		
 	}
	
}
