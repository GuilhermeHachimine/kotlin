fun main(args: Array<String>) {
    try {
        val a = args[0].toFloat();
        val op = args[1];
        val b =  args[2].toFloat();
        val result = operation(a,op,b);
        println("this is the result ${result}")
    } catch(e:ArrayIndexOutOfBoundsException) {
        println("Err: Falta parâmetros")
    } catch(e:NumberFormatException) {
        println("Err: Formato de número inválido")
    } catch(e: Exception) {
        println(e.message)
    }
}

fun operation(n1:Float,op:String, n2:Float):Float {
    return when (op) {
        "+" -> add(n1,n2)
        "-" -> subtract(n1,n2)
        "x" -> multiply(n1,n2)
        "div" -> divide(n1,n2)
        else  -> {
            throw Exception("Invalid operation");
        }
    }
} 

fun add(a: Float, b: Float): Float {
     return a + b;
}

fun subtract(a: Float, b: Float): Float {
     return a - b;
}

fun multiply(a: Float, b: Float): Float {
    return a * b;
}

fun divide(a: Float, b: Float): Float {
    return a / b;
}