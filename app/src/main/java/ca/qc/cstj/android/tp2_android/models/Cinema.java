package ca.qc.cstj.android.tp2_android.models;

import com.google.gson.JsonObject;

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
    private List<Horaire> listeHoraires;

    public Cinema(JsonObject jsonObject) {
        href = jsonObject.getAsJsonPrimitive("href").getAsString();
        nom = jsonObject.getAsJsonPrimitive("nom").getAsString();
        ville = jsonObject.getAsJsonPrimitive("ville").getAsString();
        adresse = jsonObject.getAsJsonPrimitive("adresse").getAsString();
        codePostal = jsonObject.getAsJsonPrimitive("codePostal").getAsString();
        telephone = jsonObject.getAsJsonPrimitive("telephone").getAsString();
        listeHoraires = new List<Horaire>(jsonObject.getAsJsonObject("horaire"));
    }
}
