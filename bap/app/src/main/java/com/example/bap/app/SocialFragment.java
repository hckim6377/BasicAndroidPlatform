package com.example.bap.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by jcyu5662 on 2014. 5. 2..
 */


public class SocialFragment extends PreferenceFragment /*implements OnSharedPreferenceChangeListener*/ {

    private Preference share;
    private Preference tw;
    private Preference loc;
    private Preference jump;
    private Preference weather;

    public static final String DEBUG_TAG = "SocialFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.fragment_social);

            /*for(int i=0;i<getPreferenceScreen().getPreferenceCount();i++){
                initSummary(getPreferenceScreen().getPreference(i));
            }*/

        share = (Preference) findPreference("share");
        share.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            public boolean onPreferenceClick(Preference preference) {
                try {
                    Intent shareIntent =
                            new Intent(android.content.Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Basic Android Platform");

                    String shareMessage = "\nBasic Android App with Tab style ViewPager \n" + "https://play.google.com/store/apps/details?id=com.kookgo1234.ringtube1234";

                    shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, shareMessage));
                } catch (final ActivityNotFoundException e) {
                    //TODO

                }
                return true;
            }
        });



        tw = (Preference) findPreference("facebook");
        tw.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            public boolean onPreferenceClick(Preference preference) {

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.facebook.com/ringtube")));

                return true;
            }
        });

        loc = (Preference) findPreference("ringtonemaker");
        loc.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            public boolean onPreferenceClick(Preference preference) {


                //http://www.ercanbaran.com/index.php/2011/09/13/how-to-open-another-application-from-current-application-on-android-different-approach/

                String package_name = "com.kookgo1234.ringtone";
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager manager = getActivity().getPackageManager();
                i = manager.getLaunchIntentForPackage(package_name);
                if (i!=null) {
                    i.addCategory(Intent.CATEGORY_LAUNCHER);

                } else {
                    String sharerUrl = "https://play.google.com/store/apps/details?id="+package_name;
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                }
                startActivity(i);
                return true;
            }
        });

        jump = (Preference) findPreference("jumpdolphin");
        jump.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            public boolean onPreferenceClick(Preference preference) {


                //http://www.ercanbaran.com/index.php/2011/09/13/how-to-open-another-application-from-current-application-on-android-different-approach/

                String package_name = "com.kookgo.jumpdolphin";
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager manager = getActivity().getPackageManager();
                i = manager.getLaunchIntentForPackage(package_name);
                if (i!=null) {
                    i.addCategory(Intent.CATEGORY_LAUNCHER);

                } else {
                    String sharerUrl = "https://play.google.com/store/apps/details?id="+package_name;
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                }
                startActivity(i);
                return true;
            }
        });

        weather = (Preference) findPreference("weather");
        weather.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            public boolean onPreferenceClick(Preference preference) {


                //http://www.ercanbaran.com/index.php/2011/09/13/how-to-open-another-application-from-current-application-on-android-different-approach/

                String package_name = "com.kookgo.weather";
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager manager = getActivity().getPackageManager();
                i = manager.getLaunchIntentForPackage(package_name);
                if (i!=null) {
                    i.addCategory(Intent.CATEGORY_LAUNCHER);

                } else {
                    String sharerUrl = "https://play.google.com/store/apps/details?id="+package_name;
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                }
                startActivity(i);
                return true;
            }
        });
    }


}