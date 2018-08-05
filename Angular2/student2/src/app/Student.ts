export class Student {
    id: number;
    studentNo: string;
    name: string;
    email: string;

    public constructor(id: number, studentNo: string, name: string, email: string) {
        this.id = id;
        this.studentNo = studentNo;
        this.name = name;
        this.email = email;
    }
}