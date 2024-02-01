word = input("Enter a word to test if it is a palindrome: ")
word = word.lower()
word = word.replace(" ", "")
letters = list(())
wordList = list(())
length = len(word)
for i in range(length):
    letters.append(word[i])
    wordList.append(word[i])

half = int(length / 2)
for i in range(half):
    letter = letters[i]
    mirror = length - i - 1
    letters[i] = letters[mirror]
    letters[mirror] = letter

if letters == wordList:
    print("true")
else:
    print("false")
