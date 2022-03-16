package people.data
import java.sql.Connection
import java.sql.DriverManager
class DBConn {
    private val conn: Connection? = null
    

    private fun Open() {
        this.conn = DriverManager("jdbc:sqlite:people.db")
    }
    private fun Close() {}

    fun insert(name: String, age: Int, height: Float, gender: String) {

    }
    fun fetchALL = sequence {

    }
}