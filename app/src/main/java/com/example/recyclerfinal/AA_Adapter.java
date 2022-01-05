package com.example.recyclerfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class AA_Adapter extends RecyclerView.Adapter<AA_Adapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<AminoModel> aminoModels;


        public AA_Adapter(Context context, ArrayList<AminoModel> aminoModels,RecyclerViewInterface recyclerViewInterface)
        {
                this.context = context;
                this.aminoModels = aminoModels;
                this.recyclerViewInterface = recyclerViewInterface;
        }

    @NonNull
    @Override
    public AA_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is where you inflate the layout (giving a look to our rows_)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row,parent,false);
        return new AA_Adapter.MyViewHolder(view,recyclerViewInterface );
    }

    @Override
    public void onBindViewHolder(@NonNull AA_Adapter.MyViewHolder holder, int position) {
//         assigning values to the view we created in the recycler_view_row layout file
        // based on the position of the recycler view
        holder.tvName.setText(aminoModels.get(position).getAminoAcidName());
        holder.tv3Letter.setText(aminoModels.get(position).getAminoAcidAbbreviation());
        holder.tv1Letter.setText(aminoModels.get(position).getAminoAcidAbbreviation());
        holder.imageView.setImageResource(aminoModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the numner of items you wants displayes
        return aminoModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grabbing the view from our recycler_view_row layout file
        // Knida like in the onCreate method

        ImageView imageView ;
        TextView tvName, tv3Letter,tv1Letter;
        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tv1Letter = itemView.findViewById(R.id.textView2);
            tv3Letter = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null)
                    {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION)
                        {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
