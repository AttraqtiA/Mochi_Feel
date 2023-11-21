package com.example.mochi_feel.ui.screen.music

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import com.example.mochi_feel.R

class MusicViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

    fun initializeMediaPlayer(context: Context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.matcha_mochi_cute)
    }

    fun startMusic() {
        mediaPlayer?.start()
    }

    fun pauseMusic() {
        mediaPlayer?.pause()
    }

    fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onCleared() {
        super.onCleared()
        stopMusic()
    }
}
