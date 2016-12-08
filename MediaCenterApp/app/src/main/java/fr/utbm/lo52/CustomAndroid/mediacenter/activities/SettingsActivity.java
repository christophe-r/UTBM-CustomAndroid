package fr.utbm.lo52.CustomAndroid.mediacenter.activities;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;

public class SettingsActivity extends AppCompatPreferenceActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();

    }


    public static class SettingsFragment extends PreferenceFragment
    {
        SharedPreferences sp;
        EditTextPreference editText_mediacenterPath;
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);

            sp = getPreferenceScreen().getSharedPreferences();
            editText_mediacenterPath = (EditTextPreference) findPreference("pref_mediacenter_path");

            String pref_mediacenter_path = sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/");

            editText_mediacenterPath.setText(pref_mediacenter_path);
            editText_mediacenterPath.setSummary(pref_mediacenter_path);


            editText_mediacenterPath.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener(){
                @Override
                public boolean onPreferenceChange(Preference preference, Object object) {
                    editText_mediacenterPath.setSummary((String)object);
                    return true;
                }
            });

        }


    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
