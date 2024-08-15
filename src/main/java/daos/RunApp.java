package daos;

public class RunApp {

    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();
//        DAO dao = new CarDAO();
//
//        dao.findById(4);

//        //create a new car
//        CarDTO newCar = new CarDTO(6,"Alfa Romeo", "Giulia", 2024, "Black", "5UXTS1C55F0L12345");
//        CarDTO createdCar = carDAO.create(newCar);
//        System.out.print("Created Car: " + createdCar.getId());

        //read all cars
        System.out.println("All Cars: ");
        carDAO.findAll().forEach(car -> System.out.println(car.getMake() + " " + car.getModel()));
//
//        //update a car
//        CarDTO carToUpdate = carDAO.findById(createdCar.getId());
//        carToUpdate.setColor("Orange");
//        CarDTO updatedCar = carDAO.update(carToUpdate);
//        System.out.println("Updated Car Color: " + updatedCar.getColor());
//
        //delete a car
        carDAO.delete(12);
        System.out.println("Car deleted.");

        //verify deletion
        System.out.println("All Cars After Deletion:");
        carDAO.findAll().forEach(car -> System.out.println(car.getMake() + " " + car.getModel()));
    }
}
