package demo.api.call;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import static demo.api.call.Constants.loadConfig;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class CommandLineInterface {

    public static void inputCharacter() throws IOException {
        Scanner input= new Scanner(System.in);
        loadConfig();
        String id = "";
        log.println("Selecciona un heroe:");
        log.println("1 - Spiderman" +
                "\n2 - Capitan America" +
                "\n3 - Thor" +
                "\n4 - Iron Man" +
                "\n5 - Hulk" +
                "\n———————————————————");
        log.print("numero : ");

        String characterSelected = input.nextLine();

        Properties constant = Constants.property;
        switch (characterSelected){
            case "1":
                id = constant.getProperty("SPIDERMAN_ID");
                break;
            case "2":
                id = constant.getProperty("CAPITAN_AMERICA_ID");
                break;
            case "3":
                id = constant.getProperty("THOR_ID");
                break;
            case "4":
                id = constant.getProperty("IRON_MAN_ID");
                break;
            case "5":
                id = constant.getProperty("HULK_ID");
                break;
            default:
                log.println("Numero no valido!\nDebe seleccionar uno del 1 al 5");
                break;
        }
        log.println("id elegido" + id);
        ApiCall.result(id);
    }
}
