import { Injectable } from '@angular/core';
import { Http }       from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Student } from './Student';
import { Department } from './Department';

@Injectable()
export class ServerService {
  private URL = 'http://localhost:8080/studentServer/api/';
  private http: Http;

  constructor(http: Http) { 
    this.http = http;
  }
  
  getStudents(): Promise<Student[]> {
    return this.http.get(this.URL + "students")
              .toPromise()
              .then(response => response.json() as Student[])
              .catch(this.handleError);
  }

  getStudent(id: number): Promise<Student> {
    let url = this.URL + 'student/' + id;
    return this.http.get(url)
              .toPromise()
              .then(response => response.json() as Student[])
              .catch(this.handleError);
  }

  getDepartments(): Promise<Department[]> {
    return this.http.get(this.URL + "departments")
              .toPromise()
              .then(response => response.json() as Department[])
              .catch(this.handleError);
  }  
  
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}