package join

    fun main(args: Array<String>){

        val t = Thread(Runnable {

            var i = 0

            while (i < 5) {
                System.out.println(++i)
                Thread.sleep(100)
            }

        }, "newThread")

        t.start()
        t.join()

        System.out.println("Main thread ${Thread.currentThread()} start execution")

    }

