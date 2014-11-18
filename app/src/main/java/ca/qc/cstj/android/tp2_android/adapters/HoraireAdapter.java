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
import ca.qc.cstj.android.tp2_android.helpers.DateParser;
import ca.qc.cstj.android.tp2_android.R;
import ca.qc.cstj.android.tp2_android.models.Horaire;

/**
 * Created by 1247308 on 2014-11-05.
 */
public class HoraireAdapter extends ArrayAdapter<Horaire> {
    private ArrayList<Horaire> horaires;
    private LayoutInflater layoutInflater;


    public HoraireAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Horaire> listeHoraires) {
        super(context, R.layout.row_horaire,listeHoraires);
        this.horaires = listeHoraires;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HoraireViewHolder horaireViewHolder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_horaire,null,true);
            horaireViewHolder = new HoraireViewHolder();
            horaireViewHolder.txtTitre = (TextView)convertView.findViewById(R.id.txtTitre);
            horaireViewHolder.txtHoraire1 = (TextView)convertView.findViewById(R.id.txtHoraire1);
            horaireViewHolder.txtHoraire2 = (TextView)convertView.findViewById(R.id.txtHoraire2);

            convertView.setTag(horaireViewHolder);
        } else {
            horaireViewHolder = (HoraireViewHolder)convertView.getTag();
        }

        Horaire horaire = getItem(position);

        horaireViewHolder.txtTitre.setText(horaire.getTitre());
        horaireViewHolder.txtHoraire1.setText(horaire.getDate1() + ", " + horaire.getHeure1());
        horaireViewHolder.txtHoraire2.setText(horaire.getDate2() + ", " + horaire.getHeure2());


        return convertView;

    }

    private static class HoraireViewHolder {
        public TextView txtTitre;
        public TextView txtHoraire1;
        public TextView txtHoraire2;
    }
}
