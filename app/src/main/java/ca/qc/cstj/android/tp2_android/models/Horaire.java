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
    private String titre;
    private String date;
    private String heure;

    public Horaire(JsonObject jsonObject) {
        /*href = jsonObject.get("href").getAsString();

        if(jsonObject.has("cinema")) {
            cinema = new Cinema(jsonObject.getAsJsonObject("cinema"));
        }
        if(jsonObject.has("film")) {
            film = new Film(jsonObject.getAsJsonObject("film"));
        }
        if(jsonObject.has("dateHeure")) {
            dateHeure = DateParser.ParseIso(jsonObject.getAsJsonPrimitive("dateHeure").getAsString());
        }*/

        DateParser dateParser = new DateParser();

                    titre = jsonObject.getAsJsonPrimitive("film").getAsString();
                    nomCinema = jsonObject.getAsJsonPrimitive("cinema").getAsString();
                    DateTime dtDateHeure = DateParser.ParseIso(jsonObject.getAsJsonPrimitive("dateHeure").getAsString());
                    date = dateParser.ParseToDate(dtDateHeure);
                    heure = dateParser.ParseToTime(dtDateHeure);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
