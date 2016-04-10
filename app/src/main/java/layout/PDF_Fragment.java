package layout;



import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hemanttiwari.googlesignin.R;
import com.joanzapata.pdfview.PDFView;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *  interface
 * to handle interaction events.
 * Use the {@link PDF_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PDF_Fragment extends Fragment   {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String mFileName;



    public PDF_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *w
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PDFFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PDF_Fragment newInstance(String param1, String param2) {
        PDF_Fragment fragment = new PDF_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mFileName = bundle.getString("FileName", " ");
            Log.d("Hemant", "Recceived Filename : " + mFileName);
        }



    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("Hemant", "Opening Filename : " + mFileName);
        PDFView pdfView= (PDFView) getView().findViewById(R.id.pdfView);

        //Toast.makeText(this.getContext(), "Reading from PlainText" , Toast.LENGTH_LONG).show();
        pdfView.fromAsset(mFileName)
                .defaultPage(1)
                .load();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pdf_fragment, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }
    @Override
    public void onStart() {
        super.onStart();




    }
    @Override
    public void onDetach() {
        super.onDetach();

    }


}
