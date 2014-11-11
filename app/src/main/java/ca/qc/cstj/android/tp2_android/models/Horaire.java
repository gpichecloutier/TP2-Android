package ca.qc.cstj.android.tp2_android.models;

import com.google.gson.JsonObject;

import org.joda.time.DateTime;

import ca.qc.cstj.android.tp2_android.helpers.DateParser;

/**
 * Created by 1247308 on 2014-10-28.
 */
public class Horaire {

    private String href;
    private Cinema cinema;
    private Film film;
    private DateTime dateHeure;

    public Horaire(JsonObject jsonObject) {
        href = jsonObject.get("href").getAsString();

        if(jsonObject.has("cinema")) {
            cinema = new Cinema(jsonObject.getAsJsonObject("cinema"));
        }
        if(jsonObject.has("film")) {
            film = new Film(jsonObject.getAsJsonObject("film"));
        }
        if(jsonObject.has("dateHeure")) {
            dateHeure = DateParser.ParseIso(jsonObject.getAsJsonPrimitive("dateHeure").getAsString());
        }

    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public DateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(DateTime dateHeure) {
        this.dateHeure = dateHeure;
    }
}
