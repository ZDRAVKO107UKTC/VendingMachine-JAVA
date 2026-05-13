import com.vendingmachine.command.*;
import com.vendingmachine.display.ConsoleDisplay;
import com.vendingmachine.display.IDisplay;
import com.vendingmachine.dispenser.StandardDispenser;
import com.vendingmachine.inventory.VendingInventory;
import com.vendingmachine.loader.DefaultProductLoader;
import com.vendingmachine.machine.IVendingMachineController;
import com.vendingmachine.machine.StandardVendingMachine;
import com.vendingmachine.payment.CashPaymentProcessor;
import com.vendingmachine.revenue.RevenueTracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VendingInventory inventory = new VendingInventory();
        new DefaultProductLoader().load(inventory);

        IVendingMachineController machine = new StandardVendingMachine(
            inventory,
            new CashPaymentProcessor(),
            new StandardDispenser(),
            new RevenueTracker()
        );

        IDisplay          display  = new ConsoleDisplay();
        ICommandRegistry  registry = new CommandRegistry();

        registry.register(new ListCommand());
        registry.register(new InsertCommand());
        registry.register(new SelectCommand());
        registry.register(new ReturnCommand());
        registry.register(new StatusCommand());
        registry.register(new RestockCommand());
        registry.register(new HelpCommand(registry));
        registry.register(new ExitCommand());

        display.showMessage("=== Vending Machine ===");
        registry.find("help").ifPresent(cmd -> cmd.execute(new String[0], machine, display));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\n> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] tokens  = line.split("\\s+");
            String   name    = tokens[0].equalsIgnoreCase("quit") ? "exit" : tokens[0].toLowerCase();
            String[] cmdArgs = Arrays.copyOfRange(tokens, 1, tokens.length);

            running = registry.find(name)
                .map(cmd -> cmd.execute(cmdArgs, machine, display))
                .orElseGet(() -> { display.showMessage("Unknown command. Type 'help' for commands."); return true; });
        }

        scanner.close();
    }
}
