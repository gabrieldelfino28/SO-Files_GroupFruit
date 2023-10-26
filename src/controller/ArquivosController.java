package controller;
import java.io.*;

public class ArquivosController {
    public ArquivosController() {
        super();
    }

    public void readFile(String path, String name) throws IOException {
        File dir = new File(path);
        File fil = new File(path,name);
        if (dir.exists() && dir.isDirectory()) {
            if (fil.exists() && fil.isFile()) {
                BufferedReader buffer = new BufferedReader( new InputStreamReader( new FileInputStream(fil)));

                String linha = buffer.readLine();
                int maxFruitL = 0;
                int maxScienceL = 0;
                while (linha != null) {
                    if (linha.contains("Fruits")) {
                        String[] l = linha.split(",");
                        maxFruitL = Math.max(maxFruitL, l[0].length());
                        maxScienceL = Math.max(maxScienceL, l[1].length());
                    }
                    linha = buffer.readLine();
                }

                buffer.close();
                int nameLength = maxFruitL + 1;
                int scienceLength = maxScienceL +1;

                buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fil)));
                linha = buffer.readLine();
                while (linha != null) {
                    if (linha.contains("Fruits")) {
                        String[] l = linha.split(",");
                        String Fname = String.format("%-" + nameLength + "s", l[0]);
                        String scienceName = String.format("%-" + scienceLength + "s", l[1]);
                        System.out.println(Fname + " " + scienceName + " " + l[3]);
                    }
                    linha = buffer.readLine();
                }
            }
            else {
                throw new IOException("Arquivo Inválido");
            }
        }else {
            throw new IOException ("Diretório Inválido");
        }
    }

}
