package com.example.recyclerfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  RecyclerViewInterface{

    ArrayList<AminoModel> aminoAcidModels = new ArrayList<>();
    int[] aminoAcidImages = {R.drawable.ic_1,R.drawable.ic_3,R.drawable.ic_1,R.drawable.ic_1,R.drawable.ic_3,R.drawable.ic_1,R.drawable.ic_1,R.drawable.ic_3,R.drawable.ic_1,R.drawable.ic_baseline_filter_drama_24};
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            RecyclerView recyclerView = findViewById(R.id.mRecyclerView);


        setUpAminoAcidModels(); //calling

            AA_Adapter adapter = new AA_Adapter(this,
                    aminoAcidModels,this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpAminoAcidModels()
    {
        String[] aminoAcidNames = getResources().getStringArray(R.array.amino_acids_full_txt);
        String[] aminoAcidAbbr = getResources().getStringArray(R.array.amino_acids_three_letter_txt);
        String[] aminoAcidAbbrSmall = getResources().getStringArray(R.array.amino_acids_one_letter_txt);
        String[] description = getResources().getStringArray(R.array.dec_tet);

        for(int i =0;i<aminoAcidNames.length;i++)
        {
            aminoAcidModels.add(new AminoModel(aminoAcidNames[i],
                    aminoAcidAbbr[i],
                    aminoAcidAbbrSmall[i],
                    aminoAcidImages[i],
                    description[i]));


        }




    }
// onitem
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);

        intent.putExtra("NAME",aminoAcidModels.get(position).getAminoAcidName());
        intent.putExtra("ABBR_BIG",aminoAcidModels.get(position).getAminoAcidAbbreviation());
        intent.putExtra("ABBR_SMALL",aminoAcidModels.get(position).getAminoAcidAbbreviatinSmall());
        intent.putExtra("DESCRIPTION",aminoAcidModels.get(position).getDescription());
        intent.putExtra("IMAGE",aminoAcidModels.get(position).getImage());

        startActivity(intent);

    }
}