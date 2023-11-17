package com.example.mochi_feel.viewmodel.Random

import com.example.mochi_feel.R
import com.example.mochi_feel.model.Topic
import com.example.mochi_feel.model.TopicUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class RandomViewModel {
    private val _uiState = MutableStateFlow(TopicUiState())
    val uiState: StateFlow<TopicUiState> = _uiState.asStateFlow()

    fun newTopic() {
        var newIndex: Int
        do {
            newIndex = Random.nextInt(1, 7)
        } while (newIndex == uiState.value.topicNumber)

        _uiState.update { data ->
            data.copy(topicNumber = newIndex)
        }
    }


    // could've made this in a better and neater way, but whatever my brain can't
    fun getTopic(index: Int = uiState.value.topicNumber): Topic {
        return when (index) {
            1 -> {
                // Topic: The Morning
                val topicName = "The Morning"
                val topicDescription = "Waking up is the most important part of the day!"
                val topicQuestions = "How was your morning? Were you awoken by the sound of your blaring alarm? What did you do first thing in the morning?"
                val imagePath = R.drawable.help_topic_morning
                Topic(topicName, topicDescription, topicQuestions, imagePath)
            }
            2 -> {
                // Topic: Favorite Hobbies
                val topicName = "Hobbies"
                val topicDescription = "Share details about your passions and hobbies!"
                val topicQuestions = "What hobbies bring you joy? How did you discover your favorite hobby? Share a memorable experience related to your hobby."
                val imagePath = R.drawable.help_topic_hobbies
                Topic(topicName, topicDescription, topicQuestions, imagePath)
            }
            3 -> {
                // Topic: Travel Adventures
                val topicName = "Travel Adventures"
                val topicDescription = "Explore and reminisce about your exciting travel experiences!"
                val topicQuestions = "What's the most memorable place you've visited? Share a travel anecdote that left a lasting impression on you."
                val imagePath = R.drawable.help_topic_travel
                Topic(topicName, topicDescription, topicQuestions, imagePath)
            }
            4 -> {
                // Topic: Your Future
                val topicName = "Your Future"
                val topicDescription = "Dream and plan for your future endeavors!"
                val topicQuestions = "Where do you see yourself in the next few years? What goals are you working towards? Share your aspirations for the future."
                val imagePath = R.drawable.help_topic_future
                Topic(topicName, topicDescription, topicQuestions, imagePath)
            }
            5 -> {
                // Topic: Inventing Food
                val topicName = "Inventing Food"
                val topicDescription = "Get creative in the kitchen and share your culinary inventions!"
                val topicQuestions = "If you could invent any food in the world, what would it be? What are your top 3 favorite flavors? How do you think it would taste like when mixed?"
                val imagePath = R.drawable.help_topic_food
                Topic(topicName, topicDescription, topicQuestions, imagePath)
            }
            6 -> {
                // Topic: Ethics
                val topicName = "Moral Philosophy"
                val topicDescription = "Reflect on ethical dilemmas- Have some fun with it!"
                val topicQuestions = "Is it ever okay to lie? Would you keep your best friend's secret no matter how dangerous it is? Look up Moral Dilemma questions for more detailed ones!"
                val imagePath = R.drawable.help_topic_ethics
                Topic(topicName, topicDescription, topicQuestions, imagePath)
            }
            else -> {
                // Default Topic
                val topicName = "Default Topic"
                val topicDescription = "A default topic for general journaling."
                val topicQuestions = "Write freely about whatever comes to mind."
                val imagePath = R.drawable.help_topic_morning
                Topic(topicName, topicDescription, topicQuestions, imagePath)
            }
        }
    }


}