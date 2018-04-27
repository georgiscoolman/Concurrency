package locks

fun main(args: Array<String>){
    val a = SafeSync("a")
    val b = SafeSync("b")

    Thread(Runnable {
        a.takeLock(b)
    }, "t1").start()

    Thread(Runnable {
        b.takeLock(a)
    }, "t2").start()
}