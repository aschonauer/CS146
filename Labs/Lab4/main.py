class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):
        self.val = val

        self.left = left

        self.right = right


def invertTree(self, root):
    # if there is no root exit
    if not root:
        return root
    # if there is a left node go down the tree
    if root.left:
        invertTree(invertTree, root.left)
    # if there is a right node go down the tree
    if root.right:
        invertTree(invertTree, root.right)
    # swap the nodes at the bottom if one was empty then it still can swap
    temp = root.left
    root.left = root.right
    root.right = temp
    return root


# Creates test Tree
root = TreeNode(1)
node1 = TreeNode(2)
node2 = TreeNode(8)
root.left = node1
root.right = node2

node3 = TreeNode(3)
node4 = TreeNode(4)
node1.left = node3
node1.right = node4

node5 = TreeNode(5)
# node6 = TreeNode(6)
node2.left = node5
# node2.right = node6

# Print test tree
print(root.val)
print(root.left.val, root.right.val)
print(root.left.left.val, root.left.right.val, root.right.left.val)
# Invert test tree
invertTree(invertTree, root)
# Print inverted test tree
print(root.val)
print(root.left.val, root.right.val)
print("", root.left.right.val, root.right.left.val, root.right.right.val)
