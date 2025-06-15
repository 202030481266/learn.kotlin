package exceptions

// error function 通常是用来打印一些未定义的不合法行为或者状态

class User(val name: String, val role: String)

fun processUserRole(user: User) {
    when (user.role) {
        "admin" -> println("${user.name} is admin")
        "editor" -> println("${user.name} is editor")
        "developer" -> println("${user.name} is developer")
        else -> error("Undefined role : ${user.role}")
    }
}

fun main() {
    processUserRole(User("alice", "admin"))
    processUserRole(User("bob", "viewer"))
}