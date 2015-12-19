import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Day3 extends App {
	
	val day3_input = "days/day3/input.txt"
	
  	def day3_1(): Int = {
		var santasRoute = ""
		for (line <- Source.fromFile(day3_input).getLines()) {
			santasRoute += line
		}
		getGiftCount(List(santasRoute))
	}
	
	def day3_2(): Int = {
		var (santasRoute, robotsRoute) = ("", "")
		for (line <- Source.fromFile(day3_input).getLines()) {
			line.zipWithIndex.foreach { case(char, i) =>
				if (i % 2 == 0) santasRoute += char else robotsRoute += char
			}
		}
		getGiftCount(List(santasRoute, robotsRoute))
	}
	
	private def getGiftCount(routes: List[String]): Int = {
		var houses: ListBuffer[House] = ListBuffer(new House(0, 0))
		routes.foreach { route =>
			var (x, y) = (0, 0)
			route.foreach { char =>
				char.toString match {
					case ">" => x += 1
					case "<" => x -= 1
					case "^" => y += 1
					case "v" => y -= 1
				}
				var found = false
				for (house <- houses) {
					breakable {
						if (house.x == x && house.y == y) {
							house.gifts += 1
							found = true
							break
						}
					}
				}
				if (!found) {
					houses += new House(x, y, 1)
				}
			}
		}
		houses.map { house => house.gifts >= 1 }.size
	}
	
	println("Total of houses: " + day3_1)
	println("Total of houses: " + day3_2)
}