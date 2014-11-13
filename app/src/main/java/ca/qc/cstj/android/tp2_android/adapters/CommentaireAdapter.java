package ca.qc.cstj.android.tp2_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import ca.qc.cstj.android.tp2_android.R;
import ca.qc.cstj.android.tp2_android.helpers.DateParser;
import ca.qc.cstj.android.tp2_android.models.Commentaire;
import ca.qc.cstj.android.tp2_android.models.Horaire;

/**
 * Created by 1247308 on 2014-11-12.
 */
public class CommentaireAdapter extends ArrayAdapter<Commentaire> {
    private ArrayList<Commentaire> commentaires;
    private LayoutInflater layoutInflater;


    public CommentaireAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Commentaire> listeCommentaires) {
        super(context, R.layout.row_horaire,listeCommentaires);
        this.commentaires = listeCommentaires;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommentaireViewHolder commentaireViewHolder;



        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_commentaire,null);
            commentaireViewHolder = new CommentaireViewHolder();
            commentaireViewHolder.txtTexte = (TextView)convertView.findViewById(R.id.txtTexte);
            commentaireViewHolder.txtNote = (TextView)convertView.findViewById(R.id.txtNote);
            commentaireViewHolder.txtAuteur = (TextView)convertView.findViewById(R.id.txtAuteur);
            commentaireViewHolder.txtDate = (TextView)convertView.findViewById(R.id.txtDate);

            convertView.setTag(commentaireViewHolder);
        } else {
            commentaireViewHolder = (CommentaireViewHolder)convertView.getTag();
        }

        Commentaire commentaire = getItem(position);

        commentaireViewHolder.txtTexte.setText(commentaire.getTexte());
        commentaireViewHolder.txtNote.setText(commentaire.getNote().toString() + "/10");
        commentaireViewHolder.txtAuteur.setText(commentaire.getAuteur() + ", ");
        commentaireViewHolder.txtDate.setText(commentaire.getDate());


        return convertView;

    }

    private static class CommentaireViewHolder {
        public TextView txtTexte;
        public TextView txtNote;
        public TextView txtAuteur;
        public TextView txtDate;
    }
}
