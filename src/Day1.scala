import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Day1 extends App {
	
	val day1_input = "inputs/day1/input.txt"
	
	def day1_1(): Int = {
		var floor = 0
		for (line <- Source.fromFile(day1_input).getLines()) {
			line.foreach(char =>
				char.toString match {
					case "(" => floor += 1
					case ")" => floor -= 1
				}
			)
		}
		floor
	}
	
	def day1_2(): Int = {
		var (floor, position) = (0, 0)
		for (line <- Source.fromFile(day1_input).getLines()) {
			line.takeWhile { char => 
				char.toString match {
					case "(" => floor += 1
					case ")" => floor -= 1
				}
				position += 1
				floor != -1
			}
		}
		position
	}
	
	println("floor: " + day1_1)
	println("position: " + day1_2)
}


