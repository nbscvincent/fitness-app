package com.nbscollege.fitnessapp.model

class HomeScreen {
    fun homescreen() {
        // Create the main layout, a vertical LinearLayout
        val mainLayout = LinearLayout(this)
        mainLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        mainLayout.orientation = LinearLayout.VERTICAL

        // Create the header TextView
        val header = TextView(this)
        header.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        header.text = "Fitness Homework"
        header.gravity = Gravity.CENTER
        header.textSize = 24f
        mainLayout.addView(header)

        // Create the footer (horizontal LinearLayout)
        val footer = LinearLayout(this)
        footer.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        footer.orientation = LinearLayout.HORIZONTAL

        // Create clickable buttons
        val trainingButton = Button(this)
        trainingButton.layoutParams = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        trainingButton.text = "Training"
        footer.addView(trainingButton)

        val reportButton = Button(this)
        reportButton.layoutParams = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        reportButton.text = "Report"
        footer.addView(reportButton)

        val settingsButton = Button(this)
        settingsButton.layoutParams = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        settingsButton.text = "Settings"
        footer.addView(settingsButton)

        // Add the header and footer to the main layout
        mainLayout.addView(footer)

        setContentView(mainLayout)
    }

    private fun setContentView(mainLayout: HomeScreen.LinearLayout) {

    }

    class TextView(homeScreen: HomeScreen) {

        var textSize: Float = 0.0f
        lateinit var gravity: Any
        lateinit var text: String
        lateinit var layoutParams: HomeScreen.LinearLayout.LayoutParams
    }

    class Button(homeScreen: HomeScreen) {

        lateinit var text: String
        lateinit var layoutParams: HomeScreen.LinearLayout.LayoutParams
    }

    class LinearLayout(homeScreen: HomeScreen) {
        fun addView(reportButton: Any) {

        }

        class LayoutParams(matchParent: Any, matchParent1: Any) {
            companion object {
                val WRAP_CONTENT: Any = TODO()
                val MATCH_PARENT: Any
            }

        }

        lateinit var orientation: Any
        lateinit var layoutParams: Any

        companion object {
            val VERTICAL: Any = TODO()
            val HORIZONTAL: Any
        }
    }
}

class Gravity {
    companion object {
        val CENTER: Any = TODO()
    }

}
