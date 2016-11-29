package com.yamankod.crossthread;

import android.content.Context;
import android.os.Message;

/**
 * Created by murat on 29.11.2016.
 */

public class Ornek implements   Runnable {

    private Context context;

    public Ornek(Context c){
        context = c ;
    }


    public void Saydir(){

        for (int i = 1 ; i<=1000 ; i++){

            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /**
             * bilgi göndere thread gönderecegi bilgisi Message nesnesinin
             * obs isimli public degişkeni içerisine yerleştirir
             * ve bu mesahı Handler sendMessage() fonksiyonuyla  Handler 'a gonderir .
             * Gonderilen Handler  Mesajı handleMessage()
             * callback fonksiyonuna parametre olarak gelir ve obj degişkeninden
             * ilgili veri elde edlip diger threadlerde kullanılabilir
             *
             */

            Message msg = new Message();
            msg.obj = "i :"+ i ;

            (( MainActivity) context).getHANDLER().sendMessage(msg);

        }

    }

    @Override
    public void run() {

        Saydir();

    }


}
