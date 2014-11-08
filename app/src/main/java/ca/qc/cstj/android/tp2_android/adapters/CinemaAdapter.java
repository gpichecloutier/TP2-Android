package ca.qc.cstj.android.tp2_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ca.qc.cstj.android.tp2_android.R;
import ca.qc.cstj.android.tp2_android.models.Cinema;

/**
 * Created by 1247308 on 2014-10-30.
 */
public class CinemaAdapter extends ArrayAdapter<Cinema> {
    private ArrayList<Cinema> cinemas;
    private LayoutInflater layoutInflater;

    public CinemaAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Cinema> listeCompagnies) {
        super(context, R.layout.row_cinema,listeCompagnies);
        this.cinemas = listeCompagnies;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CinemaViewHolder cinemaViewHolder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_cinema,null,true);
            cinemaViewHolder = new CinemaViewHolder();
            cinemaViewHolder.txtNom = (TextView)convertView.findViewById(R.id.txtNom);
            cinemaViewHolder.txtAdresse = (TextView)convertView.findViewById(R.id.txtAdresse);

            convertView.setTag(cinemaViewHolder);
        } else {
            cinemaViewHolder = (CinemaViewHolder)convertView.getTag();
        }

        Cinema cinema = getItem(position);

        cinemaViewHolder.txtNom.setText(cinema.getNom());
        cinemaViewHolder.txtAdresse.setText(cinema.getAdresse());



        return convertView;

    }

    private static class CinemaViewHolder {
        public TextView txtNom;
        public TextView txtAdresse;
    }
}
