package com.example.mochi_feel.ui.screen.music

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Music

class MusicViewModel : ViewModel() {

    companion object {
        var mediaPlayer: MediaPlayer? = null
    }

    private var currentMusic: Music? = null

    private val privateMusicList = mutableListOf(
        Music("Mochi Memory", "Mochi Feel", R.raw.matcha_mochi_cute),
        Music("Rainy Jazz", "Mochi Feel", R.raw.rainy_jazz),
        Music("Full Focus", "Mochi Feel", R.raw.improve_focus),
        Music("Zen Harmony", "Mochi Feel", R.raw.zen_harmony),
        Music("Ghost Duet", "Mochi Feel", R.raw.ghost_duet),
        Music("Feels Like Autumn", "Mochi Feel", R.raw.feels_like_autumn),
    )

    private var _selectedMusic = mutableStateOf<Music?>(null)
    var selectedMusic: State<Music?> = _selectedMusic

    var PlayOrPause: Boolean = true

    fun getMusicList(): MutableList<Music> {
        return privateMusicList
    }

    fun initializeMediaPlayer(context: Context, music: Music) {
        mediaPlayer?.stop()
        mediaPlayer?.release()
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
        return mediaPlayer?.isPlaying == true
    }

    fun playPauseToggle(music: Music, context: Context) {
        if (isPlaying() && music == getCurrentMusic()) {
            Log.d("playorpause", "true")

            pauseMusic()
            PlayOrPause = true // true = play button when paused
        } else {
            Log.d("playorpause", "false")

            initializeMediaPlayer(context, music)
            startMusic()
            _selectedMusic.value = music
            PlayOrPause = false
        }
    }

    fun returnPlayOrPauseButton(): Int {
        if (PlayOrPause) {
            return R.drawable.play_button
        } else {
            return R.drawable.pause_button
        }
    }

//    override fun onCleared() {
//        super.onCleared()
//        stopMusic()
//    }
}
