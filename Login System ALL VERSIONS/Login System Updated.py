import csv

def load_users(filename):
    users = {}
    try:
        with open(filename, "r") as file:
            reader = csv.reader(file)
            for row in reader:
                users[row[0]] = row[1]
    except FileNotFoundError:
        pass
    return users

def save_users(users, filename):
    with open(filename, "w", newline="") as file:
        writer = csv.writer(file)
        for username, password in users.items():
            writer.writerow([username, password])

def register(users, filename):
    username = input("Enter a username: ")
    if username in users:
        print("Username already exists.")
        return
    password = input("Enter a password: ")
    users[username] = password
    save_users(users, filename)
    print("Registration successful.")

def login(users):
    username = input("Enter your username: ")
    password = input("Enter your password: ")
    if username in users and users[username] == password:
        print("Login successful.")
    else:
        print("Invalid username or password.")

def main():
    filename = "users.csv"
    users = load_users(filename)
    while True:
        print("\n1. Register")
        print("2. Login")
        print("3. Exit")
        choice = input("Enter your choice: ")

        if choice == "1":
            register(users, filename)
        elif choice == "2":
            login(users)
        elif choice == "3":
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
