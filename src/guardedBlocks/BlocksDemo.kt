package guardedBlocks

fun main(args: Array<String>){
    val storage = Storage()
    Thread(Producer(storage), "Producer").start()
    Thread(Consumer(storage), "Consumer").start()
}