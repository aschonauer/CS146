from typing import Optional, List


class TreeNode(object):

    def __init__(self, val=None, color="red", left=None, right=None, parent=None):

        self.val = val

        self.left = left
        if not left and val:
            self.left = TreeNode(None, "black")

        self.right = right
        if not right and val:
            self.right = TreeNode(None, "black")

        self.color = color

        self.parent = parent


def balance_insert(self, node):
    while node.parent.color == "red":
        if node.parent == node.parent.parent.right:
            uncle = node.parent.parent.left
            if uncle.color == "red":
                uncle.color = "black"
                node.parent.color = "black"
                node.parent.parent.color = "red"
                node = node.parent.parent
            else:
                if node == node.parent.left:
                    node = node.parent
                    rotateRight(rotateRight, node)
                node.parent.color = "black"
                node.parent.parent.color = "red"
                rotateLeft(rotateLeft, node.parent.parent)
        else:
            uncle = node.parent.parent.right
            if uncle.color == "red":
                uncle.color = "black"
                node.parent.color = "black"
                node.parent.parent.color = "red"
                node = node.parent.parent
            else:
                if node == node.parent.right:
                    node = node.parent
                    rotateLeft(rotateLeft, node)
                node.parent.color = "black"
                node.parent.parent.color = "red"
                rotateRight(rotateRight, node.parent.parent)
        if not node.parent:
            node.color = "black"
            return node
    current = node
    while current.parent:
        current = current.parent
    return current


def rotateRight(self, node):
    node2 = node.left
    node.left = node2.right
    if node2.right.val:
        node2.right.parent = node

    node2.parent = node.parent
    if not node.parent:
        node2.color = "black"
    elif node == node.parent.right:
        node.parent.right = node2
    else:
        node.parent.left = node2
    node2.right = node
    node.parent = node2


def rotateLeft(self, node):
    node2 = node.right
    node.right = node2.left
    if node2.left.val:
        node2.left.parent = node

    node2.parent = node.parent
    if not node.parent:
        node2.color = "black"
    elif node == node.parent.left:
        node.parent.left = node2
    else:
        node.parent.right = node2
    node2.left = node
    node.parent = node2


def treeInsert(self, root, new_val):
    new = TreeNode(new_val)
    current = root
    prev = current
    while current.val:
        prev = current
        if new.val < current.val:
            current = current.left
        else:
            current = current.right

    new.parent = prev
    if not prev.val:
        new.color = "black"
        return root
    elif new.val < prev.val:
        prev.left = new
    else:
        prev.right = new

    if not new.parent.parent:
        return root

    root = balance_insert(balance_insert, new)
    return root


def balance_delete(self, node):
    while node.parent and node.color == "black":
        if node == node.parent.left:
            sibling = node.parent.right
            if sibling.right:
                sr_color = sibling.right.color
            else:
                sr_color = "black"
            if sibling.left:
                sl_color = sibling.right.color
            else:
                sl_color = "black"

            if sibling.color == "red":
                sibling.color = "black"
                node.parent.color = "red"
                rotateLeft(rotateLeft, node.parent)
                sibling = node.parent.right
            if sl_color == "black" and sr_color == "black":
                sibling.color = "red"
                node = node.parent
            else:
                if sr_color == "black":
                    sibling.left.color = "black"
                    sibling.color = "red"
                    rotateRight(rotateRight, sibling)
                    sibling = node.parent.right
                sibling.color = node.parent.color
                node.parent.color = "black"
                sibling.right.color = "black"
                rotateLeft(rotateLeft, node.parent)
                while node.parent:
                    node = node.parent
        else:
            sibling = node.parent.left
            if sibling.left:
                sl_color = sibling.left.color
            else:
                sl_color = "black"
            if sibling.right:
                sr_color = sibling.right.color
            else:
                sr_color = "black"

            if sibling == "red":
                sibling.color = "black"
                node.parent.color = "red"
                rotateRight(rotateRight, node.parent)
                sibling = node.parent.left
            if sr_color == "black" and sl_color == "black":
                sibling.color = "red"
                node = node.parent
            else:
                if sl_color == "black":
                    sibling.right.color = "black"
                    sibling.color = "red"
                    rotateLeft(rotateLeft, sibling)
                    sibling = node.parent.left
                sibling.color = node.parent.color
                node.parent.color = "black"
                sibling.left.color = "black"
                rotateRight(rotateRight, node.parent)
                while node.parent:
                    node = node.parent

    node.color = "black"
    root = node
    while root.parent:
        root = root.parent
    return root


def transplant(node1, node2):
    if not node1.parent:
        if node2 is not None:
            node2.color = "black"
    elif node1 == node1.parent.right:
        node1.parent.right = node2
    elif node1 == node1.parent.left:
        node1.parent.left = node2
    if node2 is not None:
        node2.parent = node1.parent


def treeDelete(self, root, val):
    delete = treeFind(treeFind, root, val)
    if not delete:
        return root

    min = delete
    orig_color = min.color
    if delete.left.val is None:
        temp_tree = delete.right
        transplant(delete, delete.right)
    elif delete.right.val is None:
        temp_tree = delete.left
        transplant(delete, delete.left)
    else:
        min = minTree(delete.right)
        orig_color = min.color
        temp_tree = min.right
        if min.parent == delete:
            temp_tree.parent = min
        else:
            transplant(min, min.right)
            min.right = delete.right
            min.right.parent = min
        transplant(delete, min)
        min.left = delete.left
        min.left.parent = min
        min.color = delete.color
    if orig_color == "black":
        root = balance_delete(balance_delete, temp_tree)
    return root


def minTree(root):
    min = root
    if root.left.val is not None:
        num = minTree(root)
        if num.val < min.val:
            min = num
    return min

def treeFind(self, root, target_val):
    target = TreeNode()
    if root.val is None:
        return
    if root.val == target_val:
        return root
    elif root.val > target_val:
        target = treeFind(treeFind, root.left, target_val)
    elif root.val < target_val:
        target = treeFind(treeFind, root.right, target_val)
    return target


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


root = TreeNode(5)
root.color = "black"

root = treeInsert(treeInsert, root, 4)
root = treeInsert(treeInsert, root, 11)
root = treeInsert(treeInsert, root, 8)
root = treeInsert(treeInsert, root, 12)
root = treeInsert(treeInsert, root, 13)
root = treeInsert(treeInsert, root, 14)
levels = levelOrder(levelOrder, root)
for level in levels:
    print(level)

root = treeInsert(treeInsert, root, 15)
levels = levelOrder(levelOrder, root)
for level in levels:
    print(level)
print("Insertion of 15 success!")
print()

root = treeDelete(treeDelete, root, 12)
levels = levelOrder(levelOrder, root)
for level in levels:
    print(level)
print("Deletion of 12 success!")

root = treeDelete(treeDelete, root, 5)
print()
levels = levelOrder(levelOrder, root)
for level in levels:
    print(level)
print("Deletion of 5 success!")
print()

root = treeDelete(treeDelete, root, 4)
root = treeDelete(treeDelete, root, 8)
levels = levelOrder(levelOrder, root)
for level in levels:
    print(level)
print("Deletion of 4 and 8 success")
