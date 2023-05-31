import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun angka(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}

fun main() = runBlocking{
  angka().collect{
      value -> println(value)
  }
}




//fun main() = runBlocking {
//    launch {
//        delay(1000L)
//        println("Asyn 1")
//    }
//    println("Asyn 2")
//}