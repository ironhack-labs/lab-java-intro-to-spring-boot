package az.lab.intro.entity;



public class EmployeeEntity {
    
        private String department;

        private String name;

        private String status;

        public EmployeeEntity(String name, String department, String status) {
            this.name = name;
            this.department = department;
            this.status = status;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        


        

}
