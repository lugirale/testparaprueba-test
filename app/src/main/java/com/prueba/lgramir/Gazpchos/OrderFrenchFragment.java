package com.prueba.lgramir.Gazpchos;

import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zj.usbsdk.UsbController;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class OrderFrenchFragment extends Fragment {

    private Button mHomeButton;
    private Button mOrderButton = null;

    private TextView mDetails;

    private Calendar mCalendar;

    private String   mChoice;
    private String   mSize;
    private String   mTakeaway;
    private String   mPrice;
    private ArrayList<String> mIngredients= null;

    private ArrayList<String> mIngredientsSpanish= null;

    private TextView mChoiceView;
    private TextView mIngredientsView= null;

    private int[][] u_infor;
    UsbController usbCtrl = null;
    UsbDevice dev = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order_french, parent, false);

        usbCtrl = new UsbController(getActivity(),mHandler);
        u_infor = new int[6][2];
        u_infor[0][0] = 0x1CBE;
        u_infor[0][1] = 0x0003;
        u_infor[1][0] = 0x1CB0;
        u_infor[1][1] = 0x0003;
        u_infor[2][0] = 0x0483;
        u_infor[2][1] = 0x5740;
        u_infor[3][0] = 0x0493;
        u_infor[3][1] = 0x8760;
        u_infor[4][0] = 0x0416;
        u_infor[4][1] = 0x5011;
        u_infor[5][0] = 0x0416;
        u_infor[5][1] = 0xAABB;

        /**********************************************************************************/

        mDetails = (TextView) v.findViewById(R.id.details_label_view);

        /***********************************************************************************
         DATE
         ***********************************************************************************/

        mCalendar = Calendar.getInstance();
        final Date date = mCalendar.getTime();
        Locale locFR = new Locale("fr","FS");
        DateFormat dfFR = DateFormat.getDateInstance(DateFormat.FULL, locFR);

        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getDefault());
        final String gmtTime = df.format(new Date());
        final String gmtTime2 =dfFR.format(date);

        /***********************************************************************************
         CHOICE
         ***********************************************************************************/

        mChoiceView = (TextView) v.findViewById(R.id.choice_view);
        mChoice= Singleton.getInstance().getChoice();
        mSize= Singleton.getInstance().getSize();
        mTakeaway= Singleton.getInstance().getAnswerTakaway();

        mChoiceView.setText("Date: "+dfFR.format(date)+" " +gmtTime +"\n\n"+mChoice +", "+ mSize +", "+ mTakeaway);


        /***********************************************************************************
         INGREDIENTS
         ***********************************************************************************/

        mIngredientsView = (TextView) v.findViewById(R.id.ingredients_view);
        mIngredients = Singleton.getInstance().getIngredientsFrench();
        mPrice= Singleton.getInstance().getPrice();

        StringBuilder builder = new StringBuilder();
        for (String s: mIngredients) {
            builder.append(s+"\n");
        }
        if(mIngredients.size() == 0){
            mIngredientsView.setText("Aucun des ingrédients sélectionnés!?. appuyez sur Entrée pour sélectionner les ingrédients");
        }else
            mIngredientsView.setText("ingrédients: \n" + builder.toString()+"\n"+"Prix total: $ "+mPrice  +" pesos mexicains 00/100 M.N)");


        /***********************************************************************************/

        mHomeButton = (Button) v.findViewById(R.id.home_button);
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LanguageActivity.class);
                startActivity(intent);
            }
        });


        mOrderButton = (Button) v.findViewById(R.id.order_button);
        mOrderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                byte isHasPaper;
                if( v == mOrderButton ){
                    usbCtrl.close();
                    int  i = 0;
                    for( i = 0 ; i < 6 ; i++ ){
                        dev = usbCtrl.getDev(u_infor[i][0],u_infor[i][1]);
                        if(dev != null)
                            break;
                    }

                    if( dev != null ){
                        if( !(usbCtrl.isHasPermission(dev))){
                            usbCtrl.getPermission(dev);
                        }else{
                            Toast.makeText(getActivity(), getString(R.string.msg_getpermission),
                                    Toast.LENGTH_SHORT).show();
                            //btn_test.setEnabled(true);
                            mOrderButton.setEnabled(false);
                        }
                    }

                    String fecha = "";
                    String fecha2 = "";
                    String producto = "";
                    String producto2 = "";
                    String tamaño = "";
                    String tamaño2 = "";
                    String parallevar = "";
                    String parallevar2 = "";
                    String ingredientes = "";
                    String ingredientes2 = "";
                    String precio = "";
                    String precio2 = "";

                    String lang = getString(R.string.strLang);
                    byte[] cmd = new byte[3];
                    cmd[0] = 0x1b;
                    cmd[1] = 0x21;


                    isHasPaper = usbCtrl.revByte(dev);
                    if( isHasPaper == 0x38 ){
                        Toast.makeText(getActivity(), "la impresora no tiene papel",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if((lang.compareTo("en")) == 0){

                        cmd[2] |= 0x10;
                        usbCtrl.sendByte(cmd, dev);
                        usbCtrl.sendMsg("GAZPACHOS!\n", "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);
                        fecha = "Date: "+ gmtTime2 +" "+gmtTime+"\n" ;
                        usbCtrl.sendMsg(fecha, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);
                        producto = mChoice;
                        usbCtrl.sendMsg(producto, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);
                        tamaño = mSize;
                        usbCtrl.sendMsg(tamaño, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);
                        parallevar = mTakeaway;
                        usbCtrl.sendMsg(parallevar, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);
                        StringBuilder builder = new StringBuilder();
                        for (String s: mIngredients) {
                            builder.append(s+"\n");
                        }
                        if(mIngredients.size() == 0){
                            ingredientes="Aucun des ingrédients sélectionnés!?. appuyez sur Entrée pour sélectionner les ingrédients";
                            usbCtrl.sendMsg(ingredientes, "GBK", dev);

                        }else {
                            ingredientes = "ingrédients: \n\n" + builder.toString();
                            usbCtrl.sendMsg(ingredientes, "GBK", dev);
                        }

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);
                        precio = "Prix total: $ "+mPrice  +" pesos mexicains 00/100 M.N)";
                        usbCtrl.sendMsg(precio, "GBK", dev);

                        cmd[2] |= 0x10;
                        usbCtrl.sendByte(cmd, dev);
                        usbCtrl.sendMsg("------------------------------\n", "GBK", dev);

                        cmd[2] |= 0x10;
                        usbCtrl.sendByte(cmd, dev);
                        usbCtrl.sendMsg("COPIA\n", "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);

                        Locale locES = new Locale("es","ES");
                        DateFormat dfES = DateFormat.getDateInstance(DateFormat.FULL, locES);
                        final String gmtTime2 =dfES.format(date);
                        fecha2 = "Fecha: " + gmtTime2 + " " + gmtTime + "\n";

                        usbCtrl.sendMsg(fecha2, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);

                        producto2 = mChoice.replace("tranche de fruits", "Vaso de fruta");

                        usbCtrl.sendMsg(producto2, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);

                        if(mSize.contains("Petite")){
                            tamaño2 = mSize.replace("Petite", "chico");
                        }else if(mSize.contains("moyenne")){
                            tamaño2 = mSize.replace("moyenne", "mediano");
                        }else if(mSize.contains("grande")){
                            tamaño2 = mSize.replace("grande", "grande");
                        }

                        usbCtrl.sendMsg(tamaño2, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);

                        if(mTakeaway.contains("A emporter")){
                            parallevar2 = mTakeaway.replace("A emporter", "para llevar");
                        }else if(mTakeaway.contains("manger ici")){
                            parallevar2 = mTakeaway.replace("manger ici","para comer aqui");
                        }

                        usbCtrl.sendMsg(parallevar2, "GBK", dev);

                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);


                        ArrayList<String> items = Singleton.getInstance().getIngredientsFrench();
                        ArrayList<String> copy = new ArrayList<String>();
                        copy.addAll(items);

                        for (String item : copy) {

                            if (item.contains("Jicama")) {
                                int a = copy.indexOf("Jicama");
                                copy.set(a, "Jicama");
                            }
                            else if (item.contains("Concombre")) {
                                int b = copy.indexOf("Concombre");
                                copy.set(b,"Pepino");
                            }
                            else if (item.contains("Sandia")) {
                                int c = copy.indexOf("Sandia");
                                copy.set(c,"Sandia");
                            }
                            else if (item.contains("Mango")) {
                                int d = copy.indexOf("Mango");
                                copy.set(d,"Mango");
                            }
                            else if (item.contains("Ananas")) {
                                int e = copy.indexOf("Ananas");
                                copy.set(e,"Piña");
                            }
                            else if (item.contains("La papaye")) {
                                int f = copy.indexOf("La papaye");
                                copy.set(f,"Papaya");
                            }

                            else if (item.contains("Melon")) {
                                int g = copy.indexOf("Melon");
                                copy.set(g,"Melon");
                            }

                            else if (item.contains("Orange")) {
                                int h = copy.indexOf("Orange");
                                copy.set(h,"Naranja");
                            }

                            else if (item.contains("Oponce")) {
                                int j = copy.indexOf("Oponce");
                                copy.set(j,"Tuna");
                            }

                            else if (item.contains("Coco")) {
                                int k = copy.indexOf("Coco");
                                copy.set(k,"Coco");
                            }

                            else if (item.contains("Jus d'orange")) {
                                int l = copy.indexOf("Jus d'orange");
                                copy.set(l,"Jugo de naranja");
                            }

                            else if (item.contains("Jus de citron")) {
                                int m = copy.indexOf("Jus de citron");
                                copy.set(m,"Limon");
                            }

                            else if (item.contains("Le sel")) {
                                int n = copy.indexOf("Le sel");
                                copy.set(n,"Sal");
                            }

                            else if (item.contains("Poudre de chili")) {
                                int o = copy.indexOf("Poudre de chili");
                                copy.set(o,"Chile en polvo");
                            }

                            else if (item.contains("Chili bouteille")) {
                                int p = copy.indexOf("Chili bouteille");
                                copy.set(p,"Chile de botella");
                            }

                            else if (item.contains("Fromage")) {
                                int q = copy.indexOf("Fromage");
                                copy.set(q,"Queso");
                            }
                        }

                        StringBuilder builder2 = new StringBuilder();
                        for (String s: copy) {
                            builder2.append(s+"\n");
                        }
                        if(copy.size() == 0){
                            ingredientes="No seleccionaste ingredientes!? presiona regresar para seleccionar ingredientes";
                            usbCtrl.sendMsg(ingredientes, "GBK", dev);

                        }else {
                            ingredientes = "ingredientes: \n\n" + builder2.toString();
                            usbCtrl.sendMsg(ingredientes, "GBK", dev);
                        }


                        cmd[2] &= 0xEF;
                        usbCtrl.sendByte(cmd, dev);

                        precio2 = "Total a pagar: $ "+mPrice + " pesos 00/100 M.N)";
                        usbCtrl.sendMsg(precio2, "GBK", dev);
                    }

                    cmd[2] |= 0x10;
                    usbCtrl.sendByte(cmd, dev);
                    usbCtrl.sendMsg("-------------------------------\n", "GBK", dev);
                    cmd[2] |= 0x10;
                }

                Intent intent = new Intent(getActivity(), LanguageActivity.class);
                startActivity(intent);
            }


        });

        return v;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        usbCtrl.close();
    }

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UsbController.USB_CONNECTED:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
