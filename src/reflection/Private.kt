package reflection

fun main(args: Array<String>){
    val priv = PrivateFieldClass("No one will see it!")

    val privateClass = priv::class.java
    val fields = privateClass.fields

    fields.forEach {
        println("Field ${it.name} ${it.get(priv)}")
    }

    val privField = privateClass.getDeclaredField("priv")
    privField.trySetAccessible()
    println("Field priv ${privField.get(priv)}")
}