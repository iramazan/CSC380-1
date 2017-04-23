package menu;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import edu.oswego.csc380_2.Order;
import edu.oswego.csc380_2.R;
import activities.RestaurantData;

import java.util.ArrayList;

/**
 * A simple {@link ListFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ManagerMenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ManagerMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManagerMenuFragment extends ListFragment
        implements ManagerModifyPriceFragment.OnFragmentInteractionListener {

    private class ListAdapter extends BaseAdapter {

        private final ArrayList<Order> data;

        public ListAdapter(ArrayList<Order> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Order getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            // Not needed
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View returnView;
            if(view == null)
                returnView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.fragment_list_layout, viewGroup, false);
            else
                returnView = view;
            Order order = getItem(i);
            ((TextView) returnView.findViewById(R.id.listMain)).setText(order.getName());
            ((TextView) returnView.findViewById(R.id.listSub)).setText(String.valueOf(order.getPrice()));
            return returnView;
        }
    }

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private int menuItemCategory;

    private ListAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public ManagerMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ManagerMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ManagerMenuFragment newInstance(int param1) {
        ManagerMenuFragment fragment = new ManagerMenuFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            menuItemCategory = getArguments().getInt(ARG_PARAM1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_menu, container, false);

        // TODO Handle Floating Action Button click
        /*
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.stockFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add to the Stock
                AddStockDialogFragment dialog = AddStockDialogFragment.newInstance();
                dialog.show(getChildFragmentManager(), "addStockDialog");
            }
        });
        */

        // Populate list
        RestaurantData res = RestaurantData.Instance();
        ArrayList<Order> orderList = null;
        switch(menuItemCategory) {
            case 0: // Appetizer
                orderList = res.getAppetizersMenu();
                break;
            case 1: // Entree
                orderList = res.getEntreesMenu();
                break;
            case 2: // Desserts
                orderList = res.getDessertsMenu();
                break;
            default: // Should not be reached
                orderList = new ArrayList<>();
        }
        adapter = new ListAdapter(orderList);
        setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView lv, View view, int position, long id) {
        super.onListItemClick(lv, view, position, id);
        // Create Dialog box to modify dish price
        String dish = adapter.getItem(position).getName();
        ManagerModifyPriceFragment dialog =
                ManagerModifyPriceFragment.newInstance(menuItemCategory, dish);
        dialog.show(getChildFragmentManager(), "modDishPrice");
    }

    @Override
    public void onModPriceFragmentInteraction() {
        adapter.notifyDataSetChanged();
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
}
