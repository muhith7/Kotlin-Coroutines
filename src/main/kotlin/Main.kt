import kotlinx.coroutines.*

fun main() = runBlocking {
//    launch {
//        delay(10000L)
//        println("Daqna")
//    }
//    daqna()
//    println("Hebat")
//    daqna2()
//    println("done")
//    val job = launch {
//        delay(1000L)
//        println("World")
//    }
//    println("Hello")
//    job.join()
//    repeat(5_000) { // launch a lot of coroutines
//        launch {
//            delay(5000L)
//            print(".")
//        }
//    }

    launch(Dispatchers.IO) {
        delay(1000L)
        println("I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        delay(1000L)
        println("I'm working in thread ${Thread.currentThread().name}")
    }

    daqqna()

    val a = async<Int>{
        delay(1000L)
        6
    }

    println(a.await())

}


 fun daqqna () {
var name:String? = "null"
     // ?. null safety operator
        // ?: elvis operator
     // !! assertion
         cetak(name?.length?:1)
     cetak(name!!.length)


}

fun cetak(value:Int){
    println(value)
}

suspend fun daqna(){
    delay(1000L)
    println("Daqna Hebat")
}

suspend fun daqna2() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hellllo")
}