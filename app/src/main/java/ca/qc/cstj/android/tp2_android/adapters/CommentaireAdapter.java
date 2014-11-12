package ca.qc.cstj.android.tp2_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ca.qc.cstj.android.tp2_android.R;
import ca.qc.cstj.android.tp2_android.helpers.DateParser;

/**
 * Created by 1247308 on 2014-11-12.
 */
public class CommentaireAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private JsonArray mJsonArray;


    public CommentaireAdapter(Context context, LayoutInflater inflater, JsonArray jsonArray) {
        mContext = context;
        mInflater = inflater;
        mJsonArray = jsonArray;
    }

    @Override
    public int getCount() {
        return mJsonArray.size();
    }

    @Override
    public JsonObject getItem(int position) {
        return mJsonArray.get(position).getAsJsonObject();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommentaireViewHolder commentaireViewHolder;



        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.row_commentaire,null);
            commentaireViewHolder = new CommentaireViewHolder();
            commentaireViewHolder.txtTexte = (TextView)convertView.findViewById(R.id.txtTexte);
            commentaireViewHolder.txtNote = (TextView)convertView.findViewById(R.id.txtNote);
            commentaireViewHolder.txtAuteur = (TextView)convertView.findViewById(R.id.txtAuteur);
            commentaireViewHolder.txtDate = (TextView)convertView.findViewById(R.id.txtDate);

            convertView.setTag(commentaireViewHolder);
        } else {
            commentaireViewHolder = (CommentaireViewHolder)convertView.getTag();
        }

        /*JsonObject commentaire = getItem(position);
        commentaireViewHolder.txtTexte.setText(commentaire.getAsJsonPrimitive("texte").getAsString());
        commentaireViewHolder.txtNote.setText(commentaire.getAsJsonPrimitive("note").getAsString());
        commentaireViewHolder.txtAuteur.setText(commentaire.getAsJsonPrimitive("auteur").getAsString());
        commentaireViewHolder.txtDate.setText(DateParser.ParseIso(commentaire.getAsJsonPrimitive("dateHeure"));
        String result = horaire.getAsJsonPrimitive("dateHeure").toString();
        String date = dateParser.ParseToDate(result).toString();
        String heure = dateParser.ParseToTime(result).toString();

        commentaireViewHolder.txtHoraire.setText(date);
        commentaireViewHolder.txtHoraire2.setText(heure);*/


        return convertView;

    }

    private static class CommentaireViewHolder {
        public TextView txtTexte;
        public TextView txtNote;
        public TextView txtAuteur;
        public TextView txtDate;
    }
}
