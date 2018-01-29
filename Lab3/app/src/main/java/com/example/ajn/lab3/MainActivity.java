package com.example.ajn.lab3;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import static com.example.ajn.lab3.MainActivity.PlaceholderFragment.ARG_SECTION_NUMBER;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    Runnable runnable;
    @Override
    protected void onDestroy() {

        handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    static int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                PlaceholderFragment fragment = new PlaceholderFragment();
                Bundle args = new Bundle();
                a++;
                args.putInt(ARG_SECTION_NUMBER, (a%4)+1);
                fragment.setArguments(args);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }.start();*/


        runnable = new Runnable() {
            @Override
            public void run() {
                PlaceholderFragment fragment = new PlaceholderFragment();
                Bundle args = new Bundle();
                a++;
                args.putInt(ARG_SECTION_NUMBER, (a%4)+1);
                fragment.setArguments(args);
                //Second fragment after 5 seconds appears
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment )
                        .commit();
                handler.postDelayed(this, 8000);
            }
        };

        handler.postDelayed(runnable, 8000);

    }




    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        static int frag_no;
        public static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            frag_no =sectionNumber;
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            if(getArguments().getInt(ARG_SECTION_NUMBER)==1){
                 rootView = inflater.inflate(R.layout.fragment_one, container, false);

            } else if(getArguments().getInt(ARG_SECTION_NUMBER)==2)
            {
                 rootView = inflater.inflate(R.layout.fragment_two, container, false);

            } else if(getArguments().getInt(ARG_SECTION_NUMBER)==3){
                rootView = inflater.inflate(R.layout.fragment_three, container, false);
                WebView myWebView =  rootView.findViewById(R.id.webview);
                myWebView.setWebViewClient(new WebViewClient()
                {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url)
                    {
                        view.loadUrl(url);
                        return true;
                    }
                });
                myWebView.loadUrl("https://www.google.com");
            } else {
                rootView = inflater.inflate(R.layout.fragment_four, container, false);
            }

            return rootView;
        }
    }

}
