import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProcesoCompetidores {
    private static final String FILE_PATH = ".." + File.separator + "Fichero.txt";
    private static final String FILE_JAR = ".." + File.separator + "GeneradorLineas" +
                                                File.separator + "out"+
                                                File.separator + "artifacts"+
                                                File.separator + "GeneradorLineas_jar"+
                                                File.separator + "GeneradorLineas.jar";

    public static void main(String[] args) {
    ProcessBuilder pb = new ProcessBuilder();

        for (int i = 0; i < 100 ; i++) {
            pb.command("java","-jar",FILE_JAR,FILE_PATH," Proceso" + i);
            try {
                pb.start();
            } catch (IOException ex) {
                System.getLogger(ProcesoCompetidores.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }

    }
}