import random
import time

def russian_roulette():
    print("Welcome to Russian Roulette Jakub")
    print("You have a revolver with 6 rounds you know how this goes tho")
    print("One of the chambers is loaded. Don't Like Fail")

    chambers = [False] * 6
    chambers[random.randint(0, 5)] = True

    for i in range(6):
        print("Spinning the chamber")
        time.sleep(1)
        print("Click!")
        time.sleep(1)
        if chambers[i]:
            print("BoP")
            return
        else:
            print("YOU ACTUALLY WON")

    print("Good job jakub")

if __name__ == "__main__":
    russian_roulette()
