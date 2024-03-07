package org.example;
/**
 * Esta clase sirve para fijar las acciones sobre los contactos de la agenda.
 * @author Sergio Paco Gómez
 * @since 2024
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agendaContactos implements Agenda {
    private List<Persona> contacts; // Lista de Contacto

    /**
     * Método para crear la agenda con los contactos.
     */
    public agendaContactos() {
        this.contacts = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param phone
     * Método para añadir un {@link Persona} a la agenda.
     */
    @Override
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Persona newContact = new Persona(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     *
     * @param name
     * Método para borrar un {@link Persona} de la agenda.
     */
    @Override
    public void removeContact(String name) {
        Iterator<Persona> it = contacts.iterator();

        while (it.hasNext()) {
            Persona c = it.next();

            if (c.getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
    }

    /**
     *
     * @param name
     * @param oldPhone
     * @param newPhone
     * Método para modificar el número de teléfono de un {@link Persona}.
     */
    @Override
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<String> phones = c.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     *
     * @return
     * Devuelve los {@link Persona}s
     */
    @Override
    public List<Persona> getContacts() {
        return this.contacts;
    }
}