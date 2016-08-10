package layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * {@link ToolsFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ToolsFrag#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ToolsFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View currentView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToolsFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static ToolsFrag newInstance(String param1, String param2) {
        ToolsFrag fragment = new ToolsFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public ToolsFrag() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle     savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tools, container, false);
        TextView txt = (TextView) v.findViewById(R.id.textView3);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/KBZipaDeeDooDah.ttf");
        txt.setTypeface(font);

        ImageView picture = (ImageView) v.findViewById(R.id.seleniumImg);
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
        TabHost host = (TabHost) view.findViewById(R.id.tabHost2);
        host.setup();

        //Tab 1
        TabHost.TabSpec jasmineSpec = host.newTabSpec("Jasmine");
        jasmineSpec.setContent(R.id.Jasmine);
        jasmineSpec.setIndicator("Jasmine");
        host.addTab(jasmineSpec);

        //Tab 2
        TabHost.TabSpec protractorSpec = host.newTabSpec("Protractor");
        protractorSpec.setContent(R.id.Protractor);
        protractorSpec.setIndicator("Protractor");
        host.addTab(protractorSpec);

        //Tab 3
        TabHost.TabSpec seleniumSpec = host.newTabSpec("Selenium");
        seleniumSpec.setContent(R.id.Selenium);
        seleniumSpec.setIndicator("Selenium");
        host.addTab(seleniumSpec);

        //Tab 4
        TabHost.TabSpec uiAutomationSpec = host.newTabSpec("UIAutomation");
        uiAutomationSpec.setContent(R.id.UIAutomation);
        uiAutomationSpec.setIndicator("UIAutomation");
        host.addTab(uiAutomationSpec);

        //Tab 5
        TabHost.TabSpec apiSpec = host.newTabSpec("API");
        apiSpec.setContent(R.id.API);
        apiSpec.setIndicator("API");
        host.addTab(apiSpec);

        //Tab 6
        TabHost.TabSpec jMeterSpec = host.newTabSpec("JMeter");
        jMeterSpec.setContent(R.id.JMeter);
        jMeterSpec.setIndicator("JMeter");
        host.addTab(jMeterSpec);

        //Tab 7
        TabHost.TabSpec othertoolsSpec = host.newTabSpec("OtherTools");
        othertoolsSpec.setContent(R.id.OtherTools);
        othertoolsSpec.setIndicator("Other Tools");
        host.addTab(othertoolsSpec);

        for(int i=0;i<host.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) host.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#ffffff"));
        }

        TabHost.OnTabChangeListener tabListener = new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                TextView myText = (TextView) currentView.findViewById (R.id.textView8);
                if(tabId.equals("Jasmine")) {
                    myText.setText(R.string.tools_jasmine);
                }
                else if(tabId.equals("Protractor")) {
                    myText.setText(R.string.tools_protractor);
                }
                else if(tabId.equals("Selenium")) {
                    myText.setText(R.string.tools_selenium);
                }
                else if(tabId.equals("UIAutomation")) {
                    myText.setText(R.string.tools_uiautomation);
                }
                else if(tabId.equals("API")) {
                    myText.setText(R.string.tools_api);
                }
                else if(tabId.equals("JMeter")) {
                    myText.setText(R.string.tools_jmeter);
                }
                else if(tabId.equals("OtherTools")) {
                    myText.setText(R.string.tools_othertools);
                }
            }
        };

        host.setOnTabChangedListener(tabListener);
    }
}
