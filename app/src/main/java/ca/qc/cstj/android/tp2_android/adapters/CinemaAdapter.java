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

/**
 * Created by 1247308 on 2014-11-07.
 */
public class CinemaAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mInflater;
    private JsonArray mJsonArray;


    public CinemaAdapter(Context context, LayoutInflater inflater, JsonArray jsonArray) {
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

        CinemaViewHolder cinemaViewHolder;



        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.row_cinema,null);
            cinemaViewHolder = new CinemaViewHolder();
            cinemaViewHolder.txtNom = (TextView)convertView.findViewById(R.id.txtNom);
            cinemaViewHolder.txtAdresse = (TextView)convertView.findViewById(R.id.txtAdresse);

            convertView.setTag(cinemaViewHolder);
        } else {
            cinemaViewHolder = (CinemaViewHolder)convertView.getTag();
        }

        JsonObject cinema = getItem(position);

        cinemaViewHolder.txtNom.setText(cinema.getAsJsonPrimitive("nom").getAsString());
        cinemaViewHolder.txtAdresse.setText(cinema.getAsJsonPrimitive("adresse").getAsString());



        return convertView;

    }

    private static class CinemaViewHolder {
        public TextView txtNom;
        public TextView txtAdresse;
    }
}
