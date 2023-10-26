package view;

import controller.ArquivosController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArquivosController fileC = new ArquivosController();
        String path = "C:\\TEMP";
        String name = "generic_food.csv";
        try {
            fileC.readFile(path,name);

        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
