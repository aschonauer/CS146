print("Enter two words to test if they are anagrams of each other")
word1 = input("Enter a word: ")
word2 = input("Enter a second word: ")
word1 = word1.lower().replace(" ", "")
word2 = word2.lower().replace(" ", "")

letters1 = list(word1)
letters2 = list(word2)

letters1.sort()
letters2.sort()

if letters1 == letters2:
    print("true")
else:
    print("false")
