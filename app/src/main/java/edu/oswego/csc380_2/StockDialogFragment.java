package edu.oswego.csc380_2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import menu.StockFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StockDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StockDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StockDialogFragment extends DialogFragment {

    private OnFragmentInteractionListener mListener;

    public StockDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StockDialogFragment.
     */
    public static StockDialogFragment newInstance() {
        StockDialogFragment fragment = new StockDialogFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Dialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stock_dialog, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Extract ingredient name from parent fragment
        final String item = this.getTag();

        // Setup EditText
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText input = new EditText(getActivity());
        builder.setView(input);


        // Perform application logic to add/remove ingredients
        builder.setTitle("Edit " + item + " Stock")
                .setPositiveButton("+", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Add amount in EditText
                        Stock stock = Stock.getInstance();
                        // Get amountString
                        String amountString = String.valueOf(input.getText());
                        int amount;
                        if(!amountString.equals("")) {
                            amount = Integer.parseInt(amountString);
                            if (amount > 0) {
                                stock.addIngredient(item, amount);
                                // Update list
                                StockFragment parent = (StockFragment) getParentFragment();
                                parent.onFragmentInteraction();
                            }
                        }
                    }
                })
                .setNegativeButton("-", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Remove amount in EditText
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
        void onFragmentInteraction();
    }
}
