package com.example.mochi_feel.ui.screen.music

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Music

class MusicViewModel : ViewModel() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentMusic: Music? = null

    private val privateMusicList = mutableListOf(
        Music("Mochi Memory", "Mochi Feel", R.raw.matcha_mochi_cute),
        Music("Rainy Jazz", "Mochi Feel", R.raw.rainy_jazz),
        Music("Full Focus", "Mochi Feel", R.raw.improve_focus),
        Music("Zen Harmony", "Mochi Feel", R.raw.zen_harmony),
    )

    fun getMusicList(): MutableList<Music> {
        return privateMusicList
    }
    fun initializeMediaPlayer(context: Context, music: Music) {
        mediaPlayer?.stop()
        mediaPlayer?.release() // Release previous MediaPlayer instance if any
        mediaPlayer = null

        mediaPlayer = MediaPlayer.create(context, music.song_path)
        currentMusic = music
    }

    fun getCurrentMusic(): Music? {
        return currentMusic
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

    fun isPlaying(): Boolean {
        return mediaPlayer?.isPlaying == true // returns true if the mediaPlayer is currently playing
    }

    override fun onCleared() {
        super.onCleared()
        stopMusic()
    }
}
