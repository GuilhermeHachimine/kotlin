fun main() {
    var a1 :String?
    a1 = rand_t()
    print_especial(a1!!)
}

fun print_especial(n:String) {
    println(n)
}

fun rand_t(): String? {
    if(Math.random()>0.5) {
        return "hello"
    } else {
        return null
    }
}