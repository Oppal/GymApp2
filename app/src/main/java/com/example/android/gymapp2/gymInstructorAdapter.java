package com.example.android.gymapp2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class gymInstructorAdapter extends RecyclerView.Adapter<gymInstructorAdapter.InstructorViewHolder> {


    private Context mCtx;
    private List<Instructor> instructorList;

    public gymInstructorAdapter(Context mCtx, List<Instructor> instructorList) {
        this.mCtx = mCtx;
        this.instructorList = instructorList;
    }

    @NonNull
    @Override
    public InstructorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.instructors_list, null);
        return new InstructorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstructorViewHolder holder, int position) {
        Instructor instructor = instructorList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(gymInstructor.getImage())
                .into(holder.imageView);

        holder.textViewFirstname.setText(gymInstructor.getFirstname());
        holder.textViewLastname.setText(gymInstructor.getLastname());
        holder.textViewNickname.setText(gymInstructor.getNickname());
        holder.textViewCurrent_gym.setText(gymInstructor.getCurrent_gym());
        holder.textViewDescription.setText(gymInstructor.getDescription());
    }

    @Override
    public int getItemCount() {
        return instructorList.size();
    }

    class InstructorViewHolder extends RecyclerView.ViewHolder{

        TextView textViewFirstname, textViewLastname, textViewNickname, textViewCurrent_gym, textViewDescription;
        ImageView imageView;
    public InstructorViewHolder(View itemView) {
        super(itemView);
        textViewFirstname = itemView.findViewById(R.id.textViewFirstname);
        textViewLastname = itemView.findViewById(R.id.textViewLastname);
        textViewNickname = itemView.findViewById(R.id.textViewNickname);
        textViewCurrent_gym = itemView.findViewById(R.id.textViewCurrent_gym);
        imageView = itemView.findViewById(R.id.imageView);

    }
}


}