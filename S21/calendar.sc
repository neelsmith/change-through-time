import edu.holycross.shot.coursecal._
import java.io.PrintWriter



def header(module: Int) : String = {
  s"---\nlayout: page\ntitle: Schedule for section ${module}\nparent: Course schedule\nnav_order: ${2*module}\n---\n\n"
}

def schedule(module: Int) = {
  val pg = s"ghpages/schedule/part${module}/schedule/index.md"

  val sched = Schedule(s"topics${module}.txt", s"calendar${module}.yaml")
  println("REVISE CAL")
  println(sched.markdownCalendar)
  val lines = sched.markdownCalendar.split("\n").toVector
  val md = header(module) + lines.slice(4, lines.size).mkString("\n") + "\n\n"

  new PrintWriter(pg) { write(md); close }
  println("Schedule written to " + pg)
}


println("\nWrite schedule for part 1:")
println("\n\tschedule(MODULE_NUMBER)")
println("\nwhere MODULE_NUMBER is 1,2 or 3")
