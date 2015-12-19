import scala.io.Source
import java.security.MessageDigest

object Day4 extends App {

	val day4_input = "days/day4/input.txt"

	def day4(prefix: String): String = {
		var decimal = ""
		for (line <- Source.fromFile(day4_input).getLines()) {
			var i = 0
			var found = false
			do {
				decimal = line + i
				if (md5(decimal).startsWith(prefix)) {
					decimal = i.toString
					found = true
				}
				i += 1
			} while(!found)
		}
		decimal
	}

	private def md5(s: String): String = {
		MessageDigest.getInstance("MD5").digest(s.getBytes()).map(0xFF & _).map { "%02x".format(_) }.foldLeft(""){_ + _}
	}

	println("hash1: " + day4("00000"))
	println("hash2: " + day4("000000"))
}