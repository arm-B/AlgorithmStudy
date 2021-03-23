#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char Data;

typedef struct TreeNode {
	Data data;
	struct TreeNode* left, * right;
}TreeNode;

TreeNode* getNode(Data data) {
	TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
	node->data = data;
	node->left = NULL;
	node->right = NULL;
	return node;
}

TreeNode* inTree(TreeNode* root, Data data) {
	if (root != NULL) {
		if (root->data == data)
			return root;
		else {
			TreeNode* next = inTree(root->left, data);
			if (next != NULL) {
				return next;
			}
			return inTree(root->right, data);
		}
	}
	return NULL;
}

void setTree(TreeNode* parent, Data data1, Data data2, Data data3) {
	parent->data = data1;
	if (data2 != '.')
		parent->left = getNode(data2);
	if (data3 != '.')
		parent->right = getNode(data3);
}

void pre(TreeNode* root) {
	if (root == NULL)
		return;
	printf("%c", root->data);
	pre(root->left);
	pre(root->right);
}

void in(TreeNode* root) {
	if (root == NULL)
		return; 
	in(root->left);
	printf("%c", root->data);
	in(root->right);
}

void post(TreeNode* root) {
	if (root == NULL)
		return;
	post(root->left);
	post(root->right);
	printf("%c", root->data);
}

int main() {

	TreeNode* root = getNode(NULL);
	TreeNode* parent;

	int n;
	scanf("%d", &n);
	getchar();
	for (int i = 0; i < n; i++) {
		int j=0;
		char data1, data2, data3;
		scanf("%c %c %c", &data1, &data2, &data3);
		getchar();;
		parent = inTree(root, data1);
		if (parent != NULL)
			setTree(parent, data1, data2, data3);
		else
			setTree(root, data1, data2, data3);		

	}

	pre(root);
	printf("\n");
	in(root);
	printf("\n");
	post(root);
	printf("\n");

	//企酵 嬢戚蒸製戚...
	//脊径 閤澗 暗 嬢胸惟 拝走 侯虞辞 嬢照戚 此此 1
	//pre in post澗 硝走 悦汽 闘軒 幻球形艦猿 嬢照戚 此此 2
	//展切 帖奄 瑛諾陥壱 pre 差紫背辞 in戚櫛 post拭 細食隔壱
	//照 壱弾製 嬢照戚 此此 3
	//せせせせせせせせ馬焼 坪漁戚櫛 照 限澗 暗 旭焼政....^ば
}