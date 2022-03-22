package people.data
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import java.sql.ResultSet


data class DataSet<A,B,C,D,E,F> {
    val v1:A,
    val v2:B,
    val v3:C,
    val v4:D,
    val v5:E,
    val v6:F,
}








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
    p_gender TEXT NOT NULL,
    p_tstamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
        """)
    }


    private fun close() {
        if(this.conn != null) {
            this.conn?.close()
        }
    }

    fun insert(name: String, age: Int, height: Float, gender: String) {
        this.open()
        val query = """ INSERT INTO people (p_name, p_age, p_height, p_gender) 
        VALUES (?, ?, ?, ?);        
        """
        val statment = this.conn!!.preparedStatement(query)
        statment.setString(1,name)
        statment.setInt(1,age)
        statment.setFloat(2,height)
        statment.setString(3,gender)
        statment.executeUpdate()
        this.close()
    }

    @Throw(SQLException::class)
    fun fetchALL = sequence {
        val query = "SELECT * FROM people"
        open()
        val statement = conn!!.createStatement()
        val retultSet = statement.executeQuery(query)
        while(retultSet.next()) {
            val id = retultSet.getInt("p_id")
            val name = retultSet.getString("p_name")
            val age = retultSet.getInt("p_age")
            val height = retultSet.getFloat("p_height")
            val gender = retultSet.getString("p_gender")
            val ts = retultSet.getString("p_tstamp")
            val ds = DataSet<Int,String,Int,Float,String,String>(
                id, name, age, height, gender, ts
            )
            yield ds
        }
        close()
    }
}