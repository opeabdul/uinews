package com.example.opeyemi.uinews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private RecyclerView mMembersRecyclerView;  //Recycler view to display list of group members
    private MembersAdapter membersAdapter;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container,false);
        mMembersRecyclerView = view.findViewById(R.id.member_list_RecyclerView);

        //setting the layout manager fot the recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        mMembersRecyclerView.setLayoutManager(linearLayoutManager);

        //in order to improve performance since changes in content do not change the child layout
        // size in the recycler view
        mMembersRecyclerView.setHasFixedSize(true);


        //setting the adapter for the recycler view
        membersAdapter = new MembersAdapter();
        mMembersRecyclerView.setAdapter(membersAdapter);

        return view;

    }

}
