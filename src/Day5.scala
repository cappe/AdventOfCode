import scala.io.Source
import scala.util.control.Breaks._

object Day5 extends App {

	val day5_input = "inputs/day5/input.txt"

	def day5_1(): Int = {
		var count = 0
		for (line <- Source.fromFile(day5_input).getLines()) {
			if (isNiceString_1(line)) count += 1
		}
		count
	}

	def day5_2() = {
		var count = 0
		for (line <- Source.fromFile(day5_input).getLines()) {
			if (isNiceString_2(line)) {
				println(line)
				count += 1
			}

		}
		count
	}

	private def isNiceString_1(string: String): Boolean = {
		val vowels = "aeiou"
		val invalids = List("ab", "cd", "pq", "xy")
		var valid = false

		var notInvalids = invalids.forall { invalid => !string.contains(invalid) }

		if (notInvalids) {
			var doubleLetter = {
				var found = false
				for (i <- 0 until string.size - 1) {
					if (string.charAt(i) == string.charAt(i + 1)) found = true
				}
				found
			}

			if (doubleLetter) {
				var vowelCount = 0
				for (char <- string; vowel <- vowels) {
					if (char == vowel) vowelCount += 1
				}

				if (vowelCount >= 3) {
					valid = true
				}
			}
		}
		valid
	}

	private def isNiceString_2(string: String): Boolean = {
		var pairOfLetters = false
		var repeatingLetter = false

		var size = string.size
		breakable {
			for (i <- 0 until string.size - 1) {
				var pair = string.charAt(i).toString + string.charAt(i + 1).toString
				if (string.substring(i + 2).contains(pair)) {
					pairOfLetters = true
					break
				}
			}
		}
		if (pairOfLetters) {
			breakable {
				for (i <- 0 until string.size - 2) {
					var pair = string.charAt(i).toString + string.charAt(i + 2).toString
					if (pair.head.toString == pair.tail) {
						repeatingLetter = true
						break
					}
				}
			}
		}
		pairOfLetters && repeatingLetter
	}

	println("Nice strings: " + day5_1)
	println("Nice strings: " + day5_2)

}