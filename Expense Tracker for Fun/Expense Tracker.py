import csv
import os

def load_expenses():
    expenses = []
    if os.path.exists("expenses.csv"):
        with open("expenses.csv", "r") as file:
            reader = csv.reader(file)
            for row in reader:
                expenses.append(row)
    return expenses

def save_expenses(expenses):
    with open("expenses.csv", "w", newline="") as file:
        writer = csv.writer(file)
        writer.writerows(expenses)

def display_menu():
    print("Expense Tracker")
    print("1. View Expenses")
    print("2. Add Expense")
    print("3. Delete Expense")
    print("4. Exit")

def view_expenses(expenses):
    print("Date\t\tCategory\tDescription\tAmount")
    for expense in expenses:
        print("\t".join(expense))

def add_expense(expenses):
    date = input("Enter date (YYYY-MM-DD): ")
    category = input("Enter category: ")
    description = input("Enter description: ")
    amount = input("Enter amount: ")
    expenses.append([date, category, description, amount])
    print("Expense added successfully")

def delete_expense(expenses):
    view_expenses(expenses)
    index = int(input("Enter index of expense to delete: ")) - 1
    if 0 <= index < len(expenses):
        del expenses[index]
        print("Expense deleted successfully.")
    else:
        print("Invalid index.")

def main():
    expenses = load_expenses()
    while True:
        display_menu()
        choice = input("Enter your choice: ")
        if choice == "1":
            view_expenses(expenses)
        elif choice == "2":
            add_expense(expenses)
        elif choice == "3":
            delete_expense(expenses)
        elif choice == "4":
            save_expenses(expenses)
            print("Exiting")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
