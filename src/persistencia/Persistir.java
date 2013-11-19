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
import java.text.DateFormat;
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
 		DateFormat formatoDelTexto = new SimpleDateFormat("dd-MMM-yy");
 		Date fecha = null;
 		Boolean LlegoAlFinal = false; 	
 		String lineaLeida = "";
 		System.out.println("Hasta aca llego");
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
						fecha = (Date)formatoDelTexto.parse(separador[4]);
						} catch (ParseException ex) {
						ex.printStackTrace();
						}
					a.setFecha(fecha);
					System.out.println(separador[0] + separador[1] + separador[2] + separador[3] + separador[4]);
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
 	
 	public void guardarGastos(ColeccionGastos lista){
 		 String lineaParaEscribir = new String(" "); 
 		 int cont;
 		 SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yy");
 		 String fecha = new String(" "); 
 		 FileWriter fichero = null;
         PrintWriter pw = null;
         try
         { // Si hacemos "fichero = new FileWriter("Gastos2.txt", true);" escribe al final del archivo
             fichero = new FileWriter("Gastos.txt");
             pw = new PrintWriter(fichero);
             
             for( cont=0; cont < lista.getColeccion().size() ; cont++){
 				System.out.println("ENTRO AL for");
 				fecha = formato.format(lista.getColeccion().get(cont).getFecha());
 				lineaParaEscribir =	new String(lista.getColeccion().get(cont).getDetalle() + ";" + lista.getColeccion().get(cont).getCantidad() + ";" + lista.getColeccion().get(cont).getUnitario() + ";" + lista.getColeccion().get(cont).getMonto() + ";" + fecha +";");				
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
 	
}
 	