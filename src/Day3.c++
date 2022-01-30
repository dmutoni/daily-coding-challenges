#include <iostream>
#include <sstream>
#include <string>

using namespace std;
// Node that has a string value, pointer to the next node, and pointer to the previous node
struct Node
{
    string value;
    Node *left;
    Node *right;
};

Node new_node(string value)
{
    Node temp_node = {value};
    return temp_node;
}

string serialize(Node tree)
{
    string val;
    string left;
    string right;
    val = tree.value;

    if (tree.left)
    {
        left = serialize(*(tree.left));
    }
    else
    {
        left = "-";
    }
    if (tree.right)
    {
        right = serialize(*(tree.right));
    }
    else
    {
        right = "-";
    }

    string res = val + ',' + left + ',' + right;
    return res;
}

void deserialize_helper(vector<string> &res, Node **tree)
{

    if (!res.empty() && res.front() != "-")
    {
        *tree = new Node;
        (*tree)->value = res.front();
        res.erase(res.begin());

        deserialize_helper(res, &((*tree)->left));
        deserialize_helper(res, &((*tree)->right));
    }

    else if (!res.empty && res.front() == "-")
    {
        res.erase(res.begin());
    }
}
Node deserialize(string serialized_tree)
{
    Node *result_node;
    istringstream iss(serialized_tree);
    string token;
    vector<string> res;

    while (getline(iss, token, ','))
    {
        res.push_back(token);
    }
    deserialize_helper(res, &result_node);

    return *result_node;
}

int main()
{
    Node left_left = new_node("left_left");
    Node left = new_node("left");
    left.left = &left_left;
    Node right = new_node("right");
    Node root = new_node("root");
    root.left = &left;
    root.right = &right;

    std::string result = serialize(root);
    std::cout << "Serialized: \t\t" << result << "\n";

    Node deserialized;
    deserialized = deserialize(result);
    std::cout << "Deserialized: \t\t" << serialize(deserialized) << "\n";

    bool assert;
    assert = (root.left->left->value == deserialized.left->left->value);

    std::cout << "The bool comparison is: " << assert << "\n";

    return 0;
}