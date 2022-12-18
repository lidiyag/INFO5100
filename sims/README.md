### Student Information Management System

Build and Run the application 

To access login page => localhost:8080

To access h2 db console => localhost:8080/h2-console

               DB name  => sims
               JDBC URL => jdbc:h2:mem:sims
               username => sa
               password => For user sa, connects without password
               driver   => org.h2.Driver


## Application Run Instructions

Run the application after successful build from IDE. Go to localhost:8080 from browser. Login using the admin credentials into the admin account. Viewing, adding, updating and deleting students and courses can be performed from here. Open another browser tab and login to student account using a student credential(Use one in database loader or create a new student from admin login and use the same credentials). By default the login password for new student created is "student". From student login , everything related to that particular student can be viewed like profile,attendance,courses available and fees.
