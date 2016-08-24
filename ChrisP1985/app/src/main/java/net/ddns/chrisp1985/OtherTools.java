package net.ddns.chrisp1985;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import net.ddns.tests.chrisp1985.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OtherTools.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OtherTools#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtherTools extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentTabHost mTabHost;
    private View currentView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OtherTools() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OtherTools.
     */
    // TODO: Rename and change types and number of parameters
    public static OtherTools newInstance(String param1, String param2) {
        OtherTools fragment = new OtherTools();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_other_tools, container, false);
        TextView txt = (TextView) v.findViewById(R.id.other_tools_heading);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/KBZipaDeeDooDah.ttf");
        txt.setTypeface(font);

        ImageView picture = (ImageView) v.findViewById(R.id.other_tools_image);
        picture.setImageAlpha(80);

        currentView = v;
        setupTabs(v);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
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
        void onFragmentInteraction(Uri uri);
    }

    public void setupTabs(View view) {
        TabHost host = (TabHost) view.findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec linuxSpec = host.newTabSpec("linuxTabOption");
        linuxSpec.setContent(R.id.linuxTabOption);
        linuxSpec.setIndicator("Linux");
        host.addTab(linuxSpec);

        //Tab 2
        TabHost.TabSpec npmSpec = host.newTabSpec("NPMTabOption");
        npmSpec.setContent(R.id.NPMTabOption);
        npmSpec.setIndicator("NPM");
        host.addTab(npmSpec);

        //Tab 3
        TabHost.TabSpec mockingSpec = host.newTabSpec("Mocking");
        mockingSpec.setContent(R.id.Mocking);
        mockingSpec.setIndicator("Mocking");
        host.addTab(mockingSpec);

        //Tab 4
        TabHost.TabSpec jenkinsSpec = host.newTabSpec("Jenkins");
        jenkinsSpec.setContent(R.id.Jenkins);
        jenkinsSpec.setIndicator("Jenkins");
        host.addTab(jenkinsSpec);

        //Tab 5
        TabHost.TabSpec buildEnvSpec = host.newTabSpec("BuildEnv");
        buildEnvSpec.setContent(R.id.BuildEnv);
        buildEnvSpec.setIndicator("Build Environment");
        host.addTab(buildEnvSpec);


        for(int i=0;i<host.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) host.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#ffffff"));
        }

        TabHost.OnTabChangeListener tabListener = new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                TextView myText = (TextView) currentView.findViewById (R.id.other_tools_summary);
                TextView myTabHeading = (TextView) currentView.findViewById (R.id.other_tools_desc);
                switch (tabId) {
                    case "Jenkins":
                        myText.setText(R.string.other_tools_jenkins);
                        myTabHeading.setText("Jenkins");
                        break;
                    case "linuxTabOption":
                        myText.setText(R.string.other_tools_linux);
                        myTabHeading.setText("Linux");
                        break;
                    case "NPMTabOption":
                        myText.setText(R.string.npm_again);
                        myTabHeading.setText("NPM");
                        break;
                    case "Mocking":
                        myText.setText(R.string.other_tools_mocking);
                        myTabHeading.setText("Mocking");
                        break;
                    case "BuildEnv":
                        myText.setText(R.string.other_tools_buildenv);
                        myTabHeading.setText("Build Environment");
                        break;
                }
            }
        };

        host.setOnTabChangedListener(tabListener);
    }
}
