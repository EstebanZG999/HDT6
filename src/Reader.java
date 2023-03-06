import java.io.*;

public class Reader {
    public Reader() {

        File file = new File("C:\\Users\\esteb\\IdeaProjects\\HDT6\\src\\ListadoProducto (2).txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                System.out.println(st);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
