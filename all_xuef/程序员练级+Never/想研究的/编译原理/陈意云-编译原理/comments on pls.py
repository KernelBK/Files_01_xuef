

#类型系统与 C
"""
并不是 = 两侧类型相等，就可以赋值。
对于C 语言，数组名因为有特殊含义(首元素地址，是个常量)，而不能位于 = 左侧。
"""

# C 的指针运算
"""
p 是指针， p + 1 前进多少字节，这取决于 p指向的内容的字节长度。
int * p; // 那么 p + 1 前进四个字节！！！

"""
