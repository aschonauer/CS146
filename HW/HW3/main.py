

def insSort(array):
    integers = True
    try:
        float(array[0])
    except ValueError:
        integers = False

    if integers:
        for i in range(0, len(array)):
            array[i] = float(array[i])

    for i in range(1, len(array)):
        item = array[i]
        j = i - 1
        while j >= 0 and array[j] > item:
            array[j+1] = array[j]
            array[j] = item
            j -= 1
    return array


Input = input("Enter array of words or numbers separated by a space: ")
array = Input.split(" ")
array = insSort(array)
print(array)
