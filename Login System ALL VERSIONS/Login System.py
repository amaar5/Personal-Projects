def register(users):
    username = input("Enter a username: ")
    if username in users:
        print("Username already exists.")
        return
    password = input("Enter a password: ")
    users[username] = password
    print("Registration successful.")

def login(users):
    username = input("Enter your username: ")
    password = input("Enter your password: ")
    if username in users and users[username] == password:
        print("Login successful.")
    else:
        print("Invalid username or password.")

def main():
    users = {}
    while True:
        print("\n1. Register")
        print("2. Login")
        print("3. Exit")
        choice = input("Enter your choice: ")

        if choice == "1":
            register(users)
        elif choice == "2":
            login(users)
        elif choice == "3":
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()