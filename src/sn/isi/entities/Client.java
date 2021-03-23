package sn.isi.entities;

import java.util.Scanner;

public class Client {
    Scanner sc = new Scanner(System.in);
    private int id;
    private String nom,prenom,email,tel;
    private Marketeur marketeur =new Marketeur();

    public Client() {
    }

    public Client(int id, String nom, String prenom, String email, String tel, Marketeur marketeur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.marketeur = marketeur;
    }

    public Client(int anInt, String string, String nString, String string1, String string2) {

    }

    public Marketeur getMarketeur() {
        return marketeur;
    }

    public void setMarketeur(Marketeur marketeur) {
        this.marketeur = marketeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void saisie(Client client) {
        System.out.println("Donner le Nom: ");
        client.setNom(sc.nextLine());
        System.out.println("Donner le Prenom: ");
        client.setPrenom(sc.nextLine());
        System.out.println("Donner la mail: ");
        client.setEmail(sc.nextLine());
        System.out.println("Entrer le numero de telephone: ");
        client.setTel(sc.nextLine());
    }

}
