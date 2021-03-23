package sn.isi.client;

import sn.isi.entities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClientImp implements IClient {
    Scanner sc = new Scanner(System.in);
    Db db = new Db();
    @Override
    public List<Client> getAll() throws Exception {
        List<Client> clients = new ArrayList<Client>();
        db.open();
        String sql = "SELECT * from client";
        db.init(sql);
        ResultSet res = db.executeSelect();
        while (res.next())
        {
           Client cli =new Client();
            cli.setId(res.getInt(1));
            cli.setNom(res.getString(2));
            cli.setPrenom(res.getString(3));
            cli.setEmail(res.getString(4));
            cli.setTel(res.getString(5));
            clients.add(cli);
        }
        return clients ;

    }
    public Client saisie() {
        Client client = new Client();
        client.setId(0);
        System.out.println("Donner le Nom: ");
        client.setNom(sc.nextLine());
        System.out.println("Donner le Prenom: ");
        client.setPrenom(sc.nextLine());
        System.out.println("Donner la mail: ");
        client.setEmail(sc.nextLine());
        System.out.println("Entrer le numero de telephone: ");
        client.setTel(sc.nextLine());
        return client;
    }
}
