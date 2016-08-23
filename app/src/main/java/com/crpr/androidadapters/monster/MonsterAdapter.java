package com.crpr.androidadapters.monster;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.AdapterModel;
import com.crpr.androidadapters.common.ContactDto;
import com.crpr.androidadapters.common.DummyDto;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;

import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder>{

    private final List<AdapterModel> models;
    private final RecyclerItemTouchListener listener;
    private final LayoutInflater inflater;

    public MonsterAdapter(Context context, List<AdapterModel> models, RecyclerItemTouchListener listener){
        this.inflater = LayoutInflater.from(context);
        this.models = models;
        this.listener = listener;
    }

    @Override
    public MonsterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType){
            case MonsterContactViewHolder.CONTACT_TYPE:
                view = inflater.inflate(R.layout.layout_contact_item, parent, false);
                return new MonsterContactViewHolder(view, listener);
            case MonsterDummyViewHolder.DUMMY_TYPE:
                view = inflater.inflate(R.layout.layout_dummy_item, parent, false);
                return new MonsterDummyViewHolder(view, listener);
            default:
                view = inflater.inflate(R.layout.layout_separator_item, parent, false);
                return new MonsterSeparatorViewHolder(view, listener);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(models.get(position).isSeparator()){
            return MonsterSeparatorViewHolder.SEPARATOR_TYPE;
        }

        return models.get(position).getContact() == null ?
                MonsterDummyViewHolder.DUMMY_TYPE : MonsterContactViewHolder.CONTACT_TYPE;
    }

    public AdapterModel getItemByPosition(int position){
        return models.get(position);
    }

    @Override
    public void onBindViewHolder(MonsterViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case MonsterContactViewHolder.CONTACT_TYPE:
                bindContact((MonsterContactViewHolder) holder, models.get(position).getContact());
                break;
            case MonsterDummyViewHolder.DUMMY_TYPE:
                bindDummy((MonsterDummyViewHolder) holder, models.get(position).getDummy());
                break;
            default:
                return;
        }
    }

    private void bindDummy(MonsterDummyViewHolder holder, DummyDto dummy) {
        holder.left.setText(dummy.getLeftLabel());
        holder.right.setText(dummy.getRightLabel());
    }

    private void bindContact(MonsterContactViewHolder holder, ContactDto contact) {
        holder.name.setText(contact.getName());
        holder.email.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class MonsterViewHolder extends RecyclerView.ViewHolder {

        public MonsterViewHolder(View itemView, final RecyclerItemTouchListener recyclerClickListener) {
            super(itemView);
            bindViews(itemView);
            bindTouchListener(itemView, recyclerClickListener);
        }

        protected void bindViews(View itemView) {

        }

        private void bindTouchListener(final View view, final RecyclerItemTouchListener recyclerItemClickListener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerItemClickListener.onTouch(view, getLayoutPosition());
                }
            });
        }
    }

    static class MonsterContactViewHolder extends MonsterViewHolder {

        public static final int CONTACT_TYPE = 0;

        TextView name;
        TextView email;

        public MonsterContactViewHolder(View itemView, RecyclerItemTouchListener recyclerClickListener) {
            super(itemView, recyclerClickListener);
        }

        @Override
        protected void bindViews(View itemView) {
            name = (TextView) itemView.findViewById(R.id.contact_top_label);
            email = (TextView) itemView.findViewById(R.id.contact_bottom_label);
        }
    }

    static class MonsterDummyViewHolder extends MonsterViewHolder {

        public static final int DUMMY_TYPE = 1;

        TextView left;
        TextView right;

        public MonsterDummyViewHolder(View itemView, RecyclerItemTouchListener recyclerClickListener) {
            super(itemView, recyclerClickListener);
        }

        @Override
        protected void bindViews(View itemView) {
            left = (TextView) itemView.findViewById(R.id.dummy_left_label);
            right = (TextView) itemView.findViewById(R.id.dummy_right_label);
        }
    }

    static class MonsterSeparatorViewHolder extends MonsterViewHolder {

        public static final int SEPARATOR_TYPE = 2;

        public MonsterSeparatorViewHolder(View itemView, RecyclerItemTouchListener recyclerClickListener) {
            super(itemView, recyclerClickListener);
        }
    }

}