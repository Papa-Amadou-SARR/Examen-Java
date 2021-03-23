package sn.isi.client;

import sn.isi.entities.Client;
import sn.isi.entities.Marketeur;

import java.util.Scanner;

public class Menu {
    private Client client;
    int choix=0;
    private Scanner sc = new Scanner(System.in);


    public Client saisie(){

        Marketeur mark = null;
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|-----------Veuillez vous connectez en tant que marketeur---------|");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1-Se connecter\n "+


                           "1-Creer un mailing\n " +
                           "2-Editer un mail\n" +
                           "3-Recercher un mail\n" +
                           "3-visualiser un mailing\n");

        choix= sc.nextInt();
        switch (choix){
            case 1:
                IMarketeur im = new MarketeurImp();
                Client client = new Client();
                //im.Menu(Client client);
                break;
        }
        if(choix == 1){
            IMarketeur im = new MarketeurImp();
            mark = new Marketeur();

    }

        return client;
    }
}
