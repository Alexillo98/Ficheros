import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1Prueba2 {
    public static void main(String[] args) throws IOException {
        File fichero = File.listRoots()[0];

        int option;
        int contador;

        do{
            System.out.print("EL DIRECTORIO ACTUAL ES: " + fichero.getCanonicalPath() + "\n");
            System.out.println("_____________________");
            System.out.println("FICHEROS Y DIRECTORIOS");

            contador = 0;

            for (File f: fichero.listFiles()){
                if (f.isFile()){
                    contador++;
                    System.out.println(contador + ". " + f.getName() + " " + f.length() + " KB");
                }else {
                    contador++;
                    System.out.println(contador + ". " + f.getName() + " " + "<Directorio>");
                }
            }

            option = getOption();

        if (option != 0 && option != -1){
            fichero = fichero.listFiles()[option - 1];
        }

        if (option == 0){
            System.out.println(fichero.getParentFile());
        }

        }while (option!=-1);
    }

    public static int getOption(){
        Scanner escaner = new Scanner(System.in);
        System.out.println("SELECCIONA UNA OPCIÓN: ");
        return escaner.nextInt();
    }
}
