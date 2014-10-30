package ca.qc.cstj.android.tp2_android.adapters;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import ca.qc.cstj.android.tp2_android.models.Cinema;
import ca.qc.cstj.android.tp2_android.models.Film;

/**
 * Created by 1247308 on 2014-10-30.
 */
public class FilmAdapter extends GenericArrayAdapter<Film>{
    public FilmAdapter(Context context, int layoutRes, ArrayList<Film> films) {
        super(context,layoutRes,films);
    }

    @Override
    public void update(TextView textView, Film object) {
        /*String nomAdresse = new StringBuilder().append(object.getNom()).append(" \n ").append(object.getAdresse()).toString();
        textView.setText(nomAdresse);*/
    }
}
