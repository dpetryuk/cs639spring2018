package com.pace.cs639spring.hw2;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AnimalDisplayListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_display);
        configureActivity();
    }


    private void configureActivity() {
        ListView listView = findViewById(R.id.listView);

        View red = findViewById(R.id.red);
        View orange = findViewById(R.id.orange);
        View green = findViewById(R.id.green);
        View blue = findViewById(R.id.blue);
        View yellow = findViewById(R.id.yellow);

        Button addFactBtn = findViewById(R.id.addFactBtn);



        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Bird",  R.drawable.bird, "This is a bird"));
        animalList.add(new Animal("Cat", R.drawable.cat, "This is a cat"));
        animalList.add(new Animal("Dog", R.drawable.dog, "This is a dog"));
        animalList.add(new Animal("Cow", R.drawable.cow, "This is a cow"));
        animalList.add(new Animal("Elephant", R.drawable.elephant, "This is a elephant"));
        animalList.add(new Animal("Llama", R.drawable.llama, "This is a llama"));
        animalList.add(new Animal("Pig", R.drawable.pig, "This is a pig"));
        animalList.add(new Animal("Raccoon", R.drawable.raccoon, "This is a raccoon"));
        animalList.add(new Animal("Bunny", R.drawable.bunny, "This is a bunny"));
        animalList.add(new Animal("Turtle", R.drawable.turtle, "This is a turtle"));



        adapter = new AnimalDisplayListViewAdapter(getBaseContext(), animalList);

        listView.setAdapter(adapter);
        listView.setItemsCanFocus(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Uses setSelectedPosition() to save the position of a
                // clicked item to mSelectedPosition for view visibility logic in adapter class.
                adapter.setSelectedPosition(position);
                adapter.notifyDataSetChanged();
            }
        });

        //Color Click Listener
        View.OnClickListener colorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get selected item from the adapter. If item is not selected, return toast message.
                if (adapter.getSelectedPosition() == -1)
                {
                    Toast.makeText(MainActivity.this, "You must first select an animal", Toast.LENGTH_SHORT).show();
                } else{
                    int mSelectedImage = adapter.getSelectedPosition();
                    // gets color of button
                    int btnBackgroundColor = ((ColorDrawable) view.getBackground()).getColor();
                    // gets image from item and sets color of image to color of button
                    Animal a = (Animal) adapter.getItem(mSelectedImage);
                    a.setmColorFilter(btnBackgroundColor);
                    adapter.notifyDataSetChanged();
                }
            }
        };

        red.setOnClickListener(colorListener);
        orange.setOnClickListener(colorListener);
        green.setOnClickListener(colorListener);
        blue.setOnClickListener(colorListener);
        yellow.setOnClickListener(colorListener);





        // Add-fact button listener
        addFactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText factInputField = findViewById(R.id.addFactEditText);
                int mPosition = adapter.getSelectedPosition();
                String newFact = factInputField.getText().toString().trim();

                if(TextUtils.isEmpty(newFact)){
                    Toast.makeText(MainActivity.this, "You must enter a fact first!", Toast.LENGTH_SHORT).show();
                }else if (mPosition == -1){
                    Toast.makeText(MainActivity.this, "You must first select an animal", Toast.LENGTH_SHORT).show();
                }else{
                    Animal factItem = (Animal) adapter.getItem(mPosition);
                    factItem.addFact(newFact);
                    factInputField.getText().clear();
                    Log.e("fact list",factItem.getmFactList().toString());
                    Toast.makeText(MainActivity.this, "Fact successfully added", Toast.LENGTH_SHORT).show();
                }



            }
        });




    }




}
