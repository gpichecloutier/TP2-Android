package ca.qc.cstj.android.tp2_android;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import ca.qc.cstj.android.tp2_android.adapters.CinemaAdapter;
import ca.qc.cstj.android.tp2_android.services.ServicesURI;

public class CinemaFragment extends Fragment{

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private ListView lstCinema;
        private ProgressDialog progressDialog;
        private CinemaAdapter cinemaAdapter;


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static CinemaFragment newInstance(int sectionNumber) {
            CinemaFragment fragment = new CinemaFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public CinemaFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_cinema, container, false);

            return rootView;
        }

        @Override
        public void onStart() {
            super.onStart();

            lstCinema = (ListView) getActivity().findViewById(R.id.list_cinemas);

            loadCinemas();

            /*lstCinema.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String href = cinemaAdapter.getItem(position).getAsJsonPrimitive("href").getAsString();

                    FragmentTransaction transaction =  getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container,CinemaHoraireFragment.newInstance(href))
                            .addToBackStack("");
                    transaction.commit();

                }
            });*/

        }

        private void loadCinemas()
        {
            progressDialog = ProgressDialog.show(getActivity(),"","En chargement...",true,false);

            Ion.with(getActivity())
                    .load(ServicesURI.CINEMAS_SERVICE_URI)
                    .asJsonArray()
                    .withResponse()
                    .setCallback(new FutureCallback<Response<JsonArray>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonArray> response) {

                            cinemaAdapter = new CinemaAdapter(getActivity(),
                                    getActivity().getLayoutInflater(), response.getResult());
                            lstCinema.setAdapter(cinemaAdapter);

                            progressDialog.dismiss();
                        }
                    });
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
}
