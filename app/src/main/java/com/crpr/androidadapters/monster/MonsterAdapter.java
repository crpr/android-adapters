package com.crpr.androidadapters.monster;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.models.AdapterModel;
import com.crpr.androidadapters.common.models.ContactDto;
import com.crpr.androidadapters.common.models.DummyDto;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.models.HeaderDto;

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
            case AdapterModel.CONTACT_TYPE:
                view = inflater.inflate(R.layout.layout_contact_item, parent, false);
                return new MonsterContactViewHolder(view, listener);
            case AdapterModel.DUMMY_TYPE:
                view = inflater.inflate(R.layout.layout_dummy_item, parent, false);
                return new MonsterDummyViewHolder(view, listener);
            default:
                view = inflater.inflate(R.layout.layout_separator_item, parent, false);
                return new MonsterSeparatorViewHolder(view, listener);

        }
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position).getType();
    }

    public AdapterModel getItemByPosition(int position){
        return models.get(position);
    }

    @Override
    public void onBindViewHolder(MonsterViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case AdapterModel.CONTACT_TYPE:
                bindContact((MonsterContactViewHolder) holder, models.get(position).getContact());
                break;
            case AdapterModel.DUMMY_TYPE:
                bindDummy((MonsterDummyViewHolder) holder, models.get(position).getDummy());
                break;
            default:
                bindSeparator((MonsterSeparatorViewHolder) holder, models.get(position).getHeader());
        }
    }

    private void bindSeparator(MonsterSeparatorViewHolder holder, HeaderDto header){
        holder.label.setText(header.getLabel());
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
        private TextView name;
        private TextView email;

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
        private TextView left;
        private TextView right;

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
        private TextView label;

        public MonsterSeparatorViewHolder(View itemView, RecyclerItemTouchListener recyclerClickListener) {
            super(itemView, recyclerClickListener);
        }

        @Override
        protected void bindViews(View itemView) {
            label = (TextView) itemView.findViewById(R.id.header_label);
        }
    }

}
