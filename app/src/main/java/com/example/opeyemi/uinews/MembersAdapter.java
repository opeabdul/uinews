package com.example.opeyemi.uinews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.opeyemi.uinews.R;

public class MembersAdapter extends RecyclerView.Adapter {

    private String[] mMembersNames = {"Abdulsalam Opeyemi","Adebayo-ige Toyosi",
            "Ogbolie Abaraham", "Abdulkareem Oluwatoyin", "Odi Glory Ebube", "Talabi Ibrahim",
            "Dahunsi Oluwatobi", "Adeagbo Ololade", "Adedeji Azeez", "Adeeyo Ridwan"};
    private String[] mMembersDuties ={"Document","Presenter","Organize","Control", "Plan",
            "Staffing", "Execution", "Photography", "Compliance", "Risk"};


    public class MembersAdapterViewHolder extends RecyclerView.ViewHolder{

        public final TextView mMemberNameTextView;
        public final TextView mMemberDutyTextView;

        public MembersAdapterViewHolder(View itemView) {
            super(itemView);
            mMemberNameTextView = itemView.findViewById(R.id.member_name_textView);
            mMemberDutyTextView = itemView.findViewById(R.id.member_duty_textView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Boolean attachToParentImmediately = false;
        int LayoutIdForMemberListItem = R.layout.members_list_item;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(LayoutIdForMemberListItem,parent,attachToParentImmediately);
        return new MembersAdapterViewHolder(view);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        bindMembersViewHolder((MembersAdapterViewHolder) holder, position );

    }

    private void bindMembersViewHolder(MembersAdapterViewHolder membersAdapterViewHolder, int position) {
        String currentName = mMembersNames[position];
        String currentDuty = mMembersDuties[position];
        membersAdapterViewHolder.mMemberNameTextView.setText(currentName);
        membersAdapterViewHolder.mMemberDutyTextView.setText(currentDuty);
    }

    @Override
    public int getItemCount() {
        if(mMembersDuties == null | mMembersNames == null ) return 0;
        return mMembersDuties.length;
    }


}
