package by.guru13.models.clinic;

import by.guru13.models.clinic.animals.Pet;

/**
 * клиент поликлиники
 *
 * @auhtor alexey
 * @since 16.07.2015
 */
public class Client {
    private int id;
    private String name;
    private final Pet pet;

    /**
     * конструктор
     *
     * @param name  идентификационное имя клиента
     * @param pet животное этого клиента
     */
    public Client(int id,String name, Pet pet) {
        this.id = id;
        this.name = name;
        this.pet = pet;
    }

    /**
     * возвращает объект питомца
     *
     * @return pet
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * @return идентификационное имя клиента
     */
    public int getId() {
        return this.id;
    }

    /**
     * устанавливает идентификационное имя клиента
     *
     * @param id имя клиента
     */
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}