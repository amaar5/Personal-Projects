import random

def choose_word():
    words = ["cooked", "grab", "nuggets", "python", "Montclair"]
    return random.choice(words)

def display_word(word, guessed_letters):
    display = ""
    for letter in word:
        if letter in guessed_letters:
            display += letter
        else:
            display += "_"
    return display

def hangman():
    word = choose_word()
    guessed_letters = []
    attempts = 6

    print("Hangman")
    print("Guess the word but you only have 6 tries")

    while attempts > 0:
        print("\nWord:", display_word(word, guessed_letters))
        guess = input("Enter a letter: ").lower()

        if guess in guessed_letters:
            print("You've already guessed that letter")
        elif guess in word:
            print("Correct")
            guessed_letters.append(guess)
            if all(letter in guessed_letters for letter in word):
                print("That is the correct word:", word)
                return
        else:
            print("WRONG")
            attempts -= 1
            print("Attempts left:", attempts)
            if attempts == 0:
                print("You lost...The word was:", word)
                return

if __name__ == "__main__":
    hangman()
