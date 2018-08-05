import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentList1Component } from './student-list1.component';

describe('StudentList1Component', () => {
  let component: StudentList1Component;
  let fixture: ComponentFixture<StudentList1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentList1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentList1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
