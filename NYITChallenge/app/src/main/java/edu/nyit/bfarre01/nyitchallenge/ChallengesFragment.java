package edu.nyit.bfarre01.nyitchallenge;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChallengesFragment extends ListFragment {
    private List<ListViewItem> mItems;        // ListView items list

    public static ChallengesFragment newInstance(int page, String param2) {
        ChallengesFragment fragment = new ChallengesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<ListViewItem>();
        Resources resources = getResources();

        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.ic_shield), getString(R.string.challenge1), getString(R.string.description)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.ic_shield), getString(R.string.challenge2), getString(R.string.description)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.ic_shield), getString(R.string.challenge3), getString(R.string.description)));

        // initialize and set the list adapter
        setListAdapter(new ListViewAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ListViewItem item = mItems.get(position);

        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ChallengeViewActivity.class);
        intent.putExtra("title", item.title);
        intent.putExtra("description", item.description);
        startActivity(intent);
    }
}
