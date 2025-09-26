import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        /*args recibirá 2 parametros
        * 0. Ruta relativa o absoluta hacia un fichero
        * 1. Nombre del proceso
        * Escribe en el fichero el nombre del proceso
        * */
        if(args.length != 2 ){
            System.err.println("El numero de parameters es incorreto");
            System.exit(1);
        }

        File fichero = new File(args[0]);
        try (
            FileOutputStream fo = new FileOutputStream(fichero, true);
            PrintWriter pw = new PrintWriter(fo)
        ) {
            // Comprobar el estado del recurso
            FileChannel canal = fo.getChannel();

            //Candado
            FileLock candado = canal.lock();
            // Inicio region critica
            pw.println("Inicio " + args[1]);
            pw.flush();

            Thread.sleep(200);
            pw.println("Fin " + args[1]);
            pw.flush();

            //Fin region critica

            //Libera el recurso
            candado.release();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
