package layout;

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
 * {@link AddMenuDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddMenuDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMenuDialogFragment extends DialogFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private int itemType;

    private OnFragmentInteractionListener mListener;

    public AddMenuDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment AddMenuDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMenuDialogFragment newInstance(int param1) {
        AddMenuDialogFragment fragment = new AddMenuDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            itemType = getArguments().getInt(ARG_PARAM1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_menu_dialog, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.fragment_add_menu_dialog, null);
        builder.setView(layout);
        final EditText inputDish = (EditText) layout.findViewById(R.id.addMenuDish);
        final EditText inputPrice = (EditText) layout.findViewById(R.id.addMenuPrice);

        // Perform application logic to add/remove ingredients
        builder.setTitle("Add a dish")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Extract item and amount
                        final String dish = String.valueOf(inputDish.getText());
                        final String priceString = String.valueOf(inputPrice.getText());
                        double price;
                        if(!priceString.equals("") && !dish.equals("")) {
                            price = Double.parseDouble(priceString);
                            if(price > 0.0d) {
                                RestaurantData.Instance().addOrder(itemType, dish, price);
                                // Update list
                            }
                        }
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
        // TODO: Update argument type and name
        void onAddMenuFragmentInteraction(Uri uri);
    }
}
