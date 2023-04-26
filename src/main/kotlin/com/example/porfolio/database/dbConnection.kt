package db
import java.sql.*
import java.util.Properties

class Database {
    internal var conn: Connection? = null
    internal var username = "root"
    internal var password = ""

    fun connect() {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)

        try {
            val url = "jdbc:mysql://localhost:3306/dbahsen"
            val connection = DriverManager.getConnection(url, connectionProps)
            conn = connection
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun auth(username: String, password: String) : ResultSet? {
        connect()
        var result = false
        val sql = "SELECT * FROM auth WHERE username = ? AND password = ?"
        val stmt = conn?.prepareStatement(sql)
        stmt?.setString(1, username)
        stmt?.setString(2, password)
        return stmt?.executeQuery()
    }

    fun getUserInfo(username: String): ResultSet? {
        connect()
        val sql = "SELECT * FROM auth WHERE username = ?"
        val stmt = conn?.prepareStatement(sql)
        stmt?.setString(1, username)
        return stmt?.executeQuery()
    }
}

