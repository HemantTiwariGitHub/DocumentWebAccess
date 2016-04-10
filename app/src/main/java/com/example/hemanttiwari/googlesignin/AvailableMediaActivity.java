package com.example.hemanttiwari.googlesignin;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

import layout.MediaGrid;
import layout.PDF_Fragment;
import layout.PDF_Fragment;

public class AvailableMediaActivity extends AppCompatActivity implements MediaGrid.OnFragmentInteractionListener {

    MediaGrid mAvailableMediaFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_media);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.available_media_fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            mAvailableMediaFragment = new MediaGrid();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            mAvailableMediaFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.available_media_fragment_container, mAvailableMediaFragment).commit();
        }
    }

    public void onMediaSelected(int position)
    {

        PDF_Fragment newFragment = new PDF_Fragment();
        Bundle bundle = new Bundle();
        String FileName1;
        //some filename hack ,just for test
        if (position == 1 || position == 2)
        {
            FileName1="file_"+position+".pdf";
        }
        else
        {
            FileName1="Demo.pdf";
        }

        bundle.putString("FileName", FileName1);
        Log.d("Hemant", "Sent Filename : " + FileName1);
        newFragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.available_media_fragment_container, newFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();


    }

}
