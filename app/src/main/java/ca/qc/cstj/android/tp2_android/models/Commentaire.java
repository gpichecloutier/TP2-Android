package ca.qc.cstj.android.tp2_android.models;

import com.google.gson.JsonObject;

import org.joda.time.DateTime;

import ca.qc.cstj.android.tp2_android.helpers.DateParser;

/**
 * Created by 1247308 on 2014-10-30.
 */
public class Commentaire {
    private String href;
    private String texte;
    private Integer note;
    private String auteur;
    private String date;

    public Commentaire(JsonObject jsonObject) {
        href = jsonObject.get("href").getAsString();

        if(jsonObject.has("texte")) {
            texte = jsonObject.getAsJsonPrimitive("texte").getAsString();
        }
        if(jsonObject.has("note")) {
            note = jsonObject.getAsJsonPrimitive("note").getAsInt();
        }
        if(jsonObject.has("auteur")) {
            auteur = jsonObject.getAsJsonPrimitive("auteur").getAsString();
        }
        if(jsonObject.has("dateHeure")) {
            date = DateParser.ParseToDate(DateParser.ParseIso(jsonObject.getAsJsonPrimitive("dateHeure").getAsString()));
        }

    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
