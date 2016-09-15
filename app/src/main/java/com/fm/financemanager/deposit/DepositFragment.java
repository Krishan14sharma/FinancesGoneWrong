package com.fm.financemanager.deposit;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fm.financemanager.BusProvider;
import com.fm.financemanager.R;
import com.fm.financemanager.deposit.dummy.DummyContent.Deposit;
import com.squareup.otto.Subscribe;

import static com.fm.financemanager.deposit.dummy.DummyContent.ITEMS;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class DepositFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private MyDepositRecyclerViewAdapter adapter;

    public DepositFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DepositFragment newInstance(int columnCount) {
        DepositFragment fragment = new DepositFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter = new MyDepositRecyclerViewAdapter(ITEMS);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        BusProvider.getBus().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        BusProvider.getBus().unregister(this);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Deposit item);
    }

    @Subscribe
    public void deposited(Deposit event) {
        event.id = String.valueOf(ITEMS.size() + 1);
        ITEMS.add(event);
        adapter.notifyDataSetChanged();
    }
}
