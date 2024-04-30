import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1Prueba2 {
    public static void main(String[] args) throws IOException {
        File fichero = File.listRoots()[0];

        int option;
        int contador;

        do{
            if (fichero != null) {
                System.out.print("EL DIRECTORIO ACTUAL ES: " + fichero.getCanonicalPath() + "\n");
                System.out.println("_____________________");
                System.out.println("FICHEROS Y DIRECTORIOS");


                contador = 0;


                for (File f : fichero.listFiles()) {
                    if (f.isFile()) {
                        contador++;
                        System.out.println(contador + ". " + f.getName() + " " + f.length() + " KB");
                    } else {
                        contador++;
                        System.out.println(contador + ". " + f.getName() + " " + "<Directorio>");
                    }
                }
            }
            option = getOption();



            if (option == 0){

                if (fichero.getParentFile() == null){
                    System.out.println("NO EXISTE DIRECTORIO PADRE!");
                }else{
                    fichero = fichero.getParentFile();
                    System.out.println(Arrays.toString(fichero.listFiles()));}
            }else{
                if (option > 0 && option < fichero.listFiles().length){
                    if (fichero.listFiles()[option -1].isDirectory() && fichero.listFiles()[option -1].canRead()) {
                        fichero = fichero.listFiles()[option - 1];
                    }
                }
            }

        }while (option!=-1);
    }

    public static int getOption(){
        Scanner escaner = new Scanner(System.in);
        System.out.println("SELECCIONA UNA OPCIÓN: ");
        return escaner.nextInt();
    }
}
