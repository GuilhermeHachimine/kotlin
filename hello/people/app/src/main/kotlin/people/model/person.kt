package people.model 

data class Person (
    val name: String,
    val age: Int,
    val height: Float,
    val gender: String,
) {
    override fun toString(): String {
        return  (
            """ 
            ${this.name} 
            ${this.age} 
            ${this.height} 
            ${this.gender}
            """
        )
    }
}