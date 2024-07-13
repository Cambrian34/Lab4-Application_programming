package edu.usta.cs3443.omi727_lab4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.ArrayList;

import edu.usta.cs3443.omi727_lab4.model.CrewMember;
import edu.usta.cs3443.omi727_lab4.model.Fleet;
import edu.usta.cs3443.omi727_lab4.model.Starship;

/**
 * @author Alistair Chambers (omi727)
 * UTSA CS 3443 - Lab 4
 */
public class StarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_starship);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //add a back-button to the toolbar to return to the main activity
        Toolbar toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        Intent intent = getIntent();
        String reg = intent.getStringExtra("starship");
        TextView textView = findViewById(R.id.starship_Names);
        textView.setText("USS Enterprise"+"\n"+reg);


        //load a Starship from file

        try {
            Context context = this;
            Fleet f1 = new Fleet("fleet.csv");
            f1.loadStarships("personnel.csv","fleet.csv",context);
            //all the data from the file
            ArrayList<Starship> starships = f1.getStarships();

            Log.d("StarshipData", "Reg: " + reg);
            //print size of arraylist
            Log.d("StarshipData", "Size: " + starships.size());
            //print their names
            for (Starship s : starships) {
                Log.d("StarshipData", "Name: " + s.getRegistry());
                if (s.getRegistry().equals("NCC-1701-A")&& reg.equals("NCC-1701-A")) {
                    System.out.println("Found it");
                    ArrayList<CrewMember> crew=s.getCrewMembers();
                    for(CrewMember c:crew){
                        //count++;
                        addTextView(c.getName(),c.getRank(),c.getPosition());
                        Log.d("StarshipData",c.getRank());
                    }

                }
                else if (s.getRegistry().equals("NCC-1701-D")&& reg.equals("NCC-1701-D")){
                    ArrayList<CrewMember> crew=s.getCrewMembers();
                    for(CrewMember c:crew){
                        addTextView(c.getName(),c.getRank(),c.getPosition());
                        Log.d("StarshipData",c.getRank());
                   }
                } else if (s.getRegistry().equals("NCC-74656")) {
                    ArrayList<CrewMember> crew=s.getCrewMembers();
                    for(CrewMember c:crew){
                        addTextView(c.getName(),c.getRank(),c.getPosition());
                        Log.d("StarshipData",c.getRank());

                    }
                    
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     *
     * @param text
     * @param rank1
     * @param position
     */
    private void addTextView(String text,String rank1, String position) {
        TextView textView = new TextView(this);

        SpannableStringBuilder spannable = new SpannableStringBuilder(position + "\n" );
        spannable.setSpan(new StyleSpan(Typeface.BOLD), 0, position.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // Bold first part
        spannable.setSpan(new RelativeSizeSpan(1.5f), 0, position.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // Increase font size
        spannable.append(rank1).append(" ").append(text);

        textView.setText(spannable);

        //create a layout for horizontal layout
        LinearLayout layout = findViewById(R.id.lin_lay);

        //create a second layout for horizontal layout
        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);

        layout2.setPadding(10,10,10,10);
        layout2.addView(getImage(text));
        layout2.addView(textView);
        layout.addView(layout2);


    }

    /**
     *
     * @param name
     * @return
     */
    private ImageView getImage(String name) {
        ImageView imageView= new ImageView(this);
        imageView.setPadding(10,10,10,10);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(250,250));
        switch (name) {
            case "James T. Kirk":
                imageView.setImageResource(R.drawable.kirk);
                break;
            case "Spock":
                imageView.setImageResource(R.drawable.spock);
                break;
            case "Leonard McCoy":
                imageView.setImageResource(R.drawable.mccoy);
                break;
            case "Montgomery Scott":
                imageView.setImageResource(R.drawable.scott);
                break;
            case "Jean-Luc Picard":
                imageView.setImageResource(R.drawable.picard);
                break;
            case "William T. Riker":
                imageView.setImageResource(R.drawable.riker);
                break;
            case "Beverly Crusher":
                imageView.setImageResource(R.drawable.crusher);
                break;
            case "Geordi La Forge":
                imageView.setImageResource(R.drawable.la_forge);
                break;
            case "Worf":
                imageView.setImageResource(R.drawable.worf);
                break;
            case "Deanna Troi":
                imageView.setImageResource(R.drawable.troi);
                break;
            case "Data":
                imageView.setImageResource(R.drawable.data);
                break;
            case "Tom Paris":
                imageView.setImageResource(R.drawable.paris);
                break;
            case "Christine Chapel":
                imageView.setImageResource(R.drawable.chapel);

                break;
            case "B'Elanna Torres":
                imageView.setImageResource(R.drawable.torres);

                break;
            case "Tasha Yar":
                imageView.setImageResource(R.drawable.yar);

                break;
            case "The Doctor":
                imageView.setImageResource(R.drawable.doctor);

                break;
            case "Neelix":
                imageView.setImageResource(R.drawable.neelix);

                break;
            case "Hikaru Sulu":
                imageView.setImageResource(R.drawable.sulu);
                break;
            case "Kes":
                imageView.setImageResource(R.drawable.kes);
                break;
            case "Pavel Chekov":
                imageView.setImageResource(R.drawable.chekov);
                break;
            case "Kathryn Janeway":
                imageView.setImageResource(R.drawable.janeway);

                break;
            case "Chakotay":
                imageView.setImageResource(R.drawable.chakotay);
                break;
            case "Tuvok":
                imageView.setImageResource(R.drawable.tuvok);

                break;
            case "Nyota Uhura":
                imageView.setImageResource(R.drawable.uhura);
                break;
            default:
                imageView.setImageResource(R.drawable.ic_launcher_background);
                break;
        }


        return imageView;
    }

}