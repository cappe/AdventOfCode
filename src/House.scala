class House(x: Int, y: Int, var gifts: Int = 0) extends Cell(x, y) {
  override def toString() = {
		"x: " + this.x + ", y: " + y + ", gifts: " + gifts
	}
}