package com.pace.cs639spring.hw1;

import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kachi on 1/31/18.
 */

public class AnimalDisplayFragment extends Fragment implements View.OnClickListener{


    public Button blueBtn, redBtn, yellowBtn, greenBtn, cyanBtn;
    public ImageView catImage, dogImage, birdImage;
    public ImageView animalSelected;
    public TextView birdDesc, catDesc, dogDesc;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.animal_display, container, false);
        blueBtn = view.findViewById(R.id.blueButton);
        redBtn = view.findViewById(R.id.redButton);
        yellowBtn = view.findViewById(R.id.yellowButton);
        greenBtn = view.findViewById(R.id.greenButton);
        cyanBtn = view.findViewById(R.id.cyanButton);
        birdImage = view.findViewById(R.id.imageBird);
        catImage = view.findViewById(R.id.imageCat);
        dogImage = view.findViewById(R.id.imageDog);
        birdDesc = view.findViewById(R.id.birdDesc);
        catDesc = view.findViewById(R.id.catDesc);
        dogDesc = view.findViewById(R.id.dogDesc);
        animalSelected = null;

        blueBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        cyanBtn.setOnClickListener(this);
        birdImage.setOnClickListener(this);
        catImage.setOnClickListener(this);
        dogImage.setOnClickListener(this);


        return view;
    }


        @Override
        public void onClick(View view) {
            switch(view.getId()){           //uses a switch to ensure you only need one onclick method for buttons and images
                case R.id.imageBird:
                    if(birdDesc.getVisibility() == View.VISIBLE) //if animal is already selected when you click
                    {
                        birdDesc.setVisibility(View.INVISIBLE);
                        animalSelected = null;                  //reset selected animal
                    }
                    else
                    {
                        birdDesc.setVisibility(View.VISIBLE);   //set corresponding description to visible if it's invisible when clicked
                        dogDesc.setVisibility(View.INVISIBLE);
                        catDesc.setVisibility(View.INVISIBLE);
                        animalSelected = view.findViewById(R.id.imageBird); //set selected animal as the animal user clicks

                    }
                    break;

                case R.id.imageCat:
                    if(catDesc.getVisibility() == View.VISIBLE)
                    {
                        catDesc.setVisibility(View.INVISIBLE);
                        animalSelected = null;
                    }
                    else
                    {
                        dogDesc.setVisibility(View.INVISIBLE);
                        birdDesc.setVisibility(View.INVISIBLE);
                        catDesc.setVisibility(View.VISIBLE);
                        animalSelected = view.findViewById(R.id.imageCat);

                    }
                    break;

                case R.id.imageDog:
                    if(dogDesc.getVisibility() == View.VISIBLE)
                    {
                        dogDesc.setVisibility(View.INVISIBLE);
                        animalSelected = null;
                    }
                    else
                    {
                        catDesc.setVisibility(View.INVISIBLE);
                        birdDesc.setVisibility(View.INVISIBLE);
                        dogDesc.setVisibility(View.VISIBLE);
                        animalSelected = view.findViewById(R.id.imageDog);

                    }
                    break;

                case R.id.blueButton:
                {
                    if (animalSelected == null) // if user did not select an animal first, show a toast
                    {
                        Toast.makeText(getActivity(), "You must select an image before selecting a color!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        animalSelected.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                    }
                }
                break;

                case R.id.redButton:
                {
                    if (animalSelected == null) // if user did not select an animal first, show a toast
                    {
                        Toast.makeText(getActivity(), "You must select an image before selecting a color!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        animalSelected.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                    }
                }
                break;case R.id.cyanButton:
                {
                    if (animalSelected == null) // if user did not select an animal first, show a toast
                    {
                        Toast.makeText(getActivity(), "You must select an image before selecting a color!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        animalSelected.setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);
                    }
                }
                break;
                case R.id.greenButton:
                {
                    if (animalSelected == null) // if user did not select an animal first, show a toast
                    {
                        Toast.makeText(getActivity(), "You must select an image before selecting a color!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        animalSelected.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                    }
                }
                break;
                case R.id.yellowButton:
                {
                    if (animalSelected == null) // if user did not select an animal first, show a toast
                    {
                        Toast.makeText(getActivity(), "You must select an image before selecting a color!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        animalSelected.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                    }
                }
                break;

            }
        }





}
