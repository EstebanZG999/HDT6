import java.util.*;
import java.io.*;


public class Controlador {

    Scanner scan = new Scanner(System.in);
    String eleccion;
    String num;
    ArrayList<String> array = new ArrayList<String>();

    public void principal(){
        //Reader read = new Reader();
        System.out.println("Escribir la eleccion que desea realizar: hashmap, treemap, linkedhashmap");
        eleccion = scan.next();
        eleccion = eleccion.toLowerCase();
        num = eleccion;
        String datos = "C:\\Users\\esteb\\IdeaProjects\\HDT6\\src\\ListadoProducto (2).txt";
        Map map = MapFactory.MAPFactory(eleccion);
        try (BufferedReader br = new BufferedReader(new FileReader(datos))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String key = parts[0].trim();
                String value = parts[1].trim();
                array.add(value);
                map.put(key, array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }
    }


