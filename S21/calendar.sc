import edu.holycross.shot.coursecal._
import java.io.PrintWriter



def header(module: Int) : String = {
  s"---\nlayout: page\ntitle: Schedule for section ${module}\nparent: Course schedule\n---\n\n"
}

def schedule(module: Int) = {
  val pg = s"ghpages/schedule/part${module}/index.md"
  val sched = Schedule(s"topics${module}.txt", s"calendar${module}.yaml")
  val lines = sched.markdownCalendar.split("\n").toVector
  val md = header(module) + lines.slice(4, lines.size - 1).mkString("\n")

  new PrintWriter(pg) { write(md); close }
  println("Schedule written to " + pg)
}


println("\nWrite schedule for part 1:")
println("\n\tschedule(MODULE_NUMBER)")
println("\nwhere MODULE_NUMBER is 1,2 or 3")
