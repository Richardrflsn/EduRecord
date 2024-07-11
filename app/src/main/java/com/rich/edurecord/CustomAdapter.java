package com.rich.edurecord;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<String> student_id, student_name, student_nim, student_ipk, student_course;

    CustomAdapter(Activity activity, ArrayList<String> student_id, ArrayList<String> student_name,
                  ArrayList<String> student_nim, ArrayList<String> student_ipk, ArrayList<String> student_course) {
        this.activity = activity;
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_nim = student_nim;
        this.student_ipk = student_ipk;
        this.student_course = student_course;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.student_id_txt.setText(student_id.get(position));
        holder.student_name_txt.setText(student_name.get(position));
        holder.student_nim_txt.setText(student_nim.get(position));
        holder.student_ipk_txt.setText(student_ipk.get(position));
        holder.student_course_txt.setText(student_course.get(position));

        // RecyclerView onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, UpdateActivity.class);
                intent.putExtra("id", student_id.get(position));
                intent.putExtra("name", student_name.get(position));
                intent.putExtra("nim", student_nim.get(position));
                intent.putExtra("ipk", student_ipk.get(position));
                intent.putExtra("course", student_course.get(position));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return student_id.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView student_id_txt, student_name_txt, student_nim_txt, student_ipk_txt, student_course_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            student_id_txt = itemView.findViewById(R.id.student_id_txt);
            student_name_txt = itemView.findViewById(R.id.student_name_txt);
            student_nim_txt = itemView.findViewById(R.id.student_nim_txt);
            student_ipk_txt = itemView.findViewById(R.id.student_ipk_txt);
            student_course_txt = itemView.findViewById(R.id.student_course_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            // Animate RecyclerView item
            Animation translate_anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
