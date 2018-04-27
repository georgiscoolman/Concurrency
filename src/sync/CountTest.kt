package sync

fun main(args: Array<String>) {
    val counter = SyncCounter()

    val inc = Thread(
            Runnable {
                counter.increase()
            },
            "inc")

    val dec = Thread(
            Runnable {
                counter.decrease()
            },
            "dec")

    inc.start()
    dec.start()
}

