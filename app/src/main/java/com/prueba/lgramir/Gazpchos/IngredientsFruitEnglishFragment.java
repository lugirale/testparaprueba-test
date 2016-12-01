package com.prueba.lgramir.Gazpchos;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IngredientsFruitEnglishFragment  extends Fragment {

    private Button mTradicionalButton;
    private Button  mNextButton;
    private TextView mQuestionTextView;
    private ListView mcheckList;

    private ImageView image;


    ArrayList<String> selectedItems= new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ingredients_fruit_english, parent, false);

        mQuestionTextView = (TextView) v.findViewById(R.id.question_text_view);

        mcheckList = (ListView) v.findViewById(R.id.checkable_list);

        mcheckList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayList<String> items =  Singleton.getInstance().getFruitIngredients();

        ArrayList<String>copy = new ArrayList<String>();
        copy.addAll(items);

        for (String item : copy) {

            if (item.contains("Jicama")) {
                int i = copy.indexOf("Jicama");
                copy.set(i, "Jicama");
            }

            else if (item.contains("Pepino")) {
                int i = copy.indexOf("Pepino");
                copy.set(i,"cucumber");

            }else if (item.contains("Concombre")) {
                int i = copy.indexOf("Concombre");
                copy.set(i,"cucumber");
            }

            else if (item.contains("Sandia")) {
                int i = copy.indexOf("Sandia");
                copy.set(i,"watermelon");
            }

            else if (item.contains("Mango")) {
                int i = copy.indexOf("Mango");
                copy.set(i,"Mango");
            }

            else if (item.contains("Piña")) {
                int i = copy.indexOf("Piña");
                copy.set(i,"pineapple");
            }
            else if (item.contains("Ananas")) {
                int i = copy.indexOf("Ananas");
                copy.set(i,"pineapple");
            }

            else if (item.contains("Papaya")) {
                int i = copy.indexOf("Papaya");
                copy.set(i,"Pawpaw");
            }
            else if (item.contains("La papaye")) {
                int i = copy.indexOf("La papaye");
                copy.set(i,"Pawpaw");
            }

            else if (item.contains("Melon")) {
                int i = copy.indexOf("Melon");
                copy.set(i,"Cantaloupe");
            }

            else if (item.contains("Naranja")) {
                int i = copy.indexOf("Naranja");
                copy.set(i,"Orange");
            }

            else if (item.contains("Tuna")) {
                int i = copy.indexOf("Tuna");
                copy.set(i,"Tuna from nopal");
            }
            else if (item.contains("Oponce")) {
                int i = copy.indexOf("Oponce");
                copy.set(i,"Tuna from nopal");
            }

            else if (item.contains("Coco")) {
                int i = copy.indexOf("Coco");
                copy.set(i,"Coconut");
            }

            else if (item.contains("Jugo de naranja")) {
                int i = copy.indexOf("Jugo de naranja");
                copy.set(i,"Orange juice");
            }
            else if (item.contains("Jus d'orange")) {
                int i = copy.indexOf("Jus d'orange");
                copy.set(i,"Orange juice");
            }

            else if (item.contains("Limon")) {
                int i = copy.indexOf("Limon");
                copy.set(i,"Lemon juice");
            }
            else if (item.contains("Jus de citron")) {
                int i = copy.indexOf("Jus de citron");
                copy.set(i,"Lemon juice");
            }

            else if (item.contains("Sal")) {
                int i = copy.indexOf("Sal");
                copy.set(i,"Salt");
            }
            else if (item.contains("Le sel")) {
                int i = copy.indexOf("Le sel");
                copy.set(i,"Salt");
            }

            else if (item.contains("Chile en polvo")) {
                int i = copy.indexOf("Chile en polvo");
                copy.set(i,"Chili powder");
            }
            else if (item.contains("Poudre de chili")) {
                int i = copy.indexOf("Poudre de chili");
                copy.set(i,"Chili powder");
            }

            else if (item.contains("Chile de botella")) {
                int i = copy.indexOf("Chile de botella");
                copy.set(i,"Hot sauce");
            }
            else if (item.contains("Chili bouteille")) {
                int i = copy.indexOf("Chili bouteille");
                copy.set(i,"Hot sauce");
            }

            else if (item.contains("Queso")) {
                int i = copy.indexOf("Queso");
                copy.set(i,"Grated cheese");
            }
            else if (item.contains("Fromage")) {
                int i = copy.indexOf("Fromage");
                copy.set(i,"Grated cheese");
            }

        }


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.rowlayout, R.id.txt_ingredients,copy);
        mcheckList.setAdapter(adapter);

        mcheckList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();
                if (selectedItems.contains(selectedItem)) {
                    selectedItems.remove(selectedItem); //uncheck itme
                } else
                    selectedItems.add(selectedItem);
            }
        });

        mNextButton = (Button) v.findViewById(R.id.selected_ingredients_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setIngredientsEnglish(selectedItems);
                Intent intent = new Intent(getActivity(), SizeFruitEnglishActivity.class);
                startActivity(intent);

                if(selectedItems.size()!=0){
                    showSelectedItems(selectedItems);

                }else
                    Toast.makeText(getActivity(),R.string.english_ingredients_toast, Toast.LENGTH_SHORT).show();

            }

        });

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LanguageActivity.class);
                // finish(); // to simulate "restart" of the activity.
                startActivity(intent);
            }
        });

        return v;
    }

    public void showSelectedItems(ArrayList<String> view){
        String items = " ";

        for(String item:selectedItems){
            items+= item +"\n";
        }
        Toast.makeText(getActivity(),"selected ingredients: \n"+items, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}


