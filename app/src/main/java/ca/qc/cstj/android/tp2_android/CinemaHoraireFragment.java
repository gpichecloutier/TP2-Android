package ca.qc.cstj.android.tp2_android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Calendar;

import ca.qc.cstj.android.tp2_android.adapters.HoraireAdapter;
import ca.qc.cstj.android.tp2_android.helpers.DateParser;
import ca.qc.cstj.android.tp2_android.models.Film;
import ca.qc.cstj.android.tp2_android.models.Cinema;
import ca.qc.cstj.android.tp2_android.models.Horaire;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CinemaHoraireFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CinemaHoraireFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class CinemaHoraireFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_HREF = "href";

    // TODO: Rename and change types of parameters
    private String href;
    private ListView lstHoraire;
    private HoraireAdapter horaireAdapter;

    private ProgressDialog progressDialog;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param href href du cinéma a afficher
     * @return A new instance of fragment CinemaHoraireFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CinemaHoraireFragment newInstance(String href) {
        CinemaHoraireFragment fragment = new CinemaHoraireFragment();
        Bundle args = new Bundle();
        args.putString(ARG_HREF, href);
        fragment.setArguments(args);
        return fragment;
    }
    public CinemaHoraireFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            href = getArguments().getString(ARG_HREF);
        }

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cinema_horaire, container, false);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        lstHoraire = (ListView) getActivity().findViewById(R.id.list_horaires);

        progressDialog = ProgressDialog.show(getActivity(), "Horaires", "En chargement...", true, false);
        Ion.with(getActivity())
                .load(href + "/horaires")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject jsonObject) {
                        ArrayList<Horaire> listeHoraires = new ArrayList<Horaire>();
                        JsonObject horaires;
                        // On doit décomposer l'objet
                        if (jsonObject.has("horaires")) {
                            horaires = jsonObject.getAsJsonObject("horaires");
                            if (horaires.has("items")) {
                                JsonArray items = horaires.getAsJsonArray("items");
                                // On veut juste en afficher 2, on compte le nombre de fois qu'on instancie un horaire pour un cinéma

                                for (JsonElement item : items) {

                                    listeHoraires.add(new Horaire(item.getAsJsonObject()));
                                }

                                horaireAdapter = new HoraireAdapter(getActivity(), getActivity().getLayoutInflater(),listeHoraires);
                                lstHoraire.setAdapter(horaireAdapter);
                                progressDialog.dismiss();
                            }
                        }
                    }
                });
    }

    // TODO: Rename method, update argument and hook method into UI event

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (CinemaHoraireFragment.OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}