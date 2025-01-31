package com.example.madprojectassign3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home_page extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.banner1);
        imageList.add(R.drawable.banner2);
        imageList.add(R.drawable.banner3);
        imageList.add(R.drawable.banner4);
        imageList.add(R.drawable.banner5);

        ImageAdapter adapter = new ImageAdapter(imageList);
        recyclerView.setAdapter(adapter);

        ViewFlipper viewFlipper = findViewById(R.id.view_flipper);
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);

        viewFlipper.setFlipInterval(1400);
        viewFlipper.startFlipping();

        ImageView imageView = findViewById(R.id.voucher);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Home_page.this, voucher.class);
            startActivity(intent);
        });

        ImageView secondImageView = findViewById(R.id.buynow);
        secondImageView.setOnClickListener(v -> {
            Intent intent = new Intent(Home_page.this, product_page.class);
            startActivity(intent);
        });
        ImageView thirdImageView = findViewById(R.id.personal_button);
        thirdImageView.setOnClickListener(v -> {
            Intent intent = new Intent(Home_page.this, personal_info.class);
            startActivity(intent);
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button ai = findViewById(R.id.ai);
        ai.setOnClickListener(v -> {
            Intent intent = new Intent(Home_page.this,AI_Chatbot.class);
            startActivity(intent);
        });
    }

    private static class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

        private final List<Integer> imageList;

        public ImageAdapter(List<Integer> imageList) {
            this.imageList = imageList;
        }

        @NonNull
        @Override
        public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
            return new ImageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
            holder.imageView.setImageResource(imageList.get(position));

            holder.imageView.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), product_page.class);
                v.getContext().startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return imageList.size();
        }

        static class ImageViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public ImageViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }


}
