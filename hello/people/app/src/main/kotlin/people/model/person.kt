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
            name: ${this.name} 
            ====================================
            age: ${this.age} 
            height: ${this.height} 
            gender: ${this.gender}
            """
        )
    }
}