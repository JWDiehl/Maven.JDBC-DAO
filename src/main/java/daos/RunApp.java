package daos;

public class RunApp {

    public static void main(String[] args) {

        DAO dao = new CarDAO();

        dao.findById(4);
    }
}
