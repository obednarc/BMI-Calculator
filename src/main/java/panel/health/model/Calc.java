package panel.health.model;


public class Calc {

    public static class OperationModel {

        private String operation;
        private double weight;
        private double height;
        /*private int age;*/

        public OperationModel() {
        }

        /*public OperationModel(int age) {
            this.age = age;
        }
*/
        public OperationModel(String operation) {
            this.operation = operation;
        }

        public OperationModel(double weight, double height) {
            this.weight = weight;
            this.height = height;
        }


        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

       /* public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }*/
    }

}
