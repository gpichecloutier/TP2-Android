package ca.qc.cstj.android.tp2_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import ca.qc.cstj.android.tp2_android.R;
import ca.qc.cstj.android.tp2_android.models.Horaire;

/**
 * Created by 1247308 on 2014-11-05.
 */
public class HoraireAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private JsonArray mJsonArray;


    public HoraireAdapter(Context context, LayoutInflater inflater, JsonArray jsonArray) {
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

        HoraireViewHolder horaireViewHolder;



        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.row_horaire,null);
            horaireViewHolder = new HoraireViewHolder();
            horaireViewHolder.txtNom = (TextView)convertView.findViewById(R.id.txtNom);
            horaireViewHolder.txtAdresse = (TextView)convertView.findViewById(R.id.txtAdresse);

            convertView.setTag(horaireViewHolder);
        } else {
            horaireViewHolder = (HoraireViewHolder)convertView.getTag();
        }

        JsonObject cinema = getItem(position);

        horaireViewHolder.txtNom.setText(cinema.getAsJsonPrimitive("nom").getAsString());
        horaireViewHolder.txtAdresse.setText(cinema.getAsJsonPrimitive("adresse").getAsString());



        return convertView;

    }

    private static class HoraireViewHolder {
        public TextView txtNom;
        public TextView txtAdresse;
    }
}
