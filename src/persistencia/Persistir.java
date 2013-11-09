package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	
	public void persistirTareaGastos(Tarea T){
		try {
			FileOutputStream file=new FileOutputStream(new File("Tareas.dat"));
			ObjectOutputStream oos=new ObjectOutputStream(file);
			oos.writeObject(T);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
