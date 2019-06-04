# sh-core
The core interfaces and utilities for the Super Helpful Quiz.

The Super Helpful Quiz is a quiz generation tool I developed primarily as an ad hoc, but extensible way to generate quizes to help keep my children sharp on their math over the summer. It's function is inspired buy a flashcard-like tool I built for myself while in college, which I credit with keeping me sharp enough to earn a masters in physics. The quizes version is modeled on semi-random quizes my kids take as part of their curriculum. The architecture is one I've developed personally for general application development. I built features into this tool which I am not yet taking advantage of, with the hope that I might eventually use machine learning or statistical methods to do some guided learning.

The primary documentation for the Super Helpful Quiz is is the `sh-main` project. 

The `sh-main` project has a `test_run` task which will execute the compiled project.

The `sh-main` project has a `create_deliverable` task which will create a ZIP file in sh-main/dist. This ZIP file contains the installation directory structure of the program such that one can simply unzip the file to install the application wherever one chooses.
