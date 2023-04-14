package com.example.reproduccionaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt_play;
    SoundPool sp;

    int sonido_de_Reproducion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // clase SoundPool
        //enlazar boton
        bt_play= (Button)findViewById(R.id.bt_play);
        //( numero de pistas,con que vamos a reproducirlas,calidad)
        sp= new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        //instaciar el objeto en interger, el sonido( aqui,donde esta, prioridad)
        sonido_de_Reproducion=sp.load(this,R.raw.sound_short,1);

    }
    // metodo soundpool
    public void AudioSoundPool(View view){
        //( archivo,volumen drecho e izquierod, prioridad, se se va a repetir(-1, nunca, 0 no pero si, 1 si), ratio
        sp.play(sonido_de_Reproducion,1,1,1,0,1);
    }
    //metodo media player
    public void AudioMediaPlayer(View view){
        MediaPlayer mp= MediaPlayer.create(this,R.raw.sound_long);
        mp.start();
    }
}