package com.prueba.lgramir.Gazpchos;

import java.util.ArrayList;

public class Singleton {

    private String mChoice;

    private String mSize;

    private String mPrice;

    private String mSmallGazpacho;
    private String mMediumGazpacho;
    private String mBigGazpacho;

    private String mSmallFruit;
    private String mMediumFruit;
    private String mBigFruit;

    private static Singleton mInstance = null;

    private String mAnswerTakaway;

    private ArrayList<String> mIngredients;

    private ArrayList<String> mFruitIngredients;
    private ArrayList<String> mGazpachoIngredients;

    public static Singleton getInstance() {
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    private Singleton() {
    }

    public String getChoice() {
        return mChoice;
    }

    public void setChoice(String choice) {
        mChoice = choice;
    }

    /*****************************************************/

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    /******************************************************/

    public String getSize() {
        return mSize;
    }

    public void setSize(String size) {
        mSize = size;
    }

    /*******************************************************/
    public String getSmallFruit() {
        return mSmallFruit;
    }

    public String getMediumFruit() {
        return mMediumFruit;
    }

    public String getBigFruit() {
        return mBigFruit;
    }


    public void setBigFruit(String bigFruit) {
        mBigFruit = bigFruit;
    }

    public void setSmallFruit(String smallFruit) { mSmallFruit = smallFruit; }

    public void setMediumFruit(String mediumFruit) {
        mMediumFruit = mediumFruit;
    }

    /*******************************************************/

    public String getSmallGazpacho() {
        return mSmallGazpacho;
    }

    public String getMediumGazpacho() {
        return mMediumGazpacho;
    }

    public String getBigGazpacho() {
        return mBigGazpacho;
    }


    public void setSmallGazpacho(String smallGazpacho) {
        mSmallGazpacho = smallGazpacho;
    }

    public void setMediumGazpacho(String mediumGazpacho) {
        mMediumGazpacho = mediumGazpacho;
    }

    public void setBigGazpacho(String bigGazpacho) {
        mBigGazpacho = bigGazpacho;
    }


    /*******************************************************/

    public String getAnswerTakaway() {
        return mAnswerTakaway;
    }

    public void setAnswerTakaway(String answerTakaway) {
        mAnswerTakaway = answerTakaway;
    }


    /*******************************************************/

    public ArrayList<String> getIngredients() {return mIngredients;}

    public void setIngredients(ArrayList<String> ingredients) {
        mIngredients = ingredients;
    }


    public ArrayList<String> getFruitIngredients() {
        return mFruitIngredients;
    }

    public void setFruitIngredients(ArrayList<String> ingredients2) {
        mFruitIngredients = ingredients2;
    }

    public ArrayList<String> getGazpachoIngredients() {
        return mGazpachoIngredients;
    }

    public void setGazpachoIngredients(ArrayList<String> gazpachoIngredients) {
        mGazpachoIngredients = gazpachoIngredients;
    }

}
