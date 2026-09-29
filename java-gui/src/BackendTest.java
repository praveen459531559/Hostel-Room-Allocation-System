import gui.BackendController;

public class BackendTest {

    public static void main(String[] args) {

        System.out.println("Starting connection test...");

        BackendController.startBackend();

        String result =
                BackendController.searchStudent(24001);

        System.out.println(
                "Java received: " + result
        );

        BackendController.closeBackend();

        System.out.println(
                "Connection test completed."
        );
    }
}