package folder.design_patterns;
class Student{
    private int roll;
    private String name;

    public Student(StudentBuilder studentBuilder){
        this.name = studentBuilder.name;
        this.roll = studentBuilder.roll;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    static class StudentBuilder{
        private int roll;
        private String name;

        public StudentBuilder(){

        }

        public StudentBuilder setRoll(int roll) {
            this.roll = roll;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Student build(){
            Student student = new Student(this);
            return student;
        }
    }
}


 class Test {
    public static void main(String[] args) {
     Student student = new Student.StudentBuilder().setName("Sid").setRoll(1).build();
    }
}
