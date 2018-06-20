package cl.pingon.technicalvisit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.pingon.technicalvisit.R;
import cl.pingon.technicalvisit.data.Queries;
import cl.pingon.technicalvisit.models.Visit;

public class VisitAdapter extends RecyclerView.Adapter<VisitAdapter.ViewHolder> {

    private List<Visit> visits = new Queries().visits();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visits_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Visit visit = visits.get(position);
        holder.clientTv.setText(visit.getClient());
        holder.projectTv.setText(visit.getProject());
        holder.directionTv.setText(visit.getDirection());
        holder.checkBox.setChecked(visit.isVisited());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            }
        });

        holder.clientTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.projectTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.directionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return visits.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView clientTv;
        private TextView projectTv;
        private TextView directionTv;


        public ViewHolder(View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.visitedCb);
            clientTv = itemView.findViewById(R.id.clientTv);
            projectTv = itemView.findViewById(R.id.projectTv);
            directionTv = itemView.findViewById(R.id.directionTv);

        }
    }

}
