import edu.holycross.shot.coursecal._
import java.io.PrintWriter



def schedule(module: Int) = {
  val pg = s"ghpages/schedule/part${module}/index.md"
  val sched = Schedule(s"topics${module}.txt", s"calendar${module}.yaml")
  val md = sched.markdownCalendar
  new PrintWriter(pg) { write(md); close }
  println("Schedule written to " + pg)
}


println("\nWrite schedule for part 1:")
println("\tschedule(MODULE_NUMBER)")
println("where MODULE_NUMBER is 1,2 or 3")
