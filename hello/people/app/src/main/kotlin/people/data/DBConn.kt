package people.data
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement


class DBConn {
    private val conn: Connection? = null
    
    @Throw(SQLException::class)
    private fun Open() {
        this.conn = DriverManager("jdbc:sqlite:people.db")
        val statement = this.conn.createStatement()
        statement.setQueryTimeout(30)
        statement.executeUpdate("""
        CREATE TABLE IF NOT EXISTS people (
    p_id INTEGER PRIMARY KEY AUTOINCREMENT,
    p_name TEXT NOT NULL,
    p_age INTEGER NOT NULL,
    p_height REAL NOT NULL,
    p_gender TEXT NOT NULL
);
        """)
    }


    private fun Close() {
        if(this.conn != null) {
            this.conn.close()
        }
    }

    fun insert(name: String, age: Int, height: Float, gender: String) {

    }

    fun fetchALL = sequence {

    }
}