import com.kaushal.controller.CommandController;

class CLIApplication{
    private static CommandController commandController = new CommandController();
    public static void main(String[] args) {
        System.out.println("Welcome to CLIApplication for notification.:)");

        commandController.insideCLI();
    }
}