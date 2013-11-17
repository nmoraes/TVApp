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
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Gastos.ColeccionGastos;
import Gastos.Gasto;
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
	

 	public ColeccionGastos LeerGastos(){
		
 		ColeccionGastos listaGastos =new ColeccionGastos();
 		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dow mon dd hh:mm:ss zzz yyyy");
 		Date fecha = null;
 		Boolean LlegoAlFinal = false; 	
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
		
				
		while(!(LlegoAlFinal)){
						
			try{
				lineaLeida = lector.readLine();
			} catch (IOException err){
				
			}
		
			if (lineaLeida == null){
				LlegoAlFinal = true;
			}else{
				
				String[] separador;
				separador = lineaLeida.split(";");
				//Si los datos fueron cargador de forma correcta entonces los agrega al arreglo, si no sigue en busca de datos bien cargados 
				if (separador.length == 5){
					
					Gasto a = new Gasto(separador[0], separador[1], separador[2], separador[3]);
					
					try {
						fecha = formatoDelTexto.parse(separador[4]);
						} catch (ParseException ex) {
						ex.printStackTrace();
						}
					a.setFecha(fecha);
					
					listaGastos.agregarGasto(a);
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
		
		return listaGastos;
	}
 	
 	public void guardarGastos2(ColeccionGastos lista){
 		 String lineaParaEscribir = new String(" "); 
 		 int cont;
 		 FileWriter fichero = null;
         PrintWriter pw = null;
         try
         {
             fichero = new FileWriter("Gastos2.txt", true);
             pw = new PrintWriter(fichero);
             
             for( cont=0; cont < lista.getColeccion().size() ; cont++){
 				System.out.println("ENTRO AL for");
 				lineaParaEscribir =	new String(lista.getColeccion().get(cont).getDetalle() + ";" + lista.getColeccion().get(cont).getCantidad() + ";" + lista.getColeccion().get(cont).getUnitario() + ";" + lista.getColeccion().get(cont).getMonto() + ";" + lista.getColeccion().get(cont).getFecha().toString() +";");				
 				System.out.println(lineaParaEscribir);
                pw.println(lineaParaEscribir);
             }
  
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
            try {
            // Nuevamente aprovechamos el finally para 
            // asegurarnos que se cierra el fichero.
            if (null != fichero)
               fichero.close();
            } catch (Exception e2) {
               e2.printStackTrace();
            }
         }
 	}
 	 public void guardarGastos(ColeccionGastos lista) throws IOException {
         BufferedWriter escritor = null;
         String lineaParaEscribir = "";
 		 int cont;
 		 
 		for( cont=0; cont < lista.getColeccion().size() ; cont++){
				System.out.println("ENTRO AL for");
			lineaParaEscribir =	new String(lista.getColeccion().get(cont).getDetalle() + ";" + lista.getColeccion().get(cont).getCantidad() + ";" + lista.getColeccion().get(cont).getUnitario() + ";" + lista.getColeccion().get(cont).getMonto() + ";" + lista.getColeccion().get(cont).getFecha().toString() +";");				
			System.out.println(lineaParaEscribir);
			try {
				System.out.println("Entro a escribir");
  //           FileInputStream ficheroProp = new FileInputStream("src/diccionarioPredictivo/config/parametros.properties");
  //           prop.load(ficheroProp);
				File archivo = new File("Gastos2.txt");
				escritor = new BufferedWriter(new FileWriter(archivo, true)); //true es para sobreescribir el original si existe, sino lo crea
				escritor.write("\r\n" + lineaParaEscribir.toLowerCase()); //en Windows el salto de linea es con \r\n
				} catch (IOException e) {
					throw new IOException("Error al escribir la palabra en el archivo de texto.");
				} finally {
					escritor.close();
				}
 			}
 		}
 	
 	public void persistirGastos(ColeccionGastos lista){
 		String lineaParaEscribir = "";
		int cont;
		FileWriter archivo;
	 	archivo = null;
		System.out.println("**Entro a persistencia");
	  	 	 	 		
 		try {
			archivo = new FileWriter("Gastos.txt");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
 		BufferedWriter escritor = new BufferedWriter(archivo);
 
 		for( cont=0; cont < lista.getColeccion().size() ; cont++){
 				System.out.println("ENTRO AL for");
 			lineaParaEscribir =	new String(lista.getColeccion().get(cont).getDetalle() + ";" + lista.getColeccion().get(cont).getCantidad() + ";" + lista.getColeccion().get(cont).getUnitario() + ";" + lista.getColeccion().get(cont).getMonto() + ";" + lista.getColeccion().get(cont).getFecha().toString() +";");				
 			System.out.println(lineaParaEscribir);
 			// /r/n para el salto de linea
 							
 				try{
 					System.out.println("****ENTRO A ESCRIBIR");
 					escritor.write(lineaParaEscribir);
 					//escritor.newLine();
 					} catch (IOException err){
 					System.out.print("Fallo");
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
