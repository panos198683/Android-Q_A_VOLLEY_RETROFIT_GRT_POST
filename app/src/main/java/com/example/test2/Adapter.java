package com.example.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
//LayoutInflater inflater;
private ArrayList<Comp> comps;
private Context mContext;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
public void setOnItemClickListener(OnItemClickListener listener)
{
    mListener=listener;

}

public Adapter(Context context ,ArrayList<Comp> exampleList)
{
    //this.inflater=LayoutInflater.from(ctx);

    mContext= context;
    comps=exampleList;

}


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.custom_list_layout,parent,false);

    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Comp currentItem =comps.get(position);
        String id= currentItem.getId();
        int Bgroup=currentItem.getBgroup();
        String BranchArea=currentItem.getBranchArea();
        String BranchCity=currentItem.getBranchCity();
        String BranchName=currentItem.getBranchName();
        String BranchPassword=currentItem.getBranchPassword();

        holder.id.setText(id);
        holder.Bgoup.setText(""+Bgroup); //ayth h grammh moy barage error mia mera oloklhrh giati den eixa balei autakia  :P.
        holder.BranchArea.setText(BranchArea);
        holder.BranchCity.setText(BranchCity);
        holder.BranchName.setText(BranchName);
        holder.BranchPassword.setText(BranchPassword);
    }

    @Override
    public int getItemCount() {
        return comps.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
    public TextView id,Bgoup,BranchArea,BranchCity,BranchName,BranchPassword;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            id=itemView.findViewById(R.id.coid);
            Bgoup=itemView.findViewById(R.id.cobgroup);
            BranchArea=itemView.findViewById(R.id.coArea);
            BranchCity=itemView.findViewById(R.id.cocity);
            BranchName=itemView.findViewById(R.id.coName);
            BranchPassword=itemView.findViewById(R.id.copassword);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                        }
                        }
                    }
                });
            }

        }
    }

