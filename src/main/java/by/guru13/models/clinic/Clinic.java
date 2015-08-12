package by.guru13.models.clinic;

import by.guru13.models.clinic.animals.Pet;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * класс описывает клинику
 *
 * @auhtor alexey
 * @since 16.07.2015
 */
public class Clinic {


    private static  final Clinic INSTANCE = new Clinic();

    /**
     * Список клиентов
     */
    private final LinkedList<Client> clients = new LinkedList<Client>();

    /**
     * конструктор
     */
    private Clinic() {


    }

    public static Clinic getInstance() {
        return INSTANCE;
    }

    /**
     * @return массив клиентов
     */
    public LinkedList<Client> getClients() {
        return clients;
    }

    /**
     * Получение клиента по индексу
     *
     * @param index индекс клиента
     * @return возвращает клиента под данным индексом
     */
    public Client getClient(int index) {
        return clients.get(index-1);
    }

    /**
     * добавить клиента
     *
     * @param client клиент
     */
    public void addClient(final Client client) {
        this.clients.addLast(client);
    }


    /**
     * удалить клиента по имени
     *
     * @param name имя клиента
     */
    public void removeClientByName(final String name) {
        int j = 0;
        for (Iterator<Client> it = clients.iterator(); it.hasNext(); ) {
            if (it.next().getName().equals(name)) {
                it.remove();
                j = j + 1;
            }
        }
//        clients.remove(3);
//        for (Client client : clients){
//            if (client.getName().equals(name)){
//                j = client.getId();
//            }
//            clients.remove(j);
//        }
//        for (Client client : clients){
//            System.out.println(client);
//        }
        if (j != 0) {
            System.out.println("The client " + name + " has removed successfully");
        } else {
            System.out.println("This client doesn't exist in the base");
        }
    }
    public void removeClientById(final int id){
        clients.remove(id);
    }

    /**
     * найти клиентов по имени животного
     *
     * @param name имя животного
     */
    public LinkedList<Client> findClientsByPetName(final String name) {
        LinkedList<Client> foundedClients = new LinkedList<Client>();
        int i = 0;
        for (Client client : clients) {
            if (client != null && client.getPet().getName().equals(name)) {
                foundedClients.addLast(client);
                i++;
            }
        }
        return foundedClients;
    }

    /**
     * печать клиентов, найденных по имени животного
     *
     * @param name имя животинки
     */
    public void printClientsByPetName(final String name) {
        LinkedList<Client> foundedClients = findClientsByPetName(name);
        int j = 0;
        for (Client client : foundedClients) {
            if (client != null) {
                System.out.println(client.getId());
                j = j + 1;
            }
        }
        if (j == 0) {
            System.out.println("Client with that pet's name didn't find");
        }
    }

    /**
     * найти животных по имени клиента
     *
     * @param client имя клиента
     */
    public LinkedList<Pet> findPetsByClient(final String client) {
       LinkedList<Pet> foundedPets = new LinkedList<Pet>();
        int i = 0;
        for (Client clientId : clients) {
            if (clientId != null && clientId.getName().equals(client)) {
                foundedPets.addLast(clientId.getPet());
                i++;
            }
        }
        return foundedPets;
    }
    public LinkedList<Client> findClient(final String name){
        LinkedList<Client> foundedClients = new LinkedList<Client>();
        for (Client client : clients){
            if (client != null && client.getName().equals(name)){
                foundedClients.addLast(client);
            }
        }
        return foundedClients;
    }

    /**
     * печать всех животных по имени клиента
     *
     * @param client имя клиента
     */
    public void printPetsByClient(final String client) {
        LinkedList<Pet> foundedPets = findPetsByClient(client);
        int j = 0;
        for (Pet pet : foundedPets) {
            if (pet != null) {
                System.out.println(pet.getName() + "   " + pet.getClass().getSimpleName());
                j = j + 1;
            }
        }
        if (j == 0) {
            System.out.println("Client with that pet's name didn't find");
        }
    }

    /**
     * печать всех клиентов клиники и их домашних животных
     */
    public void printAllClients() {
        for (Client client : clients) {
            System.out.println(client.getId() + " - " + client.getPet().getName());
        }
    }
}