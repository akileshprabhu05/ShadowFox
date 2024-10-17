import java.util.*;

class PersonContact {
    private String fullName;
    private String phoneNumber;
    private String emailAddress;

    public PersonContact(String fullName, String phoneNumber, String emailAddress) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return "Full Name: " + fullName + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

public class ContactManager {
    static ArrayList<PersonContact> contactList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n-- Contact Manager Application --");
            System.out.println("1. Add a New Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Edit an Existing Contact");
            System.out.println("4. Remove a Contact");
            System.out.println("5. Exit Application");
            System.out.print("Please select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    System.out.println("Closing the application. Have a great day!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void addNewContact() {
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email Address: ");
        String emailAddress = scanner.nextLine();

        contactList.add(new PersonContact(fullName, phoneNumber, emailAddress));
        System.out.println("Contact added successfully!");
    }

    public static void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println((i + 1) + ". " + contactList.get(i));
            }
        }
    }

    public static void editContact() {
        System.out.print("Enter the number of the contact you want to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  
        if (index >= 0 && index < contactList.size()) {
            PersonContact contact = contactList.get(index);
            System.out.print("Enter new name (leave blank to keep unchanged): ");
            String fullName = scanner.nextLine();
            System.out.print("Enter new phone (leave blank to keep unchanged): ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email (leave blank to keep unchanged): ");
            String emailAddress = scanner.nextLine();

            if (!fullName.isEmpty()) contact.setFullName(fullName);
            if (!phoneNumber.isEmpty()) contact.setPhoneNumber(phoneNumber);
            if (!emailAddress.isEmpty()) contact.setEmailAddress(emailAddress);

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    public static void removeContact() {
        System.out.print("Enter the number of the contact you want to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < contactList.size()) {
            contactList.remove(index);
            System.out.println("Contact removed successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }
}
