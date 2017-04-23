package menu;

import activities.RestaurantData;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import edu.oswego.csc380_2.R;

/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ManagerModifyPriceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ManagerModifyPriceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManagerModifyPriceFragment extends DialogFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int orderCategory; // Category of order (see ManagerMenuEditFragment)
    private String order; // Order to modify

    private OnFragmentInteractionListener mListener;

    public ManagerModifyPriceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     *
     * @return A new instance of fragment ManagerModifyPriceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ManagerModifyPriceFragment newInstance(int param1, String param2) {
        ManagerModifyPriceFragment fragment = new ManagerModifyPriceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            orderCategory = getArguments().getInt(ARG_PARAM1);
            order = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manager_modify_price, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceBundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.fragment_manager_modify_price, null);
        builder.setView(layout);
        final EditText input = (EditText) layout.findViewById(R.id.modifyPriceInput);

        // Perform application logic to add/remove ingredients
        builder.setTitle("Modify the price of " + order)
                .setPositiveButton("Modify", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Extract item and amount
                        String priceString = String.valueOf(input.getText());
                        double price;
                        if(!priceString.equals("")) {
                            price = Double.parseDouble(priceString);
                            if(price > 0.0d) {
                                // Modify order
                                RestaurantData.Instance().modifyOrder(orderCategory, order, price);
                                // Notify parent of list change
                                ManagerMenuFragment parent = (ManagerMenuFragment) getParentFragment();
                                parent.onModPriceFragmentInteraction();
                            }
                        }
                    }
                });
        builder.setNegativeButton("remove", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Remove Dish
                RestaurantData.Instance().removeOrder(orderCategory, order);
                // Notify parent of list change
                ManagerMenuFragment parent = (ManagerMenuFragment) getParentFragment();
                parent.onModPriceFragmentInteraction();
            }
        });
        return builder.create();
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
        void onModPriceFragmentInteraction();
    }
}
