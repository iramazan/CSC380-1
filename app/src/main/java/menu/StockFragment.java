package menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import edu.oswego.csc380_2.R;
import edu.oswego.csc380_2.Stock;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link ListFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StockFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StockFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StockFragment extends ListFragment {

    private class StockAdapter extends BaseAdapter {

        private final ArrayList<Map.Entry<String, Integer>> data;

        public StockAdapter(Set<Map.Entry<String, Integer>> data) {
            this.data = new ArrayList<>(data);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Map.Entry<String, Integer> getItem(int i) {
            return (Map.Entry) data.get(i);
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
                        R.layout.fragment_stock, viewGroup, false);
            else
                returnView = view;
            Map.Entry<String, Integer> entry = getItem(i);
            ((TextView) returnView.findViewById(R.id.stockItem)).setText(entry.getKey());
            ((TextView) returnView.findViewById(R.id.stockAmount)).setText(entry.getValue().toString());
            return returnView;
        }
    }

    public StockFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StockFragment.
     */
    public static StockFragment newInstance() {
        StockFragment fragment = new StockFragment();
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
        View view = inflater.inflate(R.layout.fragment_stock, container, false);

        Stock stock = Stock.getInstance();
        StockAdapter adapter = new StockAdapter(stock.getIngredients());
        setListAdapter(adapter);

        return view;
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
