package ca.qc.cstj.android.tp2_android.models;

import com.google.gson.JsonObject;

import org.joda.time.DateTime;

import ca.qc.cstj.android.tp2_android.helpers.DateParser;

/**
 * Created by 1247308 on 2014-10-30.
 */
public class Commentaire {
    private String href;
    private Film film;
    private Integer note;
    private String auteur;
    private DateTime dateHeure;

    public Commentaire(JsonObject jsonObject) {
        href = jsonObject.get("href").getAsString();

        note = jsonObject.getAsJsonPrimitive("note").getAsInt();
        auteur = jsonObject.getAsJsonPrimitive("auteur").getAsString();

        if(jsonObject.has("film")) {
            film = new Film(jsonObject.getAsJsonObject("film"));
        }
        if(jsonObject.has("dateHeure")) {
            dateHeure = DateParser.ParseIso(jsonObject.getAsJsonPrimitive("dateHeure").getAsString());
        }

    }
}
