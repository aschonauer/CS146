def longestPalindrome(self, s):
    letters = []
    for letter in s:
        letters.append(letter)
    letters.sort()
    pal = []

    for i in range(0, len(letters) - 1):
        for j in range(i+1, len(letters)):
            if letters[i] == letters[j] and letters[i] != "EMPTY" and letters[j] != "EMPTY":
                pal.append(letters[i])
                pal.insert(0, letters[j])
                letters[i] = "EMPTY"
                letters[j] = "EMPTY"

    for letter in letters:
        if letter != "EMPTY":
            pal.insert(int(len(pal) / 2), letter)
            break

    print("One longest palindrome is: ", pal)
    print("The length is: ", len(pal))


if __name__ == '__main__':
    letterString = input("Enter a string: ")
    longestPalindrome(longestPalindrome, letterString)
