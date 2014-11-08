package ca.qc.cstj.android.tp2_android.models;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1247308 on 2014-10-28.
 */
public class Cinema {
    private String href;
    private String nom;
    private String ville;
    private String adresse;
    private String codePostal;
    private String telephone;
    private Horaire horaire;

    public Cinema(JsonObject jsonObject) {
        href = jsonObject.getAsJsonPrimitive("href").getAsString();
        nom = jsonObject.getAsJsonPrimitive("nom").getAsString();
        ville = jsonObject.getAsJsonPrimitive("ville").getAsString();
        adresse = jsonObject.getAsJsonPrimitive("adresse").getAsString();
        codePostal = jsonObject.getAsJsonPrimitive("codePostal").getAsString();
        telephone = jsonObject.getAsJsonPrimitive("telephone").getAsString();
        horaire = new Horaire(jsonObject.getAsJsonObject("horaires"));
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
