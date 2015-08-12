package by.guru13.store;

import by.guru13.models.clinic.Client;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ASUS on 12.08.2015.
 */
public class ClientCash {
    private static final ClientCash INSTANCE = new ClientCash();

    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<Integer, Client>();

    public static ClientCash getInstance(){
        return INSTANCE;
    }
    public Collection<Client> values(){
        return this.clients.values();
    }
    public void add(final Client client){
        this.clients.put(client.getId(), client);
    }
    public void edit(final Client client){
        this.clients.replace(client.getId(), client);
    }
    public void delete(final int id){
        this.clients.remove(id);
    }
    public Client get(final int id){
        return this.clients.get(id);
    }
}
