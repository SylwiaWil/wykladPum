package com.example.wilczek.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Sylwia on 12/11/2017.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private ArrayList<Animal> animals = new ArrayList<>();

    AnimalAdapter(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, null);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setAnimalName(animals.get(position).getName());
        holder.setAge(animals.get(position).getAge() + "");

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.age_animal)
        TextView animalAge;

        @BindView(R.id.animal_name)
        TextView animalName;

        @OnClick(R.id.animal_select)
        void selectAnimal() {

            openAlertDialog();
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setAnimalName(String name) {
            animalName.setText(name);
        }

        private void setAge(String age) {
            animalAge.setText(age);
        }

        private void openAlertDialog() {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(itemView.getContext(), android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(itemView.getContext());
            }
            builder.setTitle(itemView.getContext().getString(R.string.alert_title))
                    .setMessage(itemView.getContext().getString(R.string.alert_dialog))
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //n
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}

