import com.sun.source.tree.WhileLoopTree;

import java.util.*;
import java.io.*;


public class Controlador {

    Scanner scan = new Scanner(System.in);
    String eleccion;
    int eleccion2;
    String num;
    Map<String, ArrayList<String>> map;
    Map<String, ArrayList<String>> carrito;
    boolean loop = true;
    String key;
    String valor2;
    String valores2;

    public void programa(){
        preguntar();
        reader();
        usuario();
    }

    public void reader(){
        String datos = "src/ListadoProducto (2).txt";
        try (BufferedReader br = new BufferedReader(new FileReader(datos))){
            String line;
                while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String key = parts[0].trim();
                String value = parts[1].trim();
                if (map.containsKey(key)) {
                    map.get(key).add(value);
                }else{
                    ArrayList<String> valuesList = new ArrayList<>();
                    ArrayList<String> carritoarray = new ArrayList<>();
                    valuesList.add(value);
                    carrito.put(key, carritoarray);
                    carritoarray.removeAll(carritoarray);
                    map.put(key, valuesList);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(map);
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
    public void usuario(){
        while(loop){
            System.out.println("Bienvienido al menu en linea: ");
            System.out.println("1. Agregar un producto a la colección del usuario: ");
            System.out.println("2. Mostrar la categoría del producto: ");
            System.out.println("3. Mostrar los datos del producto: ");
            System.out.println("4. Mostrar el producto y la categoría de todo el inventario: ");
            System.out.println("5. Mostrar el producto y la categoría de todo el inventario, ordenadas: ");
            System.out.println("6. Mostrar el producto y la categoría existentes: ");
            System.out.println("7. Salir");

            eleccion2 = scan.nextInt();
            scan.nextLine();
            if(eleccion2 == (1)){
                System.out.println("Escriba la categoria producto que quiere agregar a la coleccion: ");
                key = scan.nextLine();
                boolean elec = map.containsKey(key);
                if(elec){
                    System.out.println("Que producto desea agregar?: ");
                    valor2 = scan.next();
                    carrito.get(key).add(valor2);
                }if(!elec){
                    System.out.println("Producto invalido");
                }
            }
            if(eleccion2 == (2)){
                System.out.println("Escriba el nombre del producto: ");
                eleccion = scan.nextLine();
                String[] valores = map.keySet().toArray(new String[map.size()]);
                boolean finder = false;
                String valores2 = null;
                for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
                    String categoria = entry.getKey();
                    List<String> productos = entry.getValue();

                    if (productos.contains(eleccion)) {
                        finder = true;
                        valores2 = categoria;
                        break;
                    }
                }
                if(finder){
                    System.out.println("Categoria: "+ valores2);
                }
                else {
                    System.out.println("Categoria invalida");
                }

            }
            if(eleccion2 == 3){
                for (String key : carrito.keySet()) {
                    System.out.println(key + " : " + carrito.get(key));
                }
            }
            if(eleccion2 == 4){
                String[] valores = carrito.keySet().toArray(new String[carrito.size()]);
                List<String> alfabetico = Arrays.asList(valores);
                Collections.sort(alfabetico);
                for (String categoria : alfabetico) {
                    System.out.println(categoria + " -- " + carrito.get(categoria));
                }
            }
            if(eleccion2 == 5){
                profiler();
            }
            if(eleccion2 == 6){
                String[] valores = map.keySet().toArray(new String[map.size()]);
                List<String> alfabetico = Arrays.asList(valores);
                Collections.sort(alfabetico);
                for (String categoria : alfabetico) {
                    System.out.println(categoria + " -- " + map.get(categoria));
                }
            }
            if(eleccion2 == 7){
                loop = false;
            }
        }

    }

    public void preguntar(){
        System.out.println("Escribir la eleccion que desea realizar: hashmap, treemap, linkedhashmap");
        eleccion = scan.next();
        eleccion = eleccion.toLowerCase();
        num = eleccion;
        map = MapFactory.MAPFactory(eleccion);
        carrito = MapFactory.MAPFactory(eleccion);
    }

    public void profiler(){
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

}


