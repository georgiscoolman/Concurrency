package guardedBlocks

import java.util.Random



class Consumer(private val storage: Storage): Runnable{

    override fun run() {
        val random = Random()
        var message = storage.take()
        while (message != "") {
            //println("MESSAGE RECEIVED: $message")
            try {
                val randomMilliseconds = random.nextInt(4000).toLong()
                Thread.sleep(randomMilliseconds)
            } catch (e: InterruptedException) {}

            message = storage.take()
        }
    }
}