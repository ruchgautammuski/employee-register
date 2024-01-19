package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Employee;

import java.util.List;

import lunainc.com.mx.notasapp.adapter.NoteAdapter;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>{

    private List<Employee> mData;
    private LayoutInflater mInflater;
    private Context context;


    public EmployeeAdapter(Context context, List<Employee> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item, parent, false);
        return new EmployeeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
        Employee employee = mData.get(position);

        holder.name.setText(nota.getName());
        holder.description.setText(nota.getDescription());

        if (nota.getStatus().equals("incomplete")){
            holder.statusText.setText(R.string.incomplete);
            holder.statusText.setTextColor(ContextCompat.getColor(context, R.color.colorOrange));
            holder.statusView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorOrange));
            holder.iconStatus.setBackground(ContextCompat.getDrawable(context, R.drawable.orange_circle));
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        @BindView(R.id.statusView)
        View statusView;

        @BindView(R.id.iconStatus)
        View iconStatus;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.description)
        TextView description;

        @BindView(R.id.statusText)
        TextView statusText;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            if (mLongClickListener != null) mLongClickListener.onItemLongClick(v, getAdapterPosition());
            return false;
        }
    }

}
