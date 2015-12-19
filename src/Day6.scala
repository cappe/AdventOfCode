//import scala.io.Source
//import scala.collection.mutable.ListBuffer
//import scala.util.matching.Regex
//import scala.reflect._
//import scala.reflect.runtime.universe._
//
//object Day6 extends App {
// 
//	val day6_input = "inputs/day6/input.txt"
//	
//	def day6_first() = {
//		var matrix = new Matrix[ClassTag[Lamp1]](1000, 1000)
//		var asd = matrix.init()
//		getLampsLit(asd)
//	}
//	
//	def day6_second() = {
////		var matrix = Matrix(1000, 1000)
////		getLampsLit(matrix)
//	}
//	
//	private def getLampsLit[T <: Lamp](matrix: Array[Array[T]]) = {
//		for (instruction <- Source.fromFile(day6_input).getLines()) {
//			val verb = "toggle|turn on|turn off".r.findFirstIn(instruction)
//			val coordinates = "\\d+".r.findAllIn(instruction).map { _.toInt }.toList
//			val (startingX, startingY, endingX, endingY) = (coordinates(0), coordinates(1), coordinates(2), coordinates(3))
//			for(y <- startingY to endingY; x <- startingX to endingX) {
//				verb.foreach { _ match {
//					case "toggle" => matrix(x)(y).toggle()
//					case "turn on" => matrix(x)(y).turnOn()
//					case _ => matrix(x)(y).turnOff()
//				}}
//			}
//		}
//		var lamps = matrix.foldLeft(0)((count: Int, nextEl: Array[T]) => count + nextEl.filter { _.isLit }.size )
//		println("Lamps lit: " + lamps)
//	}
//	day6_first
//}
//
//class Matrix(x: Int, y: Int) {
//	def init[T]()(implicit tag: TypeTag[T]) = {
//		var matrix = Array.ofDim[tag](x, y)
//		for(col <- 0 until y; row <- 0 until x) {
//			matrix(row)(col) = new Lamp1()
//		}
////		matrix
//	}
//}
//
//object Matrix {
//	def apply(x: Int, y: Int) = {
//		var matrix = new Matrix(x, y)
//		matrix.init()
//	}
//}
//
//abstract class Lamp {
//	def toggle()
//	
//	def turnOn()
//	
//	def turnOff()
//}
//
//class Lamp1(var isLit: Boolean = false) extends Lamp {
//	def toggle() = {
//		if (this.isLit) this.turnOff() else this.turnOn()
//	}
//	
//	def turnOn = {
//		this.isLit = true
//	}
//	
//	def turnOff = {
//		this.isLit = false
//	}
//}
//
//class Lamp2(var brightness: Int = 0) extends Lamp {
//	def toggle() = {
//		brightness += 2
//	}
//	
//	def turnOn() = {
//		this.brightness += 1
//	}
//	
//	def turnOff() = {
//		this.brightness -= 1
//	}
//}
//
//
