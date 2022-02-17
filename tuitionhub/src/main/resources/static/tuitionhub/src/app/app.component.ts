import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { StudentService } from './student.service';
import { Student } from './student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public students: Student[];
  constructor(private studentService: StudentService) { }
  ngOnInit() {
    this.getStudents();
  }
  public getStudents(): void {
    this.studentService.getStudent().subscribe(
      (response: Student[]) => {
        this.student = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

}

