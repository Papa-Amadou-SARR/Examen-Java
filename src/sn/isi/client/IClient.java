package sn.isi.client;

import sn.isi.entities.Client;

import java.util.List;

public interface IClient {
    public List<Client>getAll ()throws  Exception;
    Client saisie();
}
