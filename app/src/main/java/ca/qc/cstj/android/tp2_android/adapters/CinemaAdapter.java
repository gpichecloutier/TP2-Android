package ca.qc.cstj.android.tp2_android.adapters;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import ca.qc.cstj.android.tp2_android.models.Cinema;

/**
 * Created by 1247308 on 2014-10-30.
 */
public class CinemaAdapter extends GenericArrayAdapter<Cinema>{
    public CinemaAdapter(Context context, int layoutRes, ArrayList<Cinema> cinemas) {
        super(context,layoutRes,cinemas);
    }

    @Override
    public void update(TextView textView, Cinema object) {
        String nomAdresse = new StringBuilder().append(object.getNom()).append(" \n ").append(object.getAdresse()).toString();
        textView.setText(nomAdresse);
    }
}
