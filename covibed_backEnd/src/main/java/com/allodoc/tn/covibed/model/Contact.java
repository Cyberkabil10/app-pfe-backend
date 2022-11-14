package com.allodoc.tn.covibed.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "contact")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@contactID")
public class Contact implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6123703288245602356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactID")
    private long contactID;

    @Column(name = "Prenom")
    private String Prenom;

    @Column(name = "CIN")
    private String CIN;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private String sex;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "profession")
    private String profession;

    @Column(name = "age")
    private String age;

    @Column(name = "phoneNumber")
    private String PhoneNumber;

    @Column(name = "dateDeNaissence")
    private String dateDeNaissence;
    /// with pays
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cityID")
    private City cityContact;
    //// with Doctors:
    @JsonIgnore
    @OneToOne(mappedBy = "contact")
    private Doctors doctors;
    @JsonIgnore
    @OneToOne(mappedBy = "contact")
    private Staff staff;
//// with organisation contact
//    @JsonIgnore
//    @OneToOne(mappedBy = "contact")
//    private Organization organization;
    /// with user

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private User user;
    //contact organisation


    public Contact() {

    }


    public long getContactID() {
        return contactID;
    }


    public void setContactID(long contactID) {
        this.contactID = contactID;
    }


    public String getPrenom() {
        return Prenom;
    }


    public void setPrenom(String prenom) {
        Prenom = prenom;
    }


    public String getCIN() {
        return CIN;
    }


    public void setCIN(String cIN) {
        CIN = cIN;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getProfession() {
        return profession;
    }


    public void setProfession(String profession) {
        this.profession = profession;
    }


    public String getAge() {
        return age;
    }


    public void setAge(String age) {
        this.age = age;
    }


    public String getPhoneNumber() {
        return PhoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }


    public String getDateDeNaissence() {
        return dateDeNaissence;
    }


    public void setDateDeNaissence(String dateDeNaissence) {
        this.dateDeNaissence = dateDeNaissence;
    }


    public City getCityContact() {
        return cityContact;
    }


    public void setCityContact(City cityContact) {
        this.cityContact = cityContact;
    }


    public Doctors getDoctors() {
        return doctors;
    }


    public void setDoctors(Doctors doctors) {
        this.doctors = doctors;
    }



//
//    public Organization getOrganization() {
//        return organization;
//    }


//    public void setOrganization(Organization organization) {
//        this.organization = organization;
//    }
//

    public Staff getStaff() {
        return staff;
    }


    public void setStaff(Staff staff) {
        this.staff = staff;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


}
