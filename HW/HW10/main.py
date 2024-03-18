from typing import Optional, List


class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):
        self.val = val

        self.left = left

        self.right = right


def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    if not root:
        return []
    level_list = [[root.val]]
    pop_nodes = [root]
    while pop_nodes:
        length = len(pop_nodes)
        for i in range(length):
            popped = pop_nodes.pop(0)
            if popped.left:
                pop_nodes.append(popped.left)
            if popped.right:
                pop_nodes.append(popped.right)
        pop_values = []
        for node in pop_nodes:
            pop_values.append(node.val)
        if pop_values:
            level_list.append(pop_values)
    return level_list


root = TreeNode(4)
node1 = TreeNode(1)
node2 = TreeNode(2)
node3 = TreeNode(3)
node4 = TreeNode(4)
node5 = TreeNode(5)
node6 = TreeNode(6)
node7 = TreeNode(7)
node8 = TreeNode(8)
node9 = TreeNode(9)

root.left = node7
root.right = node8

node7.left = node1

node1.left = node4

node8.left = node5
node8.right = node9

node5.right = node2

node2.left = node6

levels = levelOrder(levelOrder, root)

for level in levels:
    print(level)
