package Interrupted

fun main(args: Array<String>) {

    val t = Thread (
        Runnable {
            try {
                var i = 0
                while (i < 5){
                    println(++i)
                    Thread.sleep(200)
                }
            } catch (e: InterruptedException) {
                println(e)
            }
        }
    )

    t.start()

    Thread.sleep(100)
    t.interrupt()

}