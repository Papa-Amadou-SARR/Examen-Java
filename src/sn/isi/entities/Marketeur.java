package sn.isi.entities;

public class Marketeur {
    private int idMak;
    private String nomMak, emailMark, password;

    public Marketeur() {
    }

    public Marketeur(int idMak, String nomMak, String emailMark, String password) {
        this.idMak = idMak;
        this.nomMak = nomMak;
        this.emailMark = emailMark;
        this.password = password;
    }

    public String getEmailMark() {
        return emailMark;
    }

    public void setEmailMark(String emailMark) {
        this.emailMark = emailMark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdMak() {
        return idMak;
    }

    public void setIdMak(int idMak) {
        this.idMak = idMak;
    }

    public String getNomMak() {
        return nomMak;
    }

    public void setNomMak(String nomMak) {
        this.nomMak = nomMak;
    }
}
