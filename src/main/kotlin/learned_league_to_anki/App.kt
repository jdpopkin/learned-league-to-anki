/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package learned_league_to_anki

import org.jsoup.Jsoup

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

fun main(args: Array<String>) {
    // Built in
//    println(App().greeting)

    // From https://www.kotlintips.com/scraping-the-web-using-kotlin/ - JSoup example
//    val url = "https://news.ycombinator.com"
//    val doc = Jsoup.connect(url).get()
//
//    val title = doc.title()
//    val links = doc.select("a[href]")
//
//    // Display title
//    println(title)
//
//    // Display all links
//    links.forEach { link ->
//        println(link.attr("href"))
//    }

    var url = if (args.size > 0) args[0] else null
    var outputFile = if (args.size > 1) args[1] else null

    // Disable these once the app works!
    url = "https://learnedleague.com/oneday.php?texasrevolution"
    outputFile = "/tmp/output"

    val doc = Jsoup.connect(url).get()

    // Proof of concept: print the question and answer for all 12 1D questions.
    // Note that this behavior is all 1D-specific.
    for (i in 1..12) {
        // The div that has the questions and answers in it.
        val questionWrapper = doc.select("div:has(div > div > #Q${i})")
        val question = questionWrapper.select("p")[i - 1]
        val answer = questionWrapper.select("#Q${i}ANS")
        println(question.text())
        println(answer.text())
    }
}
