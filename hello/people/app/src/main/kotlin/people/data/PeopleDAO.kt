package people.data
import people.model.Person
import java.sql.SQLException


class PeopleDAO {
    private val dbConn = DBConn()
    
    
    @Throw(SQLException::class)
    fun syncPeople(people: ArrayList<Person>) {
        for (p in people) {
            this.dbConn.insert(p.name,p.age,p.height,p.gender)
        }
    }
    @Throw(SQLException::class)
    fun getAllPeople(): ArrayList<Person> {
        val people = ArrayList<Person>()
        for(ds in dbConn.fetchALL()) {
            val person = Person(
                ds.v1,
                ds.v2,
                ds.v3,
                ds.v4,
                ds.v5,
                ds.v6,
            )
            people.add(person)
        }
        return people
    }
}