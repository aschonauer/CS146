class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val

        self.left = left

        self.right = right


def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    node = root
    if p.val < root.val and q.val < root.val:
        node = node.left
    elif p.val > root.val and q.val > root.val:
        node = node.right
    else:
        return root
    return lowestCommonAncestor(lowestCommonAncestor, node, p, q)


# Takes number of nodes and creates root node with inputted val
nodeCount = int(input("Enter number of nodes: "))
root = TreeNode(int(input("Enter root node value: ")))

# Builds the BST
for i in range(nodeCount - 1):
    current = root
    temp = TreeNode(int(input("Enter node value: ")))
    insert = False
    while not insert:
        if current.val > temp.val:
            if not current.left:
                current.left = temp
                insert = True
            else:
                current = current.left
        elif current.val < temp.val:
            if not current.right:
                current.right = temp
                insert = True
            else:
                current = current.right
        else:
            print("All values must be unique!")
            exit()

# Takes in input for which nodes to be used
val1 = int(input("Enter value of node 1: "))
val2 = int(input("Enter value of node 2: "))

# Finds the target nodes to find the common ancestor for them
found = False
current = root
node1 = TreeNode()
node2 = TreeNode()
while not found:
    if val1 == current.val:
        node1 = current
        found = True
    elif val1 < current.val:
        current = current.left
    elif val1 > current.val:
        current = current.right
current = root
found = False
while not found:
    if val2 == current.val:
        node2 = current
        found = True
    elif val2 < current.val:
        current = current.left
    elif val2 > current.val:
        current = current.right

# Find Common ancestor using lowestCommonAncestor
node = lowestCommonAncestor(lowestCommonAncestor, root, node1, node2)
print("Lowest common ancestor: ", node.val)
