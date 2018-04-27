package guardedBlocks

import java.util.*

class Producer(private val storage: Storage): Runnable {

    override fun run() {
        val messages = arrayListOf(
                "Ura",
                "Sergey",
                "Den",
                "Zhenya"
        )

        val random = Random()

        messages.forEach {
            storage.put(it)
            try {
                val randomMilliseconds = random.nextInt(2000).toLong()
                Thread.sleep(randomMilliseconds)
            }catch (ex: InterruptedException){}
        }
        storage.put("")
    }
}