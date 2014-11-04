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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
