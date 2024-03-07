import random
import time

def russian_roulette():
    print("Welcome to Russian Roulette!")
    print("You have a revolver with 6 chambers.")
    print("One of the chambers is loaded. Let's see if you're lucky!")

    chambers = [False] * 6
    chambers[random.randint(0, 5)] = True

    for i in range(6):
        print("Spinning the chamber...")
        time.sleep(1)
        print("Click!")
        time.sleep(1)
        if chambers[i]:
            print("Bang! You're dead!")
            return
        else:
            print("Phew! You survived!")

    print("Congratulations! You survived all 6 rounds!")

if __name__ == "__main__":
    russian_roulette()
