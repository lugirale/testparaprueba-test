package com.prueba.lgramir.Gazpchos;

import android.content.Intent;
import android.os.Bundle;
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

public class IngredientsFruitFrenchFragment  extends Fragment {

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
        View v = inflater.inflate(R.layout.fragment_ingredients_fruit_french, parent, false);

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
                copy.set(i,"Concombre");
            }
            else if (item.contains("cucumber")) {
                int i = copy.indexOf("cucumber");
                copy.set(i,"Concombre");
            }

            else if (item.contains("Sandia")) {
                int i = copy.indexOf("Sandia");
                copy.set(i,"Sandia");
            }
            else if (item.contains("watermelon")) {
                int i = copy.indexOf("watermelon");
                copy.set(i,"Sandia");
            }

            else if (item.contains("Mango")) {
                int i = copy.indexOf("Mango");
                copy.set(i,"Mango");
            }

            else if (item.contains("Piña")) {
                int i = copy.indexOf("Piña");
                copy.set(i,"Ananas");
            }
            else if (item.contains("pineapple")) {
                int i = copy.indexOf("pineapple");
                copy.set(i,"Ananas");
            }

            else if (item.contains("Papaya")) {
                int i = copy.indexOf("Papaya");
                copy.set(i,"La papaye");
            }
            else if (item.contains("Pawpaw")) {
                int i = copy.indexOf("Pawpaw");
                copy.set(i,"La papaye");
            }

            else if (item.contains("Cantaloupe")) {
                int i = copy.indexOf("Cantaloupe");
                copy.set(i,"Melon");
            }

            else if (item.contains("Naranja")) {
                int i = copy.indexOf("Naranja");
                copy.set(i,"Orange");
            }

            else if (item.contains("Tuna")) {
                int i = copy.indexOf("Tuna");
                copy.set(i,"Oponce");
            }
            else if (item.contains("Tuna from nopal")) {
                int i = copy.indexOf("Tuna from nopal");
                copy.set(i,"Oponce");
            }

            else if (item.contains("Coconut")) {
                int i = copy.indexOf("Coconut");
                copy.set(i,"Coco");
            }

            else if (item.contains("Jugo de naranja")) {
                int i = copy.indexOf("Jugo de naranja");
                copy.set(i,"Jus d'orange");
            }

            else if (item.contains("Orange juice")) {
                int i = copy.indexOf("Orange juice");
                copy.set(i,"Jus d'orange");
            }

            else if (item.contains("Limon")) {
                int i = copy.indexOf("Limon");
                copy.set(i,"Jus de citron");
            }
            else if (item.contains("Lemon juice")) {
                int i = copy.indexOf("Lemon juice");
                copy.set(i,"Jus de citron");
            }

            else if (item.contains("Sal")) {
                int i = copy.indexOf("Sal");
                copy.set(i,"Le sel");
            }
            else if (item.contains("Salt")) {
                int i = copy.indexOf("Salt");
                copy.set(i,"Le sel");
            }

            else if (item.contains("Chile en polvo")) {
                int i = copy.indexOf("Chile en polvo");
                copy.set(i,"Poudre de chili");
            }
            else if (item.contains("Chili powder")) {
                int i = copy.indexOf("Chili powder");
                copy.set(i,"Poudre de chili");
            }

            else if (item.contains("Chile de botella")) {
                int i = copy.indexOf("Chile de botella");
                copy.set(i,"Chili bouteille");
            }
            else if (item.contains("Hot sauce")) {
                int i = copy.indexOf("Hot sauce");
                copy.set(i,"Chili bouteille");
            }

            else if (item.contains("Queso")) {
                int i = copy.indexOf("Queso");
                copy.set(i,"Fromage");
            }
            else if (item.contains("Grated cheese")) {
                int i = copy.indexOf("Grated cheese");
                copy.set(i,"Fromage");
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
                Singleton.getInstance().setIngredientsFrench(selectedItems);
                Intent intent = new Intent(getActivity(), SizeFruitFrenchActivity.class);
                startActivity(intent);

                if(selectedItems.size()!=0){
                    showSelectedItems(selectedItems);

                }else
                    Toast.makeText(getActivity(),R.string.french_ingredients_toast, Toast.LENGTH_SHORT).show();

            }

        });

        return v;
    }

    public void showSelectedItems(ArrayList<String> view){
        String items = " ";

        for(String item:selectedItems){
            items+= item +"\n";
        }
        Toast.makeText(getActivity(),"ingrédients sélectionnés : \n"+items, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}


