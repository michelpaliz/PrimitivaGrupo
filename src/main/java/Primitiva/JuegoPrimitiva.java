package Primitiva;

//*IMPORTS PARA OPERACIONES
import Primitiva.config.Bombo;
import Primitiva.config.Config;

import java.util.Scanner;
import java.util.Random;

public class JuegoPrimitiva {
// Variables Globales
    // Scanner & Random
    Scanner myInput = new Scanner(System.in);
    Random r = new Random();

    //Bombo de 49 Numeros
    Bombo bombo49 = new Bombo(49,1);
    Bombo bomboComputer = new Bombo(49,1);

    //Para los numeros del usuario y del sistema
    Primitiva numerosUser = new Primitiva();
    Primitiva numerosComputer = new Primitiva();

    // Para uso de Operaciones
    int userInt;
    boolean correct;

    //cuantas vez ha ganado en cada categoria
    int cateEspe, cateUno, cateDos, cateTres, cateQuat, cateCinco;

    int primerNumero, segundoNumero, tercerNumero, cuartoNumero, quintoNumero, sextoNumero;
    // +Todo variable para contar los numeros de intentos

    public void menu() {
        do {
            System.out.println("*******JUEGO DE LA PRIMITIVA ******");
            System.out.println("Para empezar necesitamos que escojas 6 numeros");
            System.out.println("Tienes dos opciones");
            System.out.println("1.Introducir los numeros manualmente");
            System.out.println("2.Introducir los numeros automaticamente");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt > 0 && userInt <= 2;

        } while (!correct);
        int reintegro = r.nextInt(Config.MAX_RND-Config.MIN_RND+1)+Config.MIN_RND;
        numerosUser.setNumReintegro(reintegro);
        int comple = bombo49.extraerBola();
        numerosUser.setNumeroComp(comple);
        switch (userInt) {
            case 1:
                System.out.println("Seleccion de numeros");
                numerosUser.setNumerosElegidos(validarNumeros());
                System.out.println(numerosUser);
                break;
            case 2:
                System.out.println("El sistema generara 6 numero automaticamente para ti");
                numerosUser.setNumerosElegidos(generatorRandom());
                System.out.println(numerosUser);
                break;
        }

    }

}
