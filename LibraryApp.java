import java.util.*;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        IssueDAO issueDAO = new IssueDAO();

        while (true) {

            System.out.println("\n1. Add Books");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:
                        List<Book> list = new ArrayList<>();
                        System.out.println("How many books?");
                        int n = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < n; i++) {

                            System.out.println("Title:");
                            String title = sc.nextLine();

                            System.out.println("Author:");
                            String author = sc.nextLine();

                            System.out.println("Quantity:");
                            int qty = sc.nextInt();
                            sc.nextLine();

                            list.add(new Book(title, author, qty));
                        }

                        bookDAO.addBooks(list);
                        break;

                    case 2:
                        bookDAO.viewBooks();
                        break;

                    case 3:
                        System.out.println("Enter Book ID:");
                        int bookId = sc.nextInt();
                        issueDAO.issueBook(bookId);
                        break;

                    case 4:
                        System.out.println("Enter Issue ID:");
                        int issueId = sc.nextInt();
                        issueDAO.returnBook(issueId);
                        break;

                    case 5:
                        System.out.println("Program Ended.");
                        System.exit(0);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
}