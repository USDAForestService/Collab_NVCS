'''
Created on Mar 22, 2013

@author: knimerfro
'''

class Node:
    def __init__(self, ident, parent, match_function, description):
        self.ident = ident
        self.parent = parent
        self.match_function = match_function
        self.description = description
        self.children = []

    def __repr__(self):
        return "Node(%r, %r, %r, %r)" % (self.ident, self.parent, self.match_function, self.description)

class Solution:
    def __init__(self, obj, path):
        self.obj = obj
        self.path = path
        
    def __repr__(self):
        return "Solution(%r, %r)" % (self.obj, self.path)

class Classifier:  
    def __init__(self, key):
        self.root_node = key.root_node

    def __repr__(self):
        return "Classifier(%r, %r)" % (self.root_node)

    def choose(self, nodes, obj):
        for node in nodes:
            if node.match_function(obj):
                return node
        return None

    def walk(self, root_node, obj):
        node = root_node
        while node is not None and node.children:
            node = self.choose(node.children, obj)
            yield node

    def classify(self, obj):
        path = [node for node in self.walk(self.root_node, obj)]
        return Solution(obj, path)
