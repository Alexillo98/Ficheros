import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        File fichero = File.listRoots()[0];

        List<File> files = new ArrayList<>();

        Scanner escaner = new Scanner(System.in);
        int option;
        int contador = 0;

        System.out.print("LISTA DE FICHEROS Y DIRECTORIOS DEL DIRECTORIO: "+ fichero + "\n");

        for (File f : fichero.listFiles()) {
            if (f.isFile()) {
                files.add(f);
                System.out.println(contador + ". " + f.getName() + " " + f.getTotalSpace() + " KB");
                contador++;
            } else if (f.isDirectory()) {
                files.add(f);
                System.out.println(contador + ". " + f.getName() + " <Directorio>");
                contador++;
            }
        }

        files = new ArrayList<>();

        option = getOption();

        String path = String.valueOf(files.get(option));

        File fichero2 = new File(path);

        if (fichero2.isDirectory()){
            for (File f2: fichero2.listFiles()){
                System.out.println(f2.getName() + " <Directorio>");
            }
        }

    }
    private static int getOption () {
        Scanner escaner = new Scanner(System.in);
        System.out.println("INTRODUCE UNA OPCION (-1 PARA SALIR):");
        return escaner.nextInt();
    }
}
