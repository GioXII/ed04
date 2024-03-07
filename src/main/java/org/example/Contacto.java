package org.example;
/**
 * Esta clase sirve para fijar los atributos de los contactos de la agenda.
 * @author Sergio Paco Gómez
 * @since 2024
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private String name;
    private List<String> phones;

    /**
     *
     * @param name
     * @param phone
     * Crea un Contacto con los datos introducidos.
     */
    public Contacto(String name, String phone) {
        this.name = name;
        this.phones = new ArrayList<>();
        this.phones.add(phone);
    }

    /**
     * Devuelve el nombre del {@link Contacto}.
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Devuelve el teléfono del {@link Contacto}.
     * @return
     */
    public List<String> getPhones() {
        return this.phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}