package com.example.criminalintent.controller.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.criminalintent.R;
import com.example.criminalintent.model.Crime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Important notes:
 * 1. Name adapter so you can reuse it
 * 2. Always have main collection non-null
 * 3. Preferably copy items to main collection, don't use model in the adapter
 */
public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.ViewHolder> {

    private List<Crime> items = new ArrayList<>();
    private Listener listener;

    private final DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

    public CrimeListAdapter() {
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item_crime_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Crime item = items.get(i);

        viewHolder.title.setText(item.getTitle());

        String date = dateFormat.format(item.getDateTime());
        viewHolder.date.setText(date);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(item);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener != null) {
                    listener.onLongClick(item);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * After you set new items in order to update the RecyclerView you should either:
     * - call setAdapter on RecyclerView
     * - call notifyDataSetChanged on the adapter
     */
    public void setItems(List<Crime> items) {
        this.items = items;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView date;
        // TODO add image to represent solved state of crime

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
        }
    }

    public interface Listener {
        void onClick(Crime item);
        void onLongClick(Crime item);
    }

}
