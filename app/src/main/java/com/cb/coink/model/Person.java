package com.cb.coink.model;

public class Person {
    private  String phone;
    private  String typeDocument;
    private  String documentNumber;
    private  String date;
    private  String dateOfBirth;
    private  String gender;
    private  String email;
    private  String pin;

    public Person(){}

    public Person(String phone, String typeDocument, String documentNumber, String date, String dateOfBirth, String gender, String email, String pin) {
        this.phone = phone;
        this.typeDocument = typeDocument;
        this.documentNumber = documentNumber;
        this.date = date;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
