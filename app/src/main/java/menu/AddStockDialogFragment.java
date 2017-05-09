package menu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import edu.oswego.csc380_2.R;
import edu.oswego.csc380_2.Stock;

/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddStockDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddStockDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddStockDialogFragment extends DialogFragment {

    private OnFragmentInteractionListener mListener;

    public AddStockDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddStockDialogFragment.
     */
    public static AddStockDialogFragment newInstance() {
        AddStockDialogFragment fragment = new AddStockDialogFragment();
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
        return inflater.inflate(R.layout.fragment_add_stock_dialog, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.fragment_add_stock_dialog, null);
        builder.setView(layout);
        final EditText inputItem = (EditText) layout.findViewById(R.id.addStockItem);
        final EditText inputAmount = (EditText) layout.findViewById(R.id.addStockAmount);

        // Perform application logic to add/remove ingredients
        builder.setTitle("Add an ingredient")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Stock stock = Stock.getInstance();
                        // Extract item and amount
                        final String item = String.valueOf(inputItem.getText());
                        final String amountString = String.valueOf(inputAmount.getText());
                        int amount;
                        if(!amountString.equals("")) {
                            amount = Integer.parseInt(amountString);
                            if(amount > 0) {
                                stock.addIngredient(item, amount);
                                // Update list
                                StockFragment parent = (StockFragment) getParentFragment();
                                parent.onAddStockFragmentInteraction();
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
        void onAddStockFragmentInteraction();
    }
}
