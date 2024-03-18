
# sr is the row, sc is the column
def floodFill(self, image, sr, sc, color):
    if not 0 <= sr < len(image) or not 0 <= sc < len(image[0]):
        return image
    og_color = image[sr][sc]
    image[sr][sc] = color
    if not sr - 1 < 0 and image[sr - 1][sc] == og_color:
        image = floodFill(floodFill, image, sr-1, sc, color)
    if not sc - 1 < 0 and image[sr][sc-1] == og_color:
        image = floodFill(floodFill, image, sr, sc-1, color)
    if not sr + 1 >= len(image) and image[sr + 1][sc] == og_color:
        image = floodFill(floodFill, image, sr+1, sc, color)
    if not sc + 1 >= len(image[0]) and image[sr][sc + 1] == og_color:
        image = floodFill(floodFill, image, sr, sc+1, color)
    return image


image = [[1, 0, 1],
         [1, 0, 1],
         [1, 0, 1],
         [1, 0, 1],
         [0, 1, 0],
         [0, 0, 0],
         [1, 0, 1],
         [1, 1, 1]]


filled_image = floodFill(floodFill, image, 0, 0, 3)
filled_image = floodFill(floodFill, filled_image, 6, 0, 4)
filled_image = floodFill(floodFill, filled_image, 0, 2, 2)
filled_image = floodFill(floodFill, filled_image, 1, 1, 5)
filled_image = floodFill(floodFill, filled_image, 4, 3, 7)
for line in filled_image:
    print(line)

