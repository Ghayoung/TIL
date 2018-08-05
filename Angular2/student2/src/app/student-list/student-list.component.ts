import { Component, OnInit } from '@angular/core';
import { Student } from '../Student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  selectedIndex: number = -1;
  selectedStudent: Student;

  students: Student[] = [
    new Student(1, '201132051', '홍길동', 'hgd@skhu.ac.kr'),
    new Student(2, '201132052', '임꺽정', 'lkj@skhu.ac.kr'),
    new Student(3, '201132053', '전우치', 'jwc@skhu.ac.kr'),
  ];

  constructor() { }
  ngOnInit() { }

  selectStudent(student: Student, index: number) {
    this.selectedStudent = Object.create(student);
    this.selectedIndex = index;
  }

  createStudent() {
    let lastIndex = this.students.length - 1;
    let id = this.students[lastIndex].id + 1;
    this.selectedStudent = new Student(id, "", "", "");
    this.selectedIndex = -1;
  }  

  close() {
    this.selectedStudent = null;
    this.selectedIndex = -1;
  }  

  save() {
    if (this.selectedIndex == -1)
      this.students.push(this.selectedStudent);
    else 
      this.students[this.selectedIndex] = this.selectedStudent;
    this.selectedStudent = null;
    this.selectedIndex = -1;
  }

  deleteStudent() {
    if (confirm("삭제하시겠습니까?")) {
      this.students.splice(this.selectedIndex, 1);
      this.selectedStudent = null;
      this.selectedIndex = -1;
    }
  }  
}