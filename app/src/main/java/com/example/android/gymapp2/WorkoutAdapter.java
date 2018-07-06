package com.example.android.gymapp2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;



public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.MyViewHolder> {

    private Context mContext;
    private List<item> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);

            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                }
            });
        }
    }


    public WorkoutAdapter(Context mContext, List<item> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_cardview, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final item album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getDescription());

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(album.getName()== "Full Body"){
                    Intent intent=new Intent(mContext, MapsActivity.class);
                    intent.putExtra("name",albumList.get(position).toString());
                    mContext. startActivity(intent);}
                else if(album.getName()== "Lower Body"){

                    Toast.makeText(mContext, "Lower Body", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(mContext, workout.class);
                    intent.putExtra("name",albumList.get(position).toString());
                    mContext. startActivity(intent);
                }
                else if(album.getName()== "Upper Body"){
                    Intent intent=new Intent(mContext, Instructor.class);
                    intent.putExtra("name",albumList.get(position).toString());
                    mContext. startActivity(intent);

                    Toast.makeText(mContext, "Upper Body", Toast.LENGTH_SHORT).show();

                }
                else if(album.getName()== "Beginner Workout"){
                    Intent intent=new Intent(mContext, Instructor.class);
                    intent.putExtra("name",albumList.get(position).toString());
                    mContext. startActivity(intent);

                    Toast.makeText(mContext, "Beginners", Toast.LENGTH_SHORT).show();

                }
                else if(album.getName()== "Aerobics and Cardio"){
                    Intent intent=new Intent(mContext, Instructor.class);
                    intent.putExtra("name",albumList.get(position).toString());
                    mContext. startActivity(intent);

                    Toast.makeText(mContext, "Instructors", Toast.LENGTH_SHORT).show();

                }
            }
        });

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.workeritem_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.action_view:
                    Toast.makeText(mContext, "View", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_add_to_workout:
                    Toast.makeText(mContext, "Add to Workout", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}