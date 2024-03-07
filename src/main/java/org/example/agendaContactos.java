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

public class agendaContactos {
    private List<Contacto> contacts; // Lista de Contacto

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
     * Método para añadir un {@link Contacto} a la agenda.
     */
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Contacto c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Contacto newContact = new Contacto(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     *
     * @param name
     * Método para borrar un {@link Contacto} de la agenda.
     */
    public void removeContact(String name) {
        Iterator<Contacto> it = contacts.iterator();

        while (it.hasNext()) {
            Contacto c = it.next();

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
     * Método para modificar el número de teléfono de un {@link Contacto}.
     */
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Contacto c : contacts) {
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
     * Devuelve los {@link Contacto}s
     */
    public List<Contacto> getContacts() {
        return this.contacts;
    }
}