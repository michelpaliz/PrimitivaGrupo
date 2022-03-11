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

    public void subMenu() {

        do {
            StringBuilder subMenu = new StringBuilder();
            subMenu.append("****ELIGE UNA MODALIDAD DE JUEGO *****\n");
            subMenu.append("1. Juego Unico\n");
            subMenu.append("2.Jugar hasta obtener un premio(con reintegro)\n");
            subMenu.append("3.Jugar hasta obtener un premio (Sin reintegro)\n");
            subMenu.append("4.Ciclo de 10000 sorteos\n");
            subMenu.append("5.Jugar hasta obtener premio categoria especial\n");
            subMenu.append("************************************\n");
            subMenu.append("0.Para Salir\n");
            System.out.println(subMenu.toString());
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt >= 0 && userInt <= 5;

        } while (!correct);

        numerosComputer.setNumerosElegidos(generarRandomComputer());
        int comple = bomboComputer.extraerBola();
        numerosComputer.setNumeroComp(comple);
        int reintegro = r.nextInt(Config.MAX_RND-Config.MIN_RND+1)+Config.MIN_RND;
        numerosComputer.setNumReintegro(reintegro);

        switch (userInt) {
            case 1:
                juegoUnico();
                break;
            case 2:
                jugarHastaPremio();
                break;
            case 3:
                jugarHastaPremioSR();
                numerosUser.setNumReintegro(0);
                break;
            case 4:
                sorteo1000();
                break;
            case 5:
                jugarHastaCategoriaESP();
                break;
            case 0:
                System.out.println("Adios");
        }
    }

}
