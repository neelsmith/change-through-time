using Pkg
Pkg.activate(".")
Pkg.instantiate()
using CourseCalendar

calfile = joinpath(pwd(), "S23", "calendar1.toml")
topics = joinpath(pwd(), "S23", "topics1.txt")
sched = courseSchedule(calfile, topics)

md = mdcalendar(sched)

hdg = """---
title: "Schedule"
layout: page
nav_order: 1
has_children: true
---

"""

open(joinpath(pwd(), "docs", "schedule", "index.md"), "w") do io
    write(io, hdg * md)
end