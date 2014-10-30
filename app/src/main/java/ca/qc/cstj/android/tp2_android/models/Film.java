package ca.qc.cstj.android.tp2_android.models;

import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by 1247308 on 2014-10-30.
 */
public class Film {
    private String href;
    private String titre;
    private String pays;
    private String genre;
    private String classe;
    private Integer duree;
    private String realisateur;
    private String imageUrl;
    private List<Commentaire> listeCommentaires;

    public Film(JsonObject jsonObject) {
        href = jsonObject.getAsJsonPrimitive("href").getAsString();
        titre = jsonObject.getAsJsonPrimitive("titre").getAsString();
        pays = jsonObject.getAsJsonPrimitive("pays").getAsString();
        genre = jsonObject.getAsJsonPrimitive("genre").getAsString();
        classe = jsonObject.getAsJsonPrimitive("classe").getAsString();
        duree = jsonObject.getAsJsonPrimitive("duree").getAsInt();
        realisateur = jsonObject.getAsJsonPrimitive("realisateur").getAsString();
        imageUrl = jsonObject.getAsJsonPrimitive("imageUrl").getAsString();
        //listeCommentaires = new List<Commentaire>(jsonObject.getAsJsonObject("commentaires"));
    }
}
