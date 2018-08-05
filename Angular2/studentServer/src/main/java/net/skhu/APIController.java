package net.skhu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api")
public class APIController {

    @Autowired StudentRepository studentRepository;
    @Autowired DepartmentRepository departmentRepository;

    @RequestMapping("students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @RequestMapping("student/{id}")
    public Student student(@PathVariable("id") int id) {
        return studentRepository.findOne(id);
    }

    @RequestMapping(value="student", method=RequestMethod.POST)
    public String studentSave(@RequestBody Student student) {
        studentRepository.save(student);
        return "저장성공";
    }

    @RequestMapping(value="student/{id}", method=RequestMethod.DELETE)
    public String studentDelete(@PathVariable("id") int id) {
        studentRepository.delete(id);
        return "삭제성공";
    }

    @RequestMapping("departments")
    public List<Department> departments() {
        return departmentRepository.findAll();
    }
}