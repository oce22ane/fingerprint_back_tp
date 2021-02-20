package com.example.prm;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class prm {

    private Integer compteur;

    @Id
    private String cc;

    private Date date;

    private String fingerprint;

    public Integer getCompteur() {
        return compteur;
    }

    public void setCompteur(Integer compteur) {
        this.compteur = compteur;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}