package ca.qc.cstj.android.tp2_android.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.joda.time.DateTime;

import ca.qc.cstj.android.tp2_android.helpers.DateParser;

/**
 * Created by 1247308 on 2014-10-28.
 */
public class Horaire {

    private String nomCinema;
    private int idFilm;
    private String href;
    private String titre;
    private String date1;
    private String heure1;
    private String date2;
    private String heure2;

    public Horaire(String titre, int idFilm, String href) {
        this.titre = titre;
        this.idFilm = idFilm;
        this.href = href;
        this.date1 = date1;
        this.date2 = date2;
        this.heure1 = heure1;
        this.heure2 = heure2;
    }


    public String getNomCinema() {
        return nomCinema;
    }

    public void setNomCinema(String nomCinema) {
        this.nomCinema = nomCinema;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getHeure1() {
        return heure1;
    }

    public void setHeure1(String heure1) {
        this.heure1 = heure1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getHeure2() {
        return heure2;
    }

    public void setHeure2(String heure2) {
        this.heure2 = heure2;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
