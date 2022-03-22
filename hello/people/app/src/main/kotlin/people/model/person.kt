package people.model 

data class Person (
    val name: String,
    val age: Int,
    val height: Float,
    val gender: String,
) {
    var id: Int? = null
    var timestamp: String = ""
    constructor(
        id:Int,name: String, age: Int, height: Float,gender:String,timestamp: String
    ) : this(name, age, height, gender){
        this.id = id 
        this.timestamp = timestamp
    }
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