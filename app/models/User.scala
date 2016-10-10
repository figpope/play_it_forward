package models

import java.time.LocalDate
import play.api.data.Form
import play.api.data.Forms._

case class User(id: Long, firstName: String, lastName: String, mobile: Long, email: String, birthDate: LocalDate)

case class UserFormData(firstName: String, lastName: String, mobile: Long, email: String, birthDate: LocalDate)

object UserForm {

  val form = Form(
    mapping(
      "firstName" -> nonEmptyText,
      "lastName"  -> nonEmptyText,
      "mobile"    -> longNumber,
      "email"     -> email,
      "birthDate" -> localDate
    )(UserFormData.apply)(UserFormData.unapply)
  )
}

object Users {

  var users: Seq[User] = Seq()

  def add(user: User): String = {
    users = users :+ user.copy(id = users.length) // manual id increment
    "User successfully added"
  }
}
