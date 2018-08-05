import { Component, OnInit } from '@angular/core';
import { Student } from '../Student';
import { ServerService } from '../server.service';

@Component({
  selector: 'app-student-list1',
  templateUrl: './student-list1.component.html',
  styleUrls: ['./student-list1.component.css']
})
export class StudentList1Component implements OnInit {
  private serverService: ServerService;
  private students: Student[];
  
  constructor(serverService: ServerService) { 
    this.serverService = serverService;
  }

  ngOnInit() {
    this.serverService.getStudents().then(
      students => this.students = students
    );
  }
}