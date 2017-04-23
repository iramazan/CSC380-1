package menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.oswego.csc380_2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ManagerMenuEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManagerMenuEditFragment extends Fragment {

    MenuEditPageAdapter pageAdapter;

    private static class MenuEditPageAdapter extends FragmentPagerAdapter {

        private static int ITEMS = 3;

        public MenuEditPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0: // Appetizers
                    return ManagerMenuFragment.newInstance(0);
                case 1: // Entrees
                    return ManagerMenuFragment.newInstance(1);
                case 2: // Desserts
                    return ManagerMenuFragment.newInstance(2);
            }
            return null; // Should not be reached
        }

        @Override
        public int getCount() {
            return ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // TODO
            switch(position) {
                case 0: // Appetizers
                    return "Appetizers";
                case 1: // Entrees
                    return "Entrees";
                case 2: // Desserts
                    return "Desserts";
            }
            return "ERROR"; // Should not be reached
        }
    }

    public ManagerMenuEditFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ManagerMenuEditFragment.
     */
    public static Fragment newInstance() {
        ManagerMenuEditFragment fragment = new ManagerMenuEditFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_menu_edit, container, false);
        ViewPager vpPager = (ViewPager) view.findViewById(R.id.managerEditMenuPager);
        pageAdapter = new MenuEditPageAdapter(getActivity().getSupportFragmentManager());
        vpPager.setAdapter(pageAdapter);
        return view;
    }

}
