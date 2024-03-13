class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):
        self.val = val

        self.left = left

        self.right = right


# This function creates an array of nodes in
# in-order traversal order of the tree given the root
def inOrder(self, root):
    left = []
    right = []
    if root.left:
        left = inOrder(inOrder, root.left)
    if root.right:
        right = inOrder(inOrder, root.right)
    arr = []
    for node in left:
        arr.append(node)
    arr.append(root)
    for node in right:
        arr.append(node)
    return arr


# Checks to see if the BST is valid and returns a bool
def isValidBST(self, root):
    # Make a bound? optimal is 5 lines
    # is valid until proven false
    valid = True
    # gets an array of the BST in in-order traversal
    array = inOrder(inOrder, root)
    # for each node in the array it compares if the one
    # after is bigger than the current one. If it is not
    # then this is not a valid BST since it should be
    # in ascending order in in-order traversal if it is valid.
    for i in range(len(array) - 1):
        if array[i].val >= array[i+1].val:
            valid = False
    return valid


root4 = TreeNode(4)
node3 = TreeNode(3)
node2 = TreeNode(2)
node1 = TreeNode(1)
node5 = TreeNode(5)
node6 = TreeNode(6)
node7 = TreeNode(7)
node8 = TreeNode(8)
node9 = TreeNode(9)

root4.left = node3
root4.right = node8
node3.left = node1
node8.left = node7
node8.right = node9

print(isValidBST(isValidBST, root4))
