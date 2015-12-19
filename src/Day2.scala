import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Day2 extends App {
	
	val day2_input = "inputs/day2/input.txt"
	
  	def day2_1(): Int = {
		var total = 0
		for (order <- Source.fromFile(day2_input).getLines()) {
			var dimensions = order.split("x").grouped(3)
			dimensions.foreach { array =>
				var w = array(0).toInt
				var l = array(1).toInt
				var h = array(2).toInt
				
				var lw = l*w
				var wh = w*h
				var hl = h*l
				
				var surface = (2*lw) + (2*wh) + (2*hl)
				var extra = Math.min(lw, Math.min(wh, hl))
				
				total += surface + extra
			}
		}
		total
	}
	
	def day2_2(): Int = {
		var total = 0
		for (order <- Source.fromFile(day2_input).getLines()) {
			var dimensions = order.split("x").grouped(3)
			dimensions.foreach { array =>
				var dimensionsSorted = array.map { dim => dim.toInt }.sorted
				var w = dimensionsSorted(0)
				var l = dimensionsSorted(1)
				var h = dimensionsSorted(2)
				
				var ribbon = w + w + l + l
				var bow = w * l * h
				total += ribbon + bow
			}
		}
		total
	}
	
	println("Wrapper needed in total: " + day2_1)
	println("Ribbon needed in total: " + day2_2)
}