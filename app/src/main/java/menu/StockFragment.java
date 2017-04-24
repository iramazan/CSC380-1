package menu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import edu.oswego.csc380_2.R;
import edu.oswego.csc380_2.Stock;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link ListFragment} subclass.
 * Use the {@link StockFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StockFragment extends ListFragment implements StockDialogFragment.OnFragmentInteractionListener,
                                                           AddStockDialogFragment.OnFragmentInteractionListener {

    private ListAdapter adapter;

    private class ListAdapter extends BaseAdapter {

        private final ArrayList<Map.Entry<String, Integer>> data;

        public ListAdapter(Set<Map.Entry<String, Integer>> data) {
            this.data = new ArrayList<>(data);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Map.Entry<String, Integer> getItem(int i) {
            return (Map.Entry<String, Integer>) data.get(i);
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
            Map.Entry<String, Integer> entry = getItem(i);
            ((TextView) returnView.findViewById(R.id.listMain)).setText(entry.getKey());
            ((TextView) returnView.findViewById(R.id.listSub)).setText(entry.getValue().toString());
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

        // Handle Floating Action Button click
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.stockFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add to the Stock
                AddStockDialogFragment dialog = AddStockDialogFragment.newInstance();
                dialog.show(getChildFragmentManager(), "addStockDialog");
            }
        });

        // Populate list
        Stock stock = Stock.getInstance();
        adapter = new ListAdapter(stock.getIngredients());
        setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView lv, View view, int position, long id) {
        super.onListItemClick(lv, view, position, id);
        // Create Dialog box to add/remove ingredients
        StockDialogFragment dialog = StockDialogFragment.newInstance();
        String item = adapter.getItem(position).getKey();
        dialog.show(getChildFragmentManager(), item);
    }

    @Override
    public void onStockDialogFragmentInteraction() {
        // Refresh Stock Adapter after update
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAddStockFragmentInteraction() {
        // Repopulate Stock adapter after update
        Stock stock = Stock.getInstance();
        adapter = new ListAdapter(stock.getIngredients());
        setListAdapter(adapter);
    }

}
