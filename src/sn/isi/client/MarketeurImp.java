package sn.isi.client;


import sn.isi.entities.Client;
import sn.isi.entities.Marketeur;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketeurImp implements IMarketeur {
    private Db db = new Db();
    Scanner sc = new Scanner(System.in);
    ResultSet rs = null;
    Marketeur mark = null;
    String rep;
    int ok;

    @Override
    public List<Marketeur> VerifierConnexion(Marketeur m) throws Exception {
        db.open();
        List<Marketeur> LMark = new ArrayList<>();
        String sql = "SELECT * FROM marketeur";
        db.init(sql);
        rs = db.executeSelect();
        while (rs.next()) {
            Marketeur Lmark = new Marketeur();
            mark.setIdMak(rs.getInt(1));
            mark.setEmailMark(rs.getString(2));
            mark.setPassword(rs.getString(3));
        }
        return LMark;
    }

    @Override
    public Marketeur connect() throws Exception {

        mark = new Marketeur();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|---------------Se connecter en tant que marketeur---------------|");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("Entrer votre email");
        mark.setEmailMark(sc.nextLine());
        System.out.println("Entrer votre mot de passe");
        mark.setPassword(sc.nextLine());
        return mark;
    }

    @Override
    public int Menu() throws Exception {
        int choix;
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|-----------Veuillez faire votre choix---------|");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1-Creer client\n "+
                           "2-Editer\n " +
                           "3-Visualiser\n" +
                           "4-Rechercher\n" +
                           "5-Quitter\n");
        choix= sc.nextInt();
        return choix;
    }

    @Override
    public int add(Client client) throws Exception {
        do {
            client.saisie(client);
            String sql = "INSERT INTO client VALUES(NULL,?,?,?,?,?)";
            db.init(sql);
            db.getPstm().setString(1, client.getNom());
            db.getPstm().setString(2, client.getPrenom());
            db.getPstm().setString(3, client.getEmail());
            db.getPstm().setString(4, client.getTel());
            db.getPstm().setInt(5, client.getMarketeur().getIdMak());
            ok = db.executeUdate();
            db.close();
            System.out.println("Voulez vous continuer ? O/N");
            rep = sc.nextLine();
        }while (rep.equalsIgnoreCase("O"));

        return ok;
    }

    @Override
    public int Edition(Client client, Integer idE) throws Exception {

        String sql = "UPDATE client SET nom =?, prenom =?, email =? , tel = ? WHERE id = ?";
        db.init(sql);
        //client.saisie(client);
        db.getPstm().setString(1,client.getNom());
        db.getPstm().setString(2,client.getPrenom());
        db.getPstm().setString(3,client.getEmail());
        db.getPstm().setString(4,client.getTel());
        db.getPstm().setInt(5,idE);
        ok = db.executeUdate();
        return ok;
    }

    @Override
    public List<Client> Visualisation() throws Exception{
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM client ";
        db.init(sql);
        rs = db.executeSelect();
        while (rs.next()){
            Client cli = new Client();
            cli.setId(rs.getInt(1));
            cli.setNom(rs.getString(2));
            cli.setPrenom(rs.getNString(3));
            cli.setEmail(rs.getString(4));
            cli.setTel(rs.getString(5));
            list.add(cli);
        }
        return list;
    }

    @Override
    public Client RechercherClient() throws Exception {
        Client client = new Client();
        //Client client = null;
        db.open();
        System.out.println("Donner l'email: ");
        String email = sc.nextLine();
        String sql = "SELECT * FROM client c LEFT JOIN marketeur m ON (c.idM = m.idMark) WHERE c.email = ?";
        db.init(sql);
        db.getPstm().setString(1, email);
        ResultSet rs = db.executeSelect();

        if(rs.next()){
            client.setId(rs.getInt(1));
            client.setNom(rs.getString(2));
            client.setPrenom(rs.getString(3));
            client.setEmail(rs.getString(4));
            client.setTel(rs.getString(5));
            Marketeur marketeur = new Marketeur();
            marketeur.setIdMak(rs.getInt(6));
            marketeur.setEmailMark(rs.getString(7));
            marketeur.setPassword(rs.getString(8));
        }
        return client;
    }

}