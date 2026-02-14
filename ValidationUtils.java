 // Validation for Age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age,Set age = 18");
            this.age = 18;
        }
    }

    // Validation for Grade
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade,Set default grade = 0");
            this.grade = 0;
        }
    }