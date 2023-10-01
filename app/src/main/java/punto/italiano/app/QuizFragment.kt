package punto.italiano.app

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment


class QuizFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.quiz_fragment, container, false)
        val questions = addDataQuestions()
        val answers = addDataAnswers()
        val options = addDataOptions()
        val images = addArrayPhotos()
        var points = 0
        var titleCounter = 1
        var imageCounter = 1
        var optionsCounter = 2
        var answerCounter = 0
        val restartButton = view.findViewById<Button>(R.id.restartButton)
        val image = view.findViewById<ImageView>(R.id.imageTitle)
        val answerText = view.findViewById<TextView>(R.id.pointsText)
        val title = view.findViewById<TextView>(R.id.questionTitle)
        val option1 = view.findViewById<Button>(R.id.button1)
        val option2 = view.findViewById<Button>(R.id.button2)
        val option3 = view.findViewById<Button>(R.id.button3)
        val nextButton = view.findViewById<Button>(R.id.nextButton)
        title.text = questions[0].toString()
        image.setImageResource(images[0]!!)
        option1.text = options[0].toString()
        option2.text = options[1].toString()
        option3.text = options[2].toString()

        option1.setOnClickListener {
            if (answers[answerCounter].equals(option1.text.toString())) {
                points++
                nextButton.performClick()
            } else {
                nextButton.performClick()
            }
        }
        option2.setOnClickListener {
            if (answers[answerCounter].equals(option2.text.toString())) {
                points++
                nextButton.performClick()
            } else {
                nextButton.performClick()
            }
        }
        option3.setOnClickListener {
            if (answers[answerCounter].equals(option3.text.toString())) {
                points++
                nextButton.performClick()
            } else {
                nextButton.performClick()
            }
        }


        nextButton.setOnClickListener {
            title.text = questions[titleCounter].toString()
            image.setImageResource(images[imageCounter]!!)
            answerText.text = ""
            for (i in options.keys) {
                option1.text = options[optionsCounter + 1]
                option2.text = options[optionsCounter + 2]
                option3.text = options[optionsCounter + 3]
            }
            titleCounter++
            optionsCounter += 3
            answerCounter++
            imageCounter++
            if (titleCounter == 16) {

                option1.isVisible = false
                option2.isVisible = false
                option3.isVisible = false
                title.isVisible = false
                image.isVisible=false
                answerText.text = "Right answers: " + points.toString()
                restartButton.isVisible = true

                restartButton.setOnClickListener {
                    titleCounter = 0
                    imageCounter=0
                    optionsCounter = -1
                    nextButton.performClick()
                    restartButton.isVisible = false
                    option1.isVisible = true
                    option2.isVisible = true
                    option3.isVisible = true
                    title.isVisible = true
                    image.isVisible = true

                }
            }
            if (answerCounter == 15)
                answerCounter = 0

            if (imageCounter == 15)
                imageCounter=0

        }


        return view
    }

    private fun addDataQuestions(): HashMap<Int, String> {
        val questionsArray = HashMap<Int, String>()

        questionsArray[0] = "Who plays in Edmonton Oilers"
        questionsArray[1] = "In what team does Cale Makar play ?"
        questionsArray[2] = "Who plays in Tampa Bay Lightning?"
        questionsArray[3] = "In what team does Alex Ovechkin play?"
        questionsArray[4] = "Who plays in Pittsburgh Penguins"
        questionsArray[5] = "In what team does Nazem Kadri play?"
        questionsArray[6] = "Who plays in Philadelphia Flyers?"
        questionsArray[7] = "In what team does Arber Xhekaj play?"
        questionsArray[8] = "Who plays in Kunlun Red Star ?"
        questionsArray[9] = "In what team does Janne Kuokkanen play?"

        questionsArray[10] = "In what team does Sidney Crosby play?"
        questionsArray[11] = "Who plays in Nashville Predators ?"
        questionsArray[12] = "In what team does Victor Hedman play?"
        questionsArray[13] = "Who plays in  Florida Panthers?"
        questionsArray[14] = "In what team does Igor Shesterkin play?"
        return questionsArray
    }

    private fun addDataAnswers(): HashMap<Int, String> {
        val answersArray = HashMap<Int, String>()

        answersArray[0] = "Connor McDavid"
        answersArray[1] = "Edmonton Oilers"
        answersArray[2] = "Andrei Vasilevskiy"
        answersArray[3] = "Washington Capitals"
        answersArray[4] = "Mark Friedman"
        answersArray[5] = "Calgary Flames"
        answersArray[6] = "Travis Sanheim"
        answersArray[7] = "Montréal Canadiens"
        answersArray[8] = "Tomas Jurco"
        answersArray[9] = "Malmö Redhawks"

        answersArray[10] = "Pittsburgh Penguins"
        answersArray[11] = "Roman Josi"
        answersArray[12] = "Tampa Bay Lightning"
        answersArray[13] = "Aleksander Barkov"
        answersArray[14] = "New York Rangers"
        return answersArray
    }

    private fun addArrayPhotos(): HashMap<Int,Int> {
        val photosArray = HashMap<Int,Int>()
        photosArray[0]=(R.drawable.player1)
        photosArray[1]=(R.drawable.player2)
        photosArray[2]=(R.drawable.player3)
        photosArray[3]=(R.drawable.player4)
        photosArray[4]=(R.drawable.player5)
        photosArray[5]=(R.drawable.player6)
        photosArray[6]=(R.drawable.player7)
        photosArray[7]=(R.drawable.player8)
        photosArray[8]=(R.drawable.player9)
        photosArray[9]=(R.drawable.player10)
        photosArray[10]=(R.drawable.player11)
        photosArray[11]=(R.drawable.player12)
        photosArray[12]=(R.drawable.player13)
        photosArray[13]=(R.drawable.player14)
        photosArray[14]=(R.drawable.player15)

        return photosArray
    }

    private fun addDataOptions(): HashMap<Int, String> {
        val optionsArray = HashMap<Int, String>()

        optionsArray[0] = "Connor McDavid"
        optionsArray[1] = "Auston Matthews"
        optionsArray[2] = "Nathan MacKinnon"

        optionsArray[3] = "Edmonton Oilers"
        optionsArray[4] = "Toronto Maple Leafs"
        optionsArray[5] = "Colorado Avalanche"

        optionsArray[6] = "Alexander Alexeyev"
        optionsArray[7] = "Andrei Vasilevskiy"
        optionsArray[8] = "John Carlson"

        optionsArray[9] = "Washington Capitals"
        optionsArray[10] = "Admiral Vladivostok"
        optionsArray[11] = "Anaheim Ducks"

        optionsArray[12] = "Nick Jensen"
        optionsArray[13] = "Mark Friedman"
        optionsArray[14] = "Rasmus Sandin "

        optionsArray[15] = "Calgary Flames"
        optionsArray[16] = "Kunlun Red Star"
        optionsArray[17] = "Arizona Coyotes"

        optionsArray[18] = "Patrick Kane"
        optionsArray[19] = "Cale Makar"
        optionsArray[20] = "Travis Sanheim"

        optionsArray[21] = "Montréal Canadiens"
        optionsArray[22] = "Chicago Blackhawks"
        optionsArray[23] = "Ottawa Senators"

        optionsArray[24] = "Alexander Ovechkin"
        optionsArray[25] = "Tomas Jurco"
        optionsArray[26] = "Brent Burns"

        optionsArray[27] = "Washington Capitals"
        optionsArray[28] = "Vancouver Canucks"
        optionsArray[29] = "Malmö Redhawks"

        optionsArray[30] = "New York Rangers"
        optionsArray[31] = "Pittsburgh Penguins"
        optionsArray[32] = "Colorado Avalanche"

        optionsArray[33] = "Roman Josi"
        optionsArray[34] = "Artemi Panarin"
        optionsArray[35] = "Alex Ovechkin"

        optionsArray[36] = "Columbus Blue Jackets"
        optionsArray[37] = "Anaheim Ducks"
        optionsArray[38] = "Tampa Bay Lightning"

        optionsArray[39] = "Juuse Saros"
        optionsArray[40] = "Charlie McAvoy"
        optionsArray[41] = "Aleksander Barkov"

        optionsArray[42] = "New York Rangers"
        optionsArray[43] = "Los Angeles Kings"
        optionsArray[44] = "Winnipeg Jets"

        return optionsArray
    }
}