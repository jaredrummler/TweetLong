package tweetlong

import kotlin.test.Test

const val LONG_TWEET =
    "Imagine you were raised on a certain brand of vitamins. You, your whole family, and most of your friends take these vitamins daily, and you are encouraged to tell everyone about them. You are told all the time, and fully believe, they are the only vitamins that actually work, and the only way to be healthy and happy. The company that makes the vitamins keeps a lot of the ingredients secret, but it doesn’t bother you because you know they are good. Even though you feel sick a lot, you know the vitamins are making you healthy. You can’t understand why some of your friends stop taking the vitamins or refuse to take them in the first place. Why would they refuse something that is good?\n" +
            "Then, one day you find out that the secret ingredients in the vitamins are poisonous. Some people have even died from taking the vitamins. The vitamin company doesn’t address this danger, and still continues to market the vitamins as safe and the only way to be truly healthy and make billions of dollars from all their customers taking the vitamins. You are horrified. You don’t want to believe it. For a while you keep taking the vitamins, but eventually you realize they are making you sick, and you can’t make yourself take them anymore. But when your family and friends find out you stopped taking the vitamins, they try desperately to convince you to take them again.\n" +
            "“They are good for you, they are the only way to be healthy, they make you happy!” they say.\n" +
            "Your parents cry and worry you will die without the vitamins. Even after you tell them you are feelings better than you ever have when you were taking the vitamins, they don’t believe you. You try to tell your friends and family about the lies and the poisonous ingredients, but they won’t listen. Even after the company posts their ingredients in an obscure page on their website, they don’t announce it to their customers, and they claim that the ingredients aren’t poison at all and continue to market the vitamins the same way as before.\n" +
            "“How can you not remember how good you felt when you were taking the vitamins?”\n" +
            "Any time you bring up the poisonous ingredients, they get angry or defensive. They tell you that you don’t understand the vitamins or how they work. They remind you about the good ingredients in the vitamins, and how the good outweighs the bad. They accuse you of not taking the vitamins as regularly as you should have. They tell you that you are being deceived by lies meant to bring down the vitamin company. They tell you about friends who stopped taking the vitamins for years, and then finally started taking them again, and how much better their lives are.\n" +
            "Eventually, you don’t even bring up the poison anymore, because they won’t listen.\n" +
            "When you have a baby, your family keeps telling you to give them the vitamins. When your parents babysit for you, you find out they are feeding your baby the vitamins. Everyone gives you vitamins as gifts and tells you again and again how good they are, and that you are depriving. Your baby of what they know is the only way to be healthy and happy. Even though you know the vitamins are poison, you still feel guilty sometimes for not taking them or giving them to your baby.\n" +
            "Life goes on, but anything that goes wrong in your life is attributed by your family to you not taking the vitamins. They continue to plead with you to take the vitamins again. No matter what you accomplish, no matter how healthy you are, or happy, or successful, it is never enough for them because you aren’t taking the vitamins."

const val LONG_SENTENCE =
    "On offering to help the blind man, the man who then stole his car, had not, at that precise moment, had any evil intention, quite the contrary, what he did was nothing more than obey those feelings of generosity and altruism which, as everyone knows, are the two best traits of human nature and to be found in much more hardened criminals than this one, a simple car-thief without any hope of advancing in his profession, exploited by the real owners of this enterprise, for it is they who take advantage of the needs of the poor."

class TweetLongTests {


    @Test
    fun `should split sentence`() {
        SentenceTrimmer(LONG_SENTENCE, 40).split().forEach { println(it) }
    }

    @Test
    fun `should split long tweet`() {
        val tweets = TweetSplitter(LONG_TWEET).split()
        tweets.forEach {
            println("-----")
            println(it)
        }
    }
}