import { HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Student } from "./student";
import { StudentService } from "./student.service";




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private students: Student[] | undefined;
  constructor(private studentService: StudentService) { }
  ngOnInit(): void {
    this.getStudents();
  }
  public getStudents(): void {
    this.studentService.getStudent().subscribe(
      (response: Student[]) => {
        this.students = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}



/*

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public: Student[];
  constructor(private studentService: StudentService) { }
  ngOnInit() {
    this.getStudents();
  }
  public getStudents(): void {
    this.studentService.getStudent().subscribe(
      (response: Student[]) => {
        this.students = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

}
*/

