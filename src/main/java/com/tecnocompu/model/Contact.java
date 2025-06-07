package com.tecnocompu.model;

/**
 * Clase de modelo para representar un mensaje de contacto.
 */
public class Contact {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String messageType;
    private String message;

    // Constructor vacío
    public Contact() {
    }

    // Constructor con todos los campos
    public Contact(int id, String name, String email, String phone, String messageType, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.messageType = messageType;
        this.message = message;
    }

    // Constructor sin ID (útil para la creación de nuevos mensajes de contacto)
    public Contact(String name, String email, String phone, String messageType, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.messageType = messageType;
        this.message = message;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
